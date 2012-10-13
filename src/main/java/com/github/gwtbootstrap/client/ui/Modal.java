/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasVisibility;
import com.github.gwtbootstrap.client.ui.base.HasVisibleHandlers;
import com.github.gwtbootstrap.client.ui.base.IsAnimated;
import com.github.gwtbootstrap.client.ui.constants.BackdropType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.DismissType;
import com.github.gwtbootstrap.client.ui.event.HiddenEvent;
import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownEvent;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.github.gwtbootstrap.client.ui.plugin.Modal.ModalHandler;
import com.github.gwtbootstrap.client.ui.plugin.Modal.Option;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashSet;
import java.util.Set;

//@formatter:off
/**
 * Popup dialog with optional header and {@link ModalFooter footer.}
 * <p>
 * By default, all other Modals are closed once a new one is opened. This
 * setting can be {@link #setHideOthers(boolean) overridden.}
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Modal title="My Modal" backdrop="STATIC">
 *     <g:Label>Modal Content!</g:Label>
 *     <b:ModalFooter>
 *         <b:Button icon="FILE">Save</b:Button>
 *     </b:ModalFooter>
 * </b:Modal>
 * }
 * </pre>
 * 
 * All arguments are optional.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 * 
 * @see <a
 *      href="http://twitter.github.com/bootstrap/javascript.html#modals">Bootstrap
 *      documentation</a>
 * @see PopupPanel
 */
