package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class BlockQuote extends AbstractTypography {

    {
        setElement(DOM.createElement("blockquote"));
    }

    public BlockQuote() {
    	// Needed for UiBinder
    }
    
    public BlockQuote(String text) {
        setText(text);
    }

    public BlockQuote(String text, String cite) {
        this(text);
        setCite(cite);
    }

    public BlockQuote(String text, boolean pullright) {
        setText(text);
        setPullright(pullright);
    }

    public BlockQuote(String text, String cite, boolean pullright) {
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
