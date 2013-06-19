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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Close;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.DismissType;
import com.github.gwtbootstrap.client.ui.event.ClosedEvent;
import com.github.gwtbootstrap.client.ui.event.ClosedHandler;
import com.github.gwtbootstrap.client.ui.event.HasCloseHandlers;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Base class for Alert widgets.
 *
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 *
 * @see <a
 *      href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap
 *      documentation</a>
 *
 * @since 2.0.4.0
 */
public abstract class AlertBase extends HtmlWidget implements IsAnimated,
        HasCloseHandlers<AlertBase>, HasType<AlertType> {

    private Close close;

    private HTMLPanel closeReplacement = new HTMLPanel("span", "");

    private HTMLPanel headingContainer = new HTMLPanel("span", "");

    private HTMLPanel container;

    private boolean fade;

    private boolean hasClose;

    /**
     * Initializes an Alert with a close icon.
     */
    public AlertBase() {
        this("", true);
    }

    /**
     * Initializes an Alert with a inner HTML.
     *
     * @param html inner HTML
     */
    public AlertBase(String html) {
        this(html, true);
    }

    /**
     * Initializes an Alert with an optional close icon.
     *
     * @param html     inner HTML
     * @param hasClose whether the Alert should have a close icon.
     */
    public AlertBase(String html, boolean hasClose) {
        super("div", "");

        super.add(closeReplacement);
        super.add(headingContainer);
        container = new HTMLPanel("span", html);
        super.add(container);
        super.setStyleName(Constants.ALERT);
        setClose(hasClose);
    }

    /**
     * Initializes an Alert of given Type with a close icon.
     *
     * @param type of the Alert
     */
    public AlertBase(AlertType type) {
        this();
        setType(type);
    }

    /**
     * Sets whether the Alert has a close icon or not.
     *
     * @param hasClose <code>false</code> if you don't want to have a close icon.
     *                 Default: <code>true</code>
     */
    public void setClose(boolean hasClose) {

        this.hasClose = hasClose;

        if (!isAttached()) {
            return;
        }

        if (hasClose) {
            if (close == null) {
                close = new Close(DismissType.ALERT);
                getElement().replaceChild(close.getElement(), closeReplacement.getElement());
            }
        } else {
            if (close != null) {
                getElement().replaceChild(closeReplacement.getElement(), close.getElement());
                close = null;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAttach() {
        super.onAttach();
        setClose(hasClose);
        configure(getElement());
        setHandlerFunctions(getElement());
    }

    /**
     * has Close
     *
     * @return true:has close false:does not has close
     */
    public boolean hasClose() {
        return hasClose;
    }

    /**
     * Gets heading's container widget
     *
     * @return heading's container
     */
    protected HasWidgets getHeadingContainer() {
        return headingContainer;
    }

    /**
     * This method is called immediately when the widget's close method is
     * executed.
     */
    // TODO: Get the source element from javascript
    protected void onClose() {
        CloseEvent.fire(this, this);
    }

    /**
     * This method is called once the widget is completely closed.
     */
    // TODO: Get the source element from javascript
    protected void onClosed() {
        ClosedEvent.fire(this, this);
    }

    /**
     * Sets the type of the Alert.
     *
     * @param type
     */
    public void setType(AlertType type) {
        StyleHelper.changeStyle(this, type, AlertType.class);
    }

    /**
     * Sets the text of an optional heading. The implementation depends on the
     * subclass.
     *
     * @param text the new heading
     */
    public void setHeading(String text) {
        headingContainer.clear();
        headingContainer.add(new HTMLPanel("span", text));
    }

    /**
     * Sets whether the Alert should be animated.
     *
     * @param animated <code>true</code> if the Alert should fade out. Default:
     *                 <code>false</code>
     */
    public void setAnimation(boolean animated) {
        this.fade = animated;
        setFade();
    }

    /**
     * {@inheritDoc}
     */
    public boolean getAnimation() {
        return fade;
    }

    /**
     * Delete the whole content of the Alert. This includes text, heading and
     * close icon.
     */
    @Override
    public void clear() {
        container.clear();
    }

    /**
     * Sets the classes that define whether the Alert fades or not.
     */
    private void setFade() {
        if (fade) {
            addStyleName("fade");
            addStyleName("in");
        } else {
            removeStyleName("fade");
            removeStyleName("in");
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getText() {
        return container.getElement().getInnerText();
    }

    /**
     * {@inheritDoc}
     */
    public void setText(String text) {
        setHTML(SafeHtmlUtils.htmlEscape(text));
    }

    /**
     * {@inheritDoc}
     */
    public String getHTML() {
        return container.getElement().getInnerHTML();
    }

    public void setHTML(String html) {
        container.clear();
        container.add(new HTMLPanel("span", html));
    }

    /**
     * Close this alert.
     */
    public void close() {
        close(getElement());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<AlertBase> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlerRegistration addClosedHandler(ClosedHandler<AlertBase> handler) {
        return addHandler(handler, ClosedEvent.getType());
    }

    //@formatter:off

    /**
     * Adds the Java functions that fire the Events to document. It is a
     * convenience method to have a cleaner code later on.
     */
    // TODO: Add autoTriggered feature in order to support autoClosed events. See {@link Modal}.
    private native void setHandlerFunctions(Element e) /*-{
        var that = this;
        var $e = $wnd.jQuery(e);
        $e.bind('close', function () {
                that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClose()();
        });
        $e.bind('closed', function () {
                that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClosed()();
        });
    }-*/;

    private native void configure(Element e) /*-{
        $wnd.jQuery(e).alert(e);
    }-*/;

    private native void close(Element e)/*-{
        $wnd.jQuery(e).alert('close');
    }-*/;
    //@formatter:on

}