// @formatter:on
public class Modal extends DivWidget implements HasVisibility,
        HasVisibleHandlers, IsAnimated {

    private static Set<Modal> currentlyShown = new HashSet<Modal>();

    private final DivWidget header = new DivWidget();

    private final DivWidget body = new DivWidget("modal-body");

    private boolean keyboard = true;

    private BackdropType backdropType = BackdropType.NORMAL;

    private boolean show = false;

    private boolean hideOthers = true;

    private boolean configured = false;

    private Close close = new Close(DismissType.MODAL);

    private ModalHandler modalHandler;

    /**
     * Creates an empty, hidden widget.
     */
    public Modal() {
        super("modal");
        super.add(header);
        super.add(body);
        setVisible(false);
    }

    /**
     * Creates an empty, hidden widget with specified show behavior.
     * 
     * @param animated
     *            <code>true</code> if the widget should be animated.
     * 
     */
    public Modal(boolean animated) {
        this(animated, false);
    }

    /**
     * Creates an empty, hidden widget with specified show behavior.
     * 
     * @param animated
     *            <code>true</code> if the widget should be animated.
     * 
     * @param dynamicSafe
     *            <code>true</code> removes from RootPanel when hidden
     */
    public Modal(boolean animated, boolean dynamicSafe) {
        this();
        setAnimation(animated);
        setDynamicSafe(dynamicSafe);
    }

    /**
     * Setup the modal to prevent memory leaks. When modal is hidden, will
     * remove all event handlers, and them remove the modal DOM from document
     * DOM.
     * 
     * Default is false.
     * 
     * @param dynamicSafe
     */
    public void setDynamicSafe(boolean dynamicSafe) {
        if (dynamicSafe) {
            addHiddenHandler(new HiddenHandler() {

                @Override
                public void onHidden(HiddenEvent hiddenEvent) {
                    unsetHandlerFunctions(getElement());
                    Modal.this.removeFromParent();
                }
            });
        }
    }

    /**
     * Sets the title of the Modal.
     * 
     * @param title
     *            the title of the Modal
     */
    @Override
    public void setTitle(String title) {

        header.clear();
        if (title == null || title.isEmpty()) {
            showHeader(false);
        } else {

            header.add(close);
            header.add(new Heading(3, title));
            showHeader(true);
        }
    }

    private void showHeader(boolean show) {
        if (show)
            header.setStyleName(Constants.MODAL_HEADER);
        else
            header.removeStyleName(Constants.MODAL_HEADER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAnimation(boolean animated) {
        if (animated)
            addStyleName(Constants.FADE);
        else
            removeStyleName(Constants.FADE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getAnimation() {
        return getStyleName().contains(Constants.FADE);
    }

    /**
     * Sets whether this Modal appears on top of others or is the only one
     * visible on screen.
     * 
     * @param hideOthers
     *            <code>true</code> to make sure that this modal is the only one
     *            shown. All others will be hidden. Default: <code>true</code>
     */
    public void setHideOthers(boolean hideOthers) {
        this.hideOthers = hideOthers;
    }

    /**
     * Sets whether the Modal is closed when the <code>ESC</code> is pressed.
     * 
     * @param keyboard
     *            <code>true</code> if the Modal is closed by <code>ESC</code>
     *            key. Default: <code>true</code>
     */
    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
        reconfigure();
    }

    /**
     * Get Keyboard enable state
     * 
     * @return true:enable false:disable
     */
    public boolean isKeyboardEnable() {
        return this.keyboard;
    }

    /**
     * Sets the type of the backdrop.
     * 
     * @param type
     *            the backdrop type
     */
    public void setBackdrop(BackdropType type) {
        backdropType = type;
        reconfigure();

    }

    /**
     * Get backdrop type.
     * 
     * @return backdrop type.
     */
    public BackdropType getBackdropType() {
        return this.backdropType;
    }

    /**
     * Reconfigures the modal with changed settings.
     */
    protected void reconfigure() {
        if (configured) {
            modalHandler = null;
            Object data = GQuery.$(getElement()).data("modal");

            if (data != null) {
                GQuery.$(getElement()).removeData("data");
            }

            configure();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        if (w instanceof ModalFooter) {
            super.add(w);
        } else
            body.add(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(Widget w, int beforeIndex) {
        body.insert(w, beforeIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void show() {

        if (!this.isAttached()) {

            RootPanel.get().add(this);
        }

        modalHandler.show();
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        configure();
        setHandlerFunctions(getElement());
        configured = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        modalHandler.hide();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        modalHandler.toggle();
    }

    /**
     * This method is called immediately when the widget's {@link #hide()}
     * method is executed.
     */
    protected void onHide() {
        fireEvent(new HideEvent());
    }

    /**
     * This method is called once the widget is completely hidden.
     */
    protected void onHidden() {
        fireEvent(new HiddenEvent());
        currentlyShown.remove(this);
    }

    /**
     * This method is called immediately when the widget's {@link #show()}
     * method is executed.
     */
    protected void onShow() {
        if (hideOthers)
            hideShownModals();
        fireEvent(new ShowEvent());
    }

    private void hideShownModals() {
        for (Modal m : currentlyShown) {
            if (!m.equals(this)) {
                m.hide();
            }
        }
    }

    /**
     * This method is called once the widget is completely shown.
     */
    protected void onShown() {
        fireEvent(new ShownEvent());
        currentlyShown.add(this);
    }

    private void configure() {
        Option options = new Option(keyboard, backdropType, show);

        modalHandler = GQuery.$()
                .as(com.github.gwtbootstrap.client.ui.plugin.Modal.Modal)
                .modal(getElement(), close.getElement(), options);
    }

    /**
     * Links the Java functions that fire the events.
     */
    private void setHandlerFunctions(Element e) {
        modalHandler.setOnHide(new Function() {
            @Override
            public void f() {
                onHide();
            }
        });
        modalHandler.setOnHidden(new Function() {
            @Override
            public void f() {
                onHidden();
            }
        });
        modalHandler.setOnShow(new Function() {
            @Override
            public void f() {
                onShow();
            }
        });
        modalHandler.setOnShown(new Function() {
            @Override
            public void f() {
                onShown();
            }
        });
    }

    /**
     * Unlinks all the Java functions that fire the events.
     */
    private void unsetHandlerFunctions(Element e) {
        modalHandler.setOnHide(null);
        modalHandler.setOnHidden(null);
        modalHandler.setOnShow(null);
        modalHandler.setOnShown(null);
    }

    // @formatter:on

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHideHandler(HideHandler handler) {
        return addHandler(handler, HideEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
        return addHandler(handler, HiddenEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShowHandler(ShowHandler handler) {
        return addHandler(handler, ShowEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addShownHandler(ShownHandler handler) {
        return addHandler(handler, ShownEvent.getType());
    }

    /**
     * Show/Hide close button. The Modal must have a title.
     * 
     * @param visible
     *            <b>true</b> for show and <b>false</b> to hide. Defaults is
     *            <b>true</b>.
     */
    public void setCloseVisible(boolean visible) {
        close.getElement()
                .getStyle()
                .setVisibility(
                        visible ? Style.Visibility.VISIBLE
                                : Style.Visibility.HIDDEN);
    }

    /**
     * @deprecated modal do not support setSize method
     */
    @Override
    public void setSize(String width, String height) {
        throw new UnsupportedOperationException(
                "modal do not support setSize method");
    }

}
