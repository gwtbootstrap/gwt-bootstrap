/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.DivWidget;

/**
 *
 * @author carlos
 */
public class ButtonGroup extends DivWidget {
    
    {
        setStyleName("btn-group");
    }
    
    public ButtonGroup(Button... buttons) {
        super();
        for (Button btn : buttons) {
            addButton(btn);
        }
    }

    public void addButton(Button btn) {
        super.add(btn);
    }
}
