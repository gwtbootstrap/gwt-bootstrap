package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AlertBase;

/**
 * Simple Alert widget that uses bold text as a heading.
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <code>{@code <b:Alert heading="Warning." type="error">Something went wrong...</b:Alert>}</code>
 * </p>
 * <p>
 * All parameters are optional and map to the class's setters.
 * </p>
 * 
 * @since 2.0.2.1
 * 
 * @author Dominik Mayer
 * 
 * @see {@link AlertBlock}
 * @see <a href="http://twitter.github.com/bootstrap/components.html#alerts">Bootstrap documentation</a>
 */
public class Alert extends AlertBase {

	/**
	 * Sets the text of an optional heading. It is wrapped in {@code <strong>}
	 * tags and placed before the text.
	 */
	@Override
	public void setHeading(String text) {
		if (text == null || text.isEmpty())
			super.setHeading("");
		else
			super.setHeading("<strong>" + text + "</strong> ");
	}
}
