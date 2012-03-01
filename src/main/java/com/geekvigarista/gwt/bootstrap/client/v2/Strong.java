package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.AbstractTypography;
import com.google.gwt.user.client.DOM;

/**
 *
 * @author carlos
 */
public class Strong extends AbstractTypography {

    public Strong(String text) {
        setElement(DOM.createElement("strong"));
        setText(text);
    }
}
