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
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public class ButtonToolbar extends DivWidget {
    {
        setStyleName("btn-toolbar");
    }

    public ButtonToolbar() {
    }

    @Override
    public void add(Widget child) {
    	
    	Widget widget = child;
    	
    	if (!(child instanceof ButtonGroup) && !(child instanceof Button))
    		throw new IllegalArgumentException("A ButtonToolbar can only contain ButtonGroups and Buttons.");

    	if (child instanceof Button)
    		widget = new ButtonGroup((Button) child);
    	
        super.add(widget);
    }
    
    
}
