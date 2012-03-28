package com.github.gwtbootstrap.client.ui;

public interface HasHref {

	/**
	 * Sets the <code>href</code> property of the anchor tag.
	 * <p>
	 * Use it only to set links to another page. Links on the same page or GWT
	 * tokens should be set with {@code #setTargetHistoryToken(String)}
	 * 
	 * @param href
	 *            the website URL
	 */
	void setHref(String href);

	/**
	 * @return the URL of the website this link is pointing to
	 */
	String getHref();

	/**
	 * Sets the <code>href</code> property of the anchor tag to
	 * <code>"#" + targetHistoryToken</code>.
	 * 
	 * @param targetHistoryToken
	 *            the history token
	 */
	void setTargetHistoryToken(String targetHistoryToken);

	/**
	 * Gets the history token this link points to
	 * 
	 * @return the history token
	 */
	String getTargetHistoryToken();

}
