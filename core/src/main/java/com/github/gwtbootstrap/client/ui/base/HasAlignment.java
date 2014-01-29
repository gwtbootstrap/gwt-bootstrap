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

import com.github.gwtbootstrap.client.ui.constants.Alignment;

/**
 * Interface for widgets that can be aligned on the left or right side.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 */
public interface HasAlignment {

	/**
	 * Pulls the widget to the left or right.
	 * 
	 * @param alignment
	 *            where the widget should end up
	 */
	void setAlignment(Alignment alignment);

}
