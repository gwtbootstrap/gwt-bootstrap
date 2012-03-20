package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 *
 * @author carlos
 */
public class ListItem extends ComplexWidget {

	public ListItem() {
		super("li");
	}
	
    public ListItem(IsWidget... childs) {
    	this();
        for (IsWidget w : childs) {
            add(w);
        }
    }
}
