/*
 *  Copyright 2012 GWT Bootstrap
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
import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
* Base class for widgets that hover above other widgets.
* 
* @since 2.0.2.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/javascript.html#popovers">Bootstrap documentation</a>
*/
//@formatter:on
public abstract class HoverBase extends ComplexWidget implements IsAnimated,
		HasTrigger, HasPlacement, HasText, HasShowDelay {

	private boolean animated = true;

	private Placement placement = Placement.TOP;

	private Trigger trigger = Trigger.HOVER;

	private int showDelayInMilliseconds = 0;

	private int hideDelayInMilliseconds = 0;

	public HoverBase(String tag) {
		super(tag);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onLoad() {
		super.onLoad();
		reconfigure();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAnimated(boolean animated) {
		this.animated = animated;
		reconfigure();
	}

	/**
	 * Redraws the widget with the currently set options.
	 */
	protected abstract void reconfigure();

	/**
	 * {@inheritDoc}
	 */
	public boolean getAnimated() {
		return animated;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPlacement(Placement placement) {
		this.placement = placement;
		reconfigure();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPlacement(String placement) {
		if (placement == "top")
			setPlacement(Placement.TOP);
		else if (placement == "bottom")
			setPlacement(Placement.BOTTOM);
		else if (placement == "left")
			setPlacement(Placement.LEFT);
		else if (placement == "right")
			setPlacement(Placement.RIGHT);
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
		reconfigure();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTrigger(String trigger) {
		if (trigger == "hover")
			setTrigger(Trigger.HOVER);
		else if (trigger == "focus")
			setTrigger(Trigger.FOCUS);
		else if (trigger == "manual")
			setTrigger(Trigger.MANUAL);
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
		reconfigure();
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
		reconfigure();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHideDelay() {
		return hideDelayInMilliseconds;
	}

}
