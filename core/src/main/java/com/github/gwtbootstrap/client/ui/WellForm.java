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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.WellSize;

//@formatter:off
/**
 * {@link Form} inside a {@link Well}.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 */
//@formatter:on
public class WellForm extends Form {

	/**
	 * Creates an empty widget.
	 */
	public WellForm() {
		addStyleName(Constants.WELL);
	}
	   
    /**
     * Set well size
     * @param size size
     */
    public void setSize(WellSize size) {
        StyleHelper.changeStyle(this, size, WellSize.class);
    }

}
