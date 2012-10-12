package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TextNode extends Widget implements HasText {

    private Text baseNode;
    
    
    public TextNode() {
        baseNode = Document.get().createTextNode("");
        setElement(baseNode.<Element>cast());
    }


    @Override
    public String getText() {
        return baseNode.getData();
    }


    @Override
    public void setText(String text) {
        baseNode.setData(text);
    }
    
    
    
    
}
