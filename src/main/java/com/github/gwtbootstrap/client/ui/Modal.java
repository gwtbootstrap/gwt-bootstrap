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
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
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
public class Modal extends DivWidget implements HasVisibility, HasVisibleHandlers, IsAnimated {

	private static Set<Modal> currentlyShown = new HashSet<Modal>();

	private final DivWidget header = new DivWidget();

	private final DivWidget body = new DivWidget("modal-body");

	private boolean keyboard = true;

	private BackdropType backdropType = BackdropType.NORMAL;

	private boolean show = false;

	private boolean hideOthers = true;

	private boolean configured = false;

	private Close close = new Close(DismissType.MODAL);

	private String title;

	/**
	 * Creates an empty, hidden widget.
	 */
	public Modal() {
		super("modal");
		getElement().setAttribute("tabindex", "-1");
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
	public Modal(boolean animated,
		boolean dynamicSafe) {
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
		this.title = title;

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
	public void setAnimation(boolean animated) {
		if (animated)
			addStyleName(Constants.FADE);
		else
			removeStyleName(Constants.FADE);
	}

	/**
	 * {@inheritDoc}
	 */
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
			reconfigure(keyboard, backdropType, show);
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
	public void show() {

		if (!this.isAttached()) {

			RootPanel.get().add(this);
		}

		changeVisibility("show");
        //	centerVertically(getElement());  Note: Doesn't work with Bootstrap 2.3.2
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		configure(keyboard, backdropType, show);
		setHandlerFunctions(getElement());
		configured = true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void hide() {
		changeVisibility("hide");
	}

	/**
	 * {@inheritDoc}
	 */
	public void toggle() {
		changeVisibility("toggle");
	}

	private void changeVisibility(String visibility) {
		changeVisibility(getElement(), visibility);
	}

	/**
	 * This method is called immediately when the widget's {@link #hide()}
	 * method is executed.
	 */
	protected void onHide(Event e) {
		fireEvent(new HideEvent(e));
	}

	/**
	 * This method is called once the widget is completely hidden.
	 */
	protected void onHidden(Event e) {
		fireEvent(new HiddenEvent(e));
		currentlyShown.remove(this);
	}

	/**
	 * This method is called immediately when the widget's {@link #show()}
	 * method is executed.
	 */
	protected void onShow(Event e) {
		if (hideOthers)
			hideShownModals();
		fireEvent(new ShowEvent(e));
	}

	private void hideShownModals() {
		for (Modal m : currentlyShown) {
		    if(!m.equals(this)) {
		        m.hide();
		    }		    
		}
	}

	/**
	 * This method is called once the widget is completely shown.
	 */
	protected void onShown(Event e) {
		fireEvent(new ShownEvent(e));
		currentlyShown.add(this);
	}

	private void reconfigure(boolean keyboard, BackdropType backdropType, boolean show) {

		if (backdropType == BackdropType.NORMAL) {
			reconfigure(getElement(), keyboard, true, show);
		} else if (backdropType == BackdropType.NONE) {
			reconfigure(getElement(), keyboard, false, show);
		} else if (backdropType == BackdropType.STATIC) {
			reconfigure(getElement(), keyboard, BackdropType.STATIC.get(), show);
		}
	}

	private void configure(boolean keyboard, BackdropType backdropType, boolean show) {

		if (backdropType == BackdropType.NORMAL) {
			configure(getElement(), keyboard, true, show);
		} else if (backdropType == BackdropType.NONE) {
			configure(getElement(), keyboard, false, show);
		} else if (backdropType == BackdropType.STATIC) {
			configure(getElement(), keyboard, BackdropType.STATIC.get(), show);
		}
	}

	//@formatter:off
	
	private native void reconfigure(Element e, boolean k, boolean b, boolean s) /*-{
		var modal = null;
		if($wnd.jQuery(e).data('modal')) {
			modal = $wnd.jQuery(e).data('modal');
			$wnd.jQuery(e).removeData('modal');
		}
		$wnd.jQuery(e).modal({
						keyboard : k,
						backdrop : b,
						show : s
					});
					
		if(modal) {
			$wnd.jQuery(e).data('modal').isShown = modal.isShown;
		}

	}-*/;
	private native void reconfigure(Element e, boolean k, String b, boolean s) /*-{
		var modal = null;
		if($wnd.jQuery(e).data('modal')) {
			modal = $wnd.jQuery(e).data('modal');
			$wnd.jQuery(e).removeData('modal');
		}
		$wnd.jQuery(e).modal({
						keyboard : k,
						backdrop : b,
						show : s
					});
					
		if(modal) {
			$wnd.jQuery(e).data('modal').isShown = modal.isShown;
		}
	}-*/;
	
	
	private native void configure(Element e, boolean k, boolean b, boolean s) /*-{
		$wnd.jQuery(e).modal({
							keyboard : k,
							backdrop : b,
							show : s
						});

	}-*/;
	private native void configure(Element e, boolean k, String b, boolean s) /*-{
		$wnd.jQuery(e).modal({
							keyboard : k,
							backdrop : b,
							show : s
						});
	}-*/;

	private native void changeVisibility(Element e, String visibility) /*-{
		$wnd.jQuery(e).modal(visibility);
	}-*/;

	/**
	 * Links the Java functions that fire the events.
	 */
	private native void setHandlerFunctions(Element e) /*-{
		var that = this;
		$wnd.jQuery(e).on('hide', function(e) {
			that.@com.github.gwtbootstrap.client.ui.Modal::onHide(Lcom/google/gwt/user/client/Event;)(e);
		});
		$wnd.jQuery(e).on('hidden', function(e) {
			that.@com.github.gwtbootstrap.client.ui.Modal::onHidden(Lcom/google/gwt/user/client/Event;)(e);
		});
		$wnd.jQuery(e).on('show', function(e) {
			that.@com.github.gwtbootstrap.client.ui.Modal::onShow(Lcom/google/gwt/user/client/Event;)(e);
		});
		$wnd.jQuery(e).on('shown', function(e) {
			that.@com.github.gwtbootstrap.client.ui.Modal::onShown(Lcom/google/gwt/user/client/Event;)(e);
		});
	}-*/;

	/**
	 * Unlinks all the Java functions that fire the events.
	 */
	private native void unsetHandlerFunctions(Element e) /*-{
		$wnd.jQuery(e).off('hide');
		$wnd.jQuery(e).off('hidden');
		$wnd.jQuery(e).off('show');
		$wnd.jQuery(e).off('shown');
	}-*/;
	//@formatter:on

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addHideHandler(HideHandler handler) {
		return addHandler(handler, HideEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addHiddenHandler(HiddenHandler handler) {
		return addHandler(handler, HiddenEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addShowHandler(ShowHandler handler) {
		return addHandler(handler, ShowEvent.getType());
	}

	/**
	 * {@inheritDoc}
	 */
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
		close.getElement().getStyle().setVisibility(visible
															? Style.Visibility.VISIBLE
															: Style.Visibility.HIDDEN);
	}
	
	/**
	 * @deprecated modal do not support setSize method
	 */
	@Override
	public void setSize(String width, String height) {
		throw new UnsupportedOperationException("modal do not support setSize method");
	}
	
	/**
	 * Sets the Modal's width.
	 * @param width Modal's new width, in px
	 */
	public void setWidth(int width) {
		DOM.setStyleAttribute(this.getElement(), "width", width + "px");
		DOM.setStyleAttribute(this.getElement(), "marginLeft", (-width / 2) + "px");
	}
	
	/**
	 * Sets the Modal's body maxHeight.
	 * @param maxHeight the Modal's body new maxHeight, in CSS units (e.g. "10px", "1em")
	 */
	public void setMaxHeigth(String maxHeight) {
		DOM.setStyleAttribute(body.getElement(), "maxHeight", maxHeight);
	}
	
}
