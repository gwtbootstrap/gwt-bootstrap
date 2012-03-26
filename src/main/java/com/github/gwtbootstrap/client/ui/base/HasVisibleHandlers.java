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

import com.github.gwtbootstrap.client.ui.event.HiddenHandler;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.github.gwtbootstrap.client.ui.event.ShownHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * Interface that defines a component has can be show or hidden.
 * 
 * @author Carlos A Becker
 *
 */
public interface HasVisibleHandlers {
	void show();

	void hide();

	void toggle();
	
	HandlerRegistration addHideHandler(HideHandler handler);
	
	HandlerRegistration addHiddenHandler(HiddenHandler handler);
	
	HandlerRegistration addShowHandler(ShowHandler handler);
	
	HandlerRegistration addShownHandler(ShownHandler handler);
}
