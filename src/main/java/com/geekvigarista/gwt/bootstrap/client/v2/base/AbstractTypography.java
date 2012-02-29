/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2.base;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author carlos
 */
public abstract class AbstractTypography extends Widget {
    public void setText(String text) {
        getElement().setInnerText(text);
    }
}
