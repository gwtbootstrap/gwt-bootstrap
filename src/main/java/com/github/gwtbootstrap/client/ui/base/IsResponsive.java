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

import com.github.gwtbootstrap.client.ui.resources.ResourceAdapter;

/**
 * An interface for classes with a dedicated responsive behavior.
 * 
 * <p>
 * They are only used if the responsive design is turned on.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 * 
 * @see {@link ResourceAdapter#hasResponsiveDesign()}
 * @see <a href="http://twitter.github.com/bootstrap/scaffolding.html#responsive">Bootstrap documentation</a>
 *
 */
public interface IsResponsive {
	
	/**
	 * Sets whether the widget is shown on small screens like the ones found
	 * on smartphones.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 480 px 
	 * and below 
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>true</code>
	 */
	void setShowOnPhone(boolean show);
	
	/**
	 * @return whether the widget is shown on small screens
	 * 
	 * @see {@link #setShowOnPhone(boolean)}
	 */
	boolean isShownOnPhone();
	
	/**
	 * Sets whether the widget is shown on medium size screens like the ones 
	 * found on tablet computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 767 px 
	 * and below 
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>true</code>
	 */
	void setShowOnTablet(boolean show);
	
	/**
	 * @return whether the widget is shown on medium size screens
	 * 
	 * @see {@link #setShowOnTablet(boolean)}
	 */
	boolean isShownOnTablet();

	/**
	 * Sets whether the widget is shown on normal size screens like the ones 
	 * of desktop computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 768 px 
	 * and above.
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>true</code>
	 */
	void setShowOnDesktop(boolean show);
	
	/**
	 * @return whether the widget is shown on normal size screens
	 * 
	 * @see {@link #setShowOnDesktop(boolean)}
	 */
	boolean isShownOnDesktop();

}
