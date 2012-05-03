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

import com.github.gwtbootstrap.client.ui.base.HasHref;
import com.github.gwtbootstrap.client.ui.base.HoverBase;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Link with a small tooltip with additional information.
 * <p>
 * Technically it's an html {@code <a>} tag. The text of the popup will be the
 * content of the anchor's <code>title</code> attribute. 
 * 
 * @since 2.0.3.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#tooltips">Bootstrap documentation</a>
 * @see Popover
 */
//@formatter:on
public class Tooltip extends HoverBase implements HasHref {

	private IconAnchor anchor = new IconAnchor();

	/**
	 * Creates an empty link without text and tooltip text.
	 */
	public Tooltip() {
		super();
		super.add(anchor);
	}

	/**
	 * Creates a link with the
	 * 
	 * @param text
	 * @param tooltip
	 */
	public Tooltip(String text, String tooltip) {
		this();
		setText(text);
		setTooltip(tooltip);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		anchor.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return anchor.getText();
	}

	/**
	 * Sets the text that should appear in the tooltip.
	 * 
	 * @param text
	 *            the text
	 */
	public void setTooltip(String text) {
		setDataAttribute("original-title", (text));
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHref(String href) {
		anchor.setHref(href);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHref() {
		return anchor.getHref();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTargetHistoryToken(String targetHistoryToken) {
		anchor.setTargetHistoryToken(targetHistoryToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTargetHistoryToken() {
		return anchor.getTargetHistoryToken();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reconfigure() {
		configure(getElement(), getAnimation(), getPlacement().get(),
				getTrigger().get(), getShowDelay(), getHideDelay());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget w) {
		anchor.add(w);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(Widget w, int beforeIndex) {
		anchor.insert(w, beforeIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void changeVisibility(VisibilityChange visibilityChange) {
		changeVisibility(getElement(), visibilityChange.get());
	}

	private native void configure(Element element, boolean animated,
			String placement, String trigger, int showDelay, int hideDelay) /*-{
		$wnd.jQuery(element).tooltip({
			animation : animated,
			placement : placement,
			trigger : trigger,
			delay : {
				show : showDelay,
				hide : hideDelay
			}
		});
	}-*/;

	private native void changeVisibility(Element e, String visibility) /*-{
		$wnd.jQuery(e).tooltip(visibility);
	}-*/;

}
