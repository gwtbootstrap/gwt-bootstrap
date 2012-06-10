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

/**
 * Interface for widgets that can work as a link.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 */
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
	 * Gets the URL of the website, the link is pointing to.
	 * 
	 * @return the URL
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
