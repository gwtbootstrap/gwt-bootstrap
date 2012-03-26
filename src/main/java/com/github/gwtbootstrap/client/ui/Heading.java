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

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasText;

/**
 *
 * @author carlos
 * @author Dominik Mayer
 */
public class Heading extends ComplexWidget implements HasText {
	
	private static final String SMALL = "small";
	
	private String text;
	
    public Heading(String text, int size) {
    	
        this(size);
        getElement().appendChild(Document.get().createElement(SMALL));
        setText(text);
    }
    
    public @UiConstructor Heading(int size) {
    	super("h" + (size < 1 ? 1 : size > 6 ? 6 : size));
    }
    
    public void setSubtext(String text) {
    	Element i = getElement().getElementsByTagName(SMALL).getItem(0);
    	i.setInnerText(text);
	}
    
    public void setText(String text) {
    	this.text = text;
        Element i = getElement().getElementsByTagName(SMALL).getItem(0);
        getElement().setInnerHTML(text + " " +
        		(i != null ? i.toString() : "<" + SMALL + "></" + SMALL + ">"));
    }

	public String getText() {
		return text;
	}
}
