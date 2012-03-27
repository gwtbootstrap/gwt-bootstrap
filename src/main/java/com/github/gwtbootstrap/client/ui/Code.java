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

import com.github.gwtbootstrap.client.ui.base.AbstractTypography;
import com.github.gwtbootstrap.client.ui.resources.prettify.HasProgrammingLanguage;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.user.client.DOM;

/**
 * Simple inline code.
 * 
 * @author Dominik Mayer
 * @author Carlos A Becker
 * 
 */
public class Code extends AbstractTypography implements HasProgrammingLanguage {

	private final PrettifyHelper helper;
	
	public Code() {
		setElement(DOM.createElement("code"));
		helper = new PrettifyHelper(this);
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure();
	}

	public void setLang(String lang) {
		helper.setLang(lang);
	}
}
