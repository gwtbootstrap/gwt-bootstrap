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
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
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
	 * Creates a new widget based on the provided HTML tag.
	 */
	public HoverBase() {
		super("span");
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
	 * Adds an HTML data attribute to the widget's tag.
	 * 
	 * @param attribute
	 *            the name of the attribute without leading <code>"data-"</code>
	 * @param value
	 *            the value to be stored
	 */
	protected void setDataAttribute(String attribute, String value) {
		getElement().setAttribute("data-" + attribute, value);
	}

	/**
	 * Returns the data stored in one of the widget's HTML data attributes.
	 * 
	 * @param attribute
	 *            the name of the attribute without leading <code>"data-"</code>
	 * @return the value stored in the tag
	 */
	protected String getDataAttribute(String attribute) {
		return getElement().getAttribute("data-" + attribute);
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
	protected abstract void reconfigure();

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
	 * 
	 * @deprecated This method should never be called directly. It will break
	 *             your implementation if any attribute names change. The only
	 *             valid use is inside UiBinder files where it processes the
	 *             <code>placement="..."</code> argument. Use
	 *             {@link #setPlacement(Placement)} instead!
	 */
	@Deprecated
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
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated This method should never be called directly. It will break
	 *             your implementation if any attribute names change. The only
	 *             valid use is inside UiBinder files where it processes the
	 *             <code>trigger="..."</code> argument. Use
	 *             {@link #setTrigger(Trigger)} instead!
	 */
	@Deprecated
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

}
