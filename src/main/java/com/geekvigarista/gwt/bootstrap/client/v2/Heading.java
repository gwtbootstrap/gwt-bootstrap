/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public class Heading extends Widget {

    public Heading(String text, int size) {
        createBaseHeaderElement(size);
        setText(text);
    }

    public void setText(String text) {
        getElement().setInnerText(text);
    }
    
    private void createBaseHeaderElement(int size) {
        size = size < 1 ? 1 : size > 6 ? 6 : size;
        setElement(DOM.createElement("h" + size));
    }
}
