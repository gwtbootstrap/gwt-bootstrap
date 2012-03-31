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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;

//@formatter:off
/**
 * Layouts from TwBootstrap. You can add Rows and Fluid Rows inside it to build a "sidebar" or something you like to.
 * By default, it is a fixed layout.
 * 
 * @see Row
 * @see Column
 * @see DivWidget
 * @author Carlos A Becker
 */
//@formatter:on
public class Container extends DivWidget {

	public Container() {
		setStylePrimaryName("container");
	}
}
