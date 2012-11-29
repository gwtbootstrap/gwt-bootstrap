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

import com.github.gwtbootstrap.client.ui.base.HoverBase;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.google.gwt.dom.client.Element;

//@formatter:off
/**
 * Popover that
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 * 
 * @see <a
 *      href="http://twitter.github.com/bootstrap/javascript.html#popovers">Bootstrap
 *      documentation</a>
 * @see Tooltip
 */
// @formatter:on
public class Popover extends HoverBase {

	private String content;
	private String heading;
	private boolean html = false;

	/**
	 * Creates an empty Popover.
	 */
	public Popover() {
		super();
		placement = Placement.RIGHT;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String content) {
		this.content = content;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return this.content;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getHeading() {
		return this.heading;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reconfigure() {

		removeDataIfExists();

		setDataAttribute(getWidget().getElement(), "original-title", heading);

		setDataAttribute(getWidget().getElement(), "content", content);

		configure(getWidget().getElement(), getAnimation(), getPlacement().get(), getTrigger().get(), getShowDelay(),
				getHideDelay(), isHtml());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void changeVisibility(VisibilityChange visibilityChange) {
		changeVisibility(getWidget().getElement(), visibilityChange.get());
	}

	private native void configure(Element element, boolean animated, String placement, String trigger, int showDelay,
			int hideDelay, boolean html) /*-{
		$wnd.jQuery(element).popover({
			animation : animated,
			placement : placement,
			html : html,
			trigger : trigger,
			delay : {
				show : showDelay,
				hide : hideDelay
			}
		});
	}-*/;

	/**
	 * Change Visibility
	 * 
	 * @param e
	 *            target
	 * @param visibility
	 *            please use VisibilityChange enum.
	 */
	public static native void changeVisibility(Element e, String visibility) /*-{
		$wnd.jQuery(e).popover(visibility);
	}-*/;

	@Override
	protected String getDataName() {
		return "popover";
	}

	public boolean isHtml() {
		return html;
	}

	public void setHtml(boolean html) {
		this.html = html;
	}
}
