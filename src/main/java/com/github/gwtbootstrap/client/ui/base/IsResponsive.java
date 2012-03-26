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
 * <b>They are only used if the responsive design is turned on!</b>
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
	
	enum ResponsiveStyle implements Style {
		
		VISIBLE_PHONE("visible-phone"),
		HIDDEN_PHONE("hidden-phone"),
		VISIBLE_TABLET("visible-tablet"),
		HIDDEN_TABLET("hidden-phone"),
		VISIBLE_DESKTOP("visible-desktop"),
		HIDDEN_DESKTOP("hidden-phone");
		
		private String className;
		
		private ResponsiveStyle(String className) {
			this.className = className;
		}
		
		public String get() {
			return className;
		}
		
	}
	
	/**
	 * Sets whether the widget is shown on small screens like the ones found
	 * on smartphones.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 480 px 
	 * and below. The widget is not shown on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setShowOnTablet(boolean)}
	 * @see {@link #setShowOnDesktop(boolean)}
	 */
	void setShowOnPhone(boolean show);
	
	/**
	 * Whether the widget is shown on small screens.
	 * 
	 * @return <code>true</code> if the widget gets displayed. 
	 * 
	 * @see {@link #setShowOnPhone(boolean)}
	 */
	boolean isShownOnPhone();
	
	/**
	 * Sets whether the widget is hidden on small screens like the ones 
	 * found on tablet computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 480 px 
	 * and below. The widget is not hidden on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param hide <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setHideOnTablet(boolean)}
	 * @see {@link #setHideOnDesktop(boolean)}
	 */
	void setHideOnPhone(boolean hide);
	
	
	/**
	 * Whether the widget is hidden on small screens.
	 * 
	 * @return <code>true</code> if the widget gets hidden. 
	 * 
	 * @see {@link #setHideOnPhone(boolean)}
	 */
	boolean isHiddenOnPhone();
	
	/**
	 * Sets whether the widget is shown on medium size screens like the ones 
	 * found on tablet computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 767 px 
	 * and below. The widget is not shown on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setShowOnPhone(boolean)}
	 * @see {@link #setShowOnDesktop(boolean)}
	 */
	void setShowOnTablet(boolean show);
	
	/**
	 * Whether the widget is shown on medium size screens.
	 * 
	 * @return <code>true</code> if the widget gets displayed. 
	 * 
	 * @see {@link #setShowOnTablet(boolean)}
	 */
	boolean isShownOnTablet();
	
	/**
	 * Sets whether the widget is hidden on medium size screens like the ones 
	 * found on tablet computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 767 px 
	 * and below. The widget is not hidden on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param hide <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setHideOnPhone(boolean)}
	 * @see {@link #setHideOnDesktop(boolean)}
	 */
	void setHideOnTablet(boolean hide);
	
	/**
	 * Whether the widget is hidden on medium size screens.
	 * 
	 * @return <code>true</code> if the widget gets hidden. 
	 * 
	 * @see {@link #setHideOnPhone(boolean)}
	 */
	boolean isHiddenOnTablet();

	/**
	 * Sets whether the widget is shown on normal size screens like the ones 
	 * of desktop computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 768 px 
	 * and above. The widget is not shown on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setShowOnPhone(boolean)}
	 * @see {@link #setShowOnTablet(boolean)}
	 */
	void setShowOnDesktop(boolean show);
	
	/**
	 * Whether the widget is shown on normal size screens.
	 * 
	 * @return <code>true</code> if the widget gets displayed. 
	 * 
	 * @see {@link #setShowOnDesktop(boolean)}
	 */
	boolean isShownOnDesktop();

	/**
	 * Sets whether the widget is hidden on medium size screens like the ones 
	 * found on tablet computers.
	 * 
	 * <p>
	 * In the default configuration these are screens with a width of 768 px 
	 * and above. The widget is not hidden on any other screen size unless you
	 * also set the appropriate values.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param show <code>false</code> hides the widget. Default: 
	 * <code>false</code>
	 * 
	 * @see {@link ResourceAdapter#hasResponsiveDesign()}
	 * @see {@link #setHideOnPhone(boolean)}
	 * @see {@link #setHideOnTablet(boolean)}
	 */
	void setHideOnDesktop(boolean hide);
	
	/**
	 * Whether the widget is hidden on normal size screens.
	 * 
	 * @return <code>true</code> if the widget gets hidden. 
	 * 
	 * @see {@link #setHideOnDesktop(boolean)}
	 */
	boolean isHiddenOnDesktop();
}
