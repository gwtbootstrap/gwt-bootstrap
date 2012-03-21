package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.geekvigarista.gwt.bootstrap.client.ui.Icon;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;


public class IconAnchor extends ComplexWidget implements HasText {

    private String text;
    
    public IconAnchor() {
    	
    	super("a");
        getElement().appendChild(Document.get().createElement("i"));
    }

    public void setIcon(Icon icon) {
        if (icon == null) {
            return;
        }
        setIcon(icon.getStyleName());
    }
    
    public void setIcon(String iconname) {
    	getElement().getElementsByTagName("i").getItem(0).setClassName(
    			"icon-" + iconname);
    }

    public void setText(String text) {
    	this.text = text;
        Element i = getElement().getElementsByTagName("i").getItem(0);
        getElement().setInnerHTML((i != null ? i.toString() : "<i></i>") + 
        		" " + text);
    }

	public String getText() {
		return text;
	}
}
