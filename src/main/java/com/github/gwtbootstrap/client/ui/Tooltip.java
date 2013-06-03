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
import com.github.gwtbootstrap.client.ui.constants.Trigger;
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
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#tooltips">Bootstrap documentation</a>
 * @see Popover
 */
//@formatter:on
public class Tooltip extends HoverBase {

	private String tooltip;

	/**
	 * Creates an empty link without text and tooltip text.
	 */
	public Tooltip() {
		super();
	}

	/**
	 * Creates a link with the
	 * 
	 * @param tooltip get
	 */
	public Tooltip(String tooltip) {
		this();
		setText(tooltip);
	}

	/**
	 * Sets the text that should appear in the tooltip.
	 * 
	 * @param tooltop
	 *            the text
	 */
	public void setText(String tooltop) {
		this.tooltip = tooltop;
	}
	
	public String getText() {
		return this.tooltip;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reconfigure() {
		
		removeDataIfExists();
		
		setDataAttribute(getWidget().getElement(), "original-title", tooltip);
		
		configure(getWidget().getElement(), getAnimation(), getPlacement().get(),
				getTrigger().get(), getShowDelay(), getHideDelay(), getContainer());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void changeVisibility(VisibilityChange visibilityChange) {
		changeVisibility(getWidget().getElement(), visibilityChange.get());
	}
	
	/**
	 * 
	 * @param e
	 * @param animated
	 * @param placement
	 * @param trigger
	 * @param showDelay
	 * @param hideDelay
	 */
	public static void configure(Widget e,boolean animated,Placement placement,Trigger trigger,int showDelay,int hideDelay, String container) {
		configure(e.getElement(), animated, placement.get(),trigger.get(), showDelay, hideDelay, container);
	}

	//@formatter:off
	public static native void configure(String selector,String text, boolean animated,
            String placement, String trigger, int showDelay, int hideDelay, String container) /*-{
        $wnd.jQuery(selector).tooltip({
            title : text,
            animation : animated,
            placement : placement,
            trigger : trigger,
            delay : {
                show : showDelay,
                hide : hideDelay
            },
            container: container
        });
    }-*/;
	
	public static native void configure(Element element, boolean animated,
			String placement, String trigger, int showDelay, int hideDelay, String container) /*-{
		$wnd.jQuery(element).tooltip({
			animation : animated,
			placement : placement,
			trigger : trigger,
			delay : {
				show : showDelay,
				hide : hideDelay
			},
            container: container
		});
	}-*/;

	public static native void changeVisibility(Element e, String visibility) /*-{
		$wnd.jQuery(e).tooltip(visibility);
	}-*/;	
	//@formatter:on

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDataName() {
		return "tooltip";
	}

}
