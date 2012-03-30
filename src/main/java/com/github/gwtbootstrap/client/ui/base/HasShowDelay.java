package com.github.gwtbootstrap.client.ui.base;

/**
 * Interface for widgets that can have a delay when they are shown or hidden.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 * 
 */
public interface HasShowDelay {

	/**
	 * Sets the time to wait until the widget is shown.
	 * 
	 * @param delayInMilliseconds
	 *            the delay in milliseconds
	 */
	void setShowDelay(int delayInMilliseconds);

	/**
	 * Gets the time to wait until the widget is shown.
	 * 
	 * @return the delay in milliseconds
	 */
	int getShowDelay();

	/**
	 * Sets the time to wait until the widget is hidden.
	 * 
	 * @param delayInMilliseconds
	 *            the delay in milliseconds
	 */
	void setHideDelay(int delayInMilliseconds);

	/**
	 * Gets the time to wait until the widget is hidden.
	 * 
	 * @return the delay in milliseconds
	 */
	int getHideDelay();
}
