package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;

/**
 * Bootstrap Button Component.
 *
 * @author Carlos A Becker
 */
public class Button extends IconAnchor implements HasClickHandlers, 
		HasDoubleClickHandlers, HasEnabled, HasAllDragAndDropHandlers, 
		HasAllFocusHandlers, HasAllGestureHandlers, HasAllKeyHandlers,
		HasAllMouseHandlers, HasAllTouchHandlers {

    {
        removeStyleName("gwt-Button");
        addStyle(Bootstrap.Button.BTN);
    }
    
    public Button() {
    	super();
        getElement().appendChild(Document.get().createElement("i"));
    }

    public Button(String text) {
        this();
        setText(text);
    }

    public Button(String text, Icon icon) {
        this(text);
        setIcon(icon);
    }
    
    public void setStyle(Bootstrap.Button.Type type) {
    	for (Bootstrap.Button.Type t : Bootstrap.Button.Type.values())
    		removeStyle(t);
    	addStyle(type);
    }
    
    public void setType(String typeString) {
    	String type = "btn-" + typeString;
    	
    	for (Bootstrap.Button.Type t : Bootstrap.Button.Type.values()) {
    		if (type.equals(t.get()))
    			addStyle(t);
    		else
    			removeStyle(t);
    	}
    }
	
    public void setSize(Bootstrap.Button.Size size) {
    	for (Bootstrap.Button.Size s : Bootstrap.Button.Size.values())
    		removeStyle(s);
    	addStyle(size);
    }
    
    public void setSize(String sizeString) {
    	String size = "btn-" + sizeString;
    	
    	for (Bootstrap.Button.Size s : Bootstrap.Button.Size.values()) {
    		if (size.equals(s.get()))
    			addStyle(s);
    		else
    			removeStyle(s);
    	}
    }
    
    public boolean isEnabled() {
    	return getStyleName().contains("disabled");
    }
    
    public void setEnabled(boolean enabled) {
    	if(enabled)
    		addStyleName(Bootstrap.disabled);
    	else
    		removeStyleName(Bootstrap.disabled);
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    public HandlerRegistration addDoubleClickHandler(DoubleClickHandler handler) {
        return addDomHandler(handler, DoubleClickEvent.getType());
    }

    public HandlerRegistration addDragEndHandler(DragEndHandler handler) {
        return addDomHandler(handler, DragEndEvent.getType());
    }

    public HandlerRegistration addDragEnterHandler(DragEnterHandler handler) {
        return addDomHandler(handler, DragEnterEvent.getType());
    }

    public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
        return addDomHandler(handler, DragLeaveEvent.getType());
    }

    public HandlerRegistration addDragHandler(DragHandler handler) {
        return addDomHandler(handler, DragEvent.getType());
    }

    public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
        return addDomHandler(handler, DragOverEvent.getType());
    }

    public HandlerRegistration addDragStartHandler(DragStartHandler handler) {
        return addDomHandler(handler, DragStartEvent.getType());
    }

    public HandlerRegistration addDropHandler(DropHandler handler) {
        return addDomHandler(handler, DropEvent.getType());
    }

    public HandlerRegistration addFocusHandler(FocusHandler handler) {
        return addDomHandler(handler, FocusEvent.getType());
    }

    public HandlerRegistration addBlurHandler(BlurHandler handler) {
        return addDomHandler(handler, BlurEvent.getType());
    }

    public HandlerRegistration addGestureStartHandler(GestureStartHandler handler) {
        return addDomHandler(handler, GestureStartEvent.getType());
    }

    public HandlerRegistration addGestureChangeHandler(GestureChangeHandler handler) {
        return addDomHandler(handler, GestureChangeEvent.getType());
    }

    public HandlerRegistration addGestureEndHandler(GestureEndHandler handler) {
        return addDomHandler(handler, GestureEndEvent.getType());
    }

    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return addDomHandler(handler, KeyUpEvent.getType());
    }

    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return addDomHandler(handler, KeyDownEvent.getType());
    }

    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return addDomHandler(handler, KeyPressEvent.getType());
    }

    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
        return addDomHandler(handler, MouseDownEvent.getType());
    }

    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
        return addDomHandler(handler, MouseUpEvent.getType());
    }

    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
        return addDomHandler(handler, MouseOutEvent.getType());
    }

    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }

    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
        return addDomHandler(handler, MouseMoveEvent.getType());
    }

    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
        return addDomHandler(handler, MouseWheelEvent.getType());
    }

    public HandlerRegistration addTouchStartHandler(TouchStartHandler handler) {
        return addDomHandler(handler, TouchStartEvent.getType());
    }

    public HandlerRegistration addTouchMoveHandler(TouchMoveHandler handler) {
        return addDomHandler(handler, TouchMoveEvent.getType());
    }

    public HandlerRegistration addTouchEndHandler(TouchEndHandler handler) {
        return addDomHandler(handler, TouchEndEvent.getType());
    }

    public HandlerRegistration addTouchCancelHandler(TouchCancelHandler handler) {
        return addDomHandler(handler, TouchCancelEvent.getType());
    }

}
