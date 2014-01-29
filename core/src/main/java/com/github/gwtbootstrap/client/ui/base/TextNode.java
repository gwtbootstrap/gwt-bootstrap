package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TextNode extends Widget implements HasText {

    private Text baseNode;
    private boolean attached;
    
    public TextNode() {
    }

    public TextNode(String text) {
        setText(text);
    }


    @Override
    public String getText() {
        
        return baseNode != null ? baseNode.getData() : null;
    }


    @Override
    public void setText(String text) {
        assert baseNode == null : "TextNode can be set once";
        baseNode = Document.get().createTextNode(text);
        setElement(baseNode.<Element>cast());
    }
    
    @Override
    public boolean isAttached() {
        return attached;
    }
    
    @Override
    protected void onAttach() {
        
        if(isAttached()) {
            throw new IllegalStateException("already added");
        }
        
        this.attached = true;
        
        onLoad();
        
        AttachEvent.fire(this, attached);
    }
    
    @Override
    protected void onDetach() {
        
        if(!isAttached()) {
            throw new IllegalStateException("is not attached");
        }
        
        this.attached = false;
        
        AttachEvent.fire(this, attached);
    }
    
    
}
