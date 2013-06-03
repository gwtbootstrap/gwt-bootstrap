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

import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.Trigger;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
* Base class for widgets that hover above other widgets.
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/javascript.html#popovers">Bootstrap documentation</a>
*/
//@formatter:on
public abstract class HoverBase extends MarkupWidget  implements IsWidget, HasWidgets, HasOneWidget, IsAnimated, HasTrigger, HasPlacement, HasText, HasShowDelay, HasVisibility {

	/**
	 * Whether the widget is animated or not.
	 */
	protected boolean animated = true;

	/**
	 * The placement of the widget relative to its trigger element.
	 */
	protected Placement placement = Placement.TOP;

	/**
	 * The action that triggers the widget.
	 */
	protected Trigger trigger = Trigger.HOVER;

	/**
	 * The delay until the widget is shown.
	 */
	protected int showDelayInMilliseconds = 0;

	/**
	 * The delay until the widget is hidden.
	 */
	protected int hideDelayInMilliseconds = 0;

    /**
     * Appends the popover to a specific element.
     */
    protected String container;

	/**
	 * Creates a new widget based on the provided HTML tag.
	 */
	public HoverBase() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Widget asWidget() {
		
	    if(getWidget() != null) {
	        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                
                @Override
                public void execute() {
                    removeDataIfExists();
                    
                    reconfigure();
                    
                    getWidget().addAttachHandler(new AttachEvent.Handler() {
                        
                        @Override
                        public void onAttachOrDetach(AttachEvent event) {
                            if (!event.isAttached()) {
                                changeVisibility(VisibilityChange.HIDE);
                            }
                        }
                    });
                }
            });
		}
		
		return getWidget();

	}
	
	protected void removeDataIfExists() {
	    hide();
		removeDataIfExists(getWidget().getElement(), getDataName());
	}
	
	protected native void removeDataIfExists(Element e, String dataName) /*-{
	    var element = $wnd.jQuery(e);
		if(element.data(dataName)) {
			var data = element.data(dataName);
			var eventIn, eventOut;
			if (data.options.trigger != 'manual') {
				eventIn  = data.options.trigger == 'hover' ? 'mouseenter' : 'focus'
				eventOut = data.options.trigger == 'hover' ? 'mouseleave' : 'blur'
				data.$element.off(eventIn);
				data.$element.off(eventOut);
			}
			element.removeData(dataName);
		}
	}-*/;

	/**
	 * Adds an HTML data attribute to the widget's tag.
	 * 
	 * @param e target element
	 * 
	 * @param attribute
	 *            the name of the attribute without leading <code>"data-"</code>
	 * @param value
	 *            the value to be stored
	 */
	protected void setDataAttribute(Element e , String attribute, String value) {
		e.setAttribute("data-" + attribute, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAnimation(boolean animated) {
		this.animated = animated;
	}

	/**
	 * Redraws the widget with the currently set options. This must <b>not</b>
	 * be called when a parameter is updated because it would deactivate all
	 * other parameters. No idea why...
	 */
	public abstract void reconfigure();

	/**
	 * {@inheritDoc}
	 */
	public boolean getAnimation() {
		return animated;
	}

	/**
	 * {@inheritDoc} Relative to its trigger element.
	 */
	public void setPlacement(Placement placement) {
		this.placement = placement;
	}

	/**
	 * {@inheritDoc}
	 */
	public Placement getPlacement() {
		return placement;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	/**
	 * {@inheritDoc}
	 */
	public Trigger getTrigger() {
		return trigger;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setShowDelay(int delayInMilliseconds) {
		showDelayInMilliseconds = delayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getShowDelay() {
		return showDelayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHideDelay(int delayInMilliseconds) {
		hideDelayInMilliseconds = delayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHideDelay() {
		return hideDelayInMilliseconds;
	}

	/**
	 * {@inheritDoc}
	 */
	public void show() {
		changeVisibility(VisibilityChange.SHOW);
	}

	/**
	 * {@inheritDoc}
	 */
	public void hide() {
		changeVisibility(VisibilityChange.HIDE);
	}

	/**
	 * {@inheritDoc}
	 */
	public void toggle() {
		changeVisibility(VisibilityChange.TOGGLE);
	}

	/**
	 * Changes the visibility of the widget.
	 * 
	 * @param visibilityChange
	 *            the action to be performed
	 */
	protected abstract void changeVisibility(VisibilityChange visibilityChange);

	/**
	 * Get data name of JS Data API.
	 * @return data name
	 */
	protected abstract String getDataName();

    /**
     * @return Specific element the Popover/Tooltip is appended to
     */
    public String getContainer() {
        return container;
    }

    /**
     * Set specific element the Popover/Tooltip is appended to
     * @param container  Specific element the Popover/Tooltip is appended to. E.g. 'body' or null.
     */
    public void setContainer(String container) {
        this.container = container;
    }
}
