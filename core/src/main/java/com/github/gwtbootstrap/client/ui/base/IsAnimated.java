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
 * Interface for components that can be animated.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 */
public interface IsAnimated {

	/**
	 * Sets whether the Widget should be animated.
	 * 
	 * @param animation
	 *            <code>true</code> if the widget should be animated.
	 */
	void setAnimation(boolean animation);

	/**
	 * Gets whether the widget is animated.
	 * 
	 * @return <code>true</code> if the widget is animated
	 */
	boolean getAnimation();
}
