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

import com.google.gwt.dom.client.Document;
import com.google.gwt.text.client.IntegerParser;
import com.google.gwt.text.client.IntegerRenderer;

/**
 * A ValueBox that uses {@link IntegerParser} and {@link IntegerRenderer}. for Bootstrap
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 */
public class IntegerBox extends ValueBox<Integer> {

	/**
	 * Create Empty widgets
	 */
	public IntegerBox() {
		super(Document.get().createTextInputElement(), IntegerRenderer.instance(), IntegerParser.instance());
	}
}
