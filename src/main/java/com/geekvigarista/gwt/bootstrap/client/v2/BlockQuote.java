package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class BlockQuote extends AbstractTypography {

    {
        setElement(DOM.createElement("blockquote"));
    }

    public BlockQuote(String text) {
        setText(text);
    }

    public BlockQuote(String text, String cite) {
        this(text);
        getElement().appendChild(new SmallCite(cite).getElement());
    }

    public BlockQuote(String text, boolean pullright) {
        setText(text);
        if (pullright) {
            pullRight();
        }
    }

    public BlockQuote(String text, String cite, boolean pullright) {
        this(text);
        getElement().appendChild(new SmallCite(cite).getElement());
        if (pullright) {
            pullRight();
        }
    }

    private void pullRight() {
        setStyleName("pull-right");
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
