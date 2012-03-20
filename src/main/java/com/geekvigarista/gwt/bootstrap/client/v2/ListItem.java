package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;
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
