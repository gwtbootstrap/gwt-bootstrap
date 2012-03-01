package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Abbreviation extends AbstractTypography {

    public Abbreviation(String text, String title) {
        setElement(DOM.createElement("abbr"));
        setText(text);
        setTitle(title);
    }
}
