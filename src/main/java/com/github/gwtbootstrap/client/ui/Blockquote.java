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
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Blockquote extends AbstractTypography {

    {
        setElement(DOM.createElement("blockquote"));
    }

    public Blockquote() {
    	// Needed for UiBinder
    }
    
    public Blockquote(String text) {
        setText(text);
    }

    public Blockquote(String text, String cite) {
        this(text);
        setCite(cite);
    }

    public Blockquote(String text, boolean pullright) {
        setText(text);
        setPullright(pullright);
    }

    public Blockquote(String text, String cite, boolean pullright) {
        this(text);
        setCite(cite);
        setPullright(pullright);
    }

    private void pullRight() {
        setStyleName("pull-right");
    }
    
    public void setCite(String cite) {
    	getElement().appendChild(new SmallCite(cite).getElement());
    }
    
    public void setPullright(boolean pullright) {
    	if (pullright) {
            pullRight();
        }
    }

    private class Cite extends AbstractTypography {

        {
            setElement(DOM.createElement("cite"));
        }

        public Cite(String text) {
            setText(text);
        }
    }

    private class SmallCite extends AbstractTypography {

        private final Cite cite;

        {
            setElement(DOM.createElement("small"));
        }

        public SmallCite(String text) {
            this.cite = new Cite(text);
            getElement().appendChild(cite.getElement());
        }

        @Override
        public void setText(String text) {
            cite.setText(text);
        }
    }
}
