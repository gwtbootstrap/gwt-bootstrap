package com.geekvigarista.gwt.bootstrap.client.v2;

import com.geekvigarista.gwt.bootstrap.client.v2.base.ComplexWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasText;

/**
 * Bootstrap Button Component.
 *
 * @author Carlos A Becker
 */
public class Button extends ComplexWidget implements HasText, HasClickHandlers, 
		HasDoubleClickHandlers, HasEnabled, HasAllDragAndDropHandlers, 
		HasAllFocusHandlers, HasAllGestureHandlers, HasAllKeyHandlers,
		HasAllMouseHandlers, HasAllTouchHandlers {

    public enum OPTION {

        DEFAULT {

            @Override
            public String getStyle() {
                return "btn";
            }
        },
        LARGE {

            @Override
            public String getStyle() {
                return "btn-large";
            }
        },
        SMALL {

            @Override
            public String getStyle() {
                return "btn-small";
            }
        },
        PRIMARY {

            @Override
            public String getStyle() {
                return "btn-primary";
            }
        },
        INFO {

            @Override
            public String getStyle() {
                return "btn-info";
            }
        },
        DANGER {

            @Override
            public String getStyle() {
                return "btn-danger";
            }
        },
        SUCCESS {

            @Override
            public String getStyle() {
                return "btn-success";
            }
        },
        WARNING {

            @Override
            public String getStyle() {
                return "btn-warning";
            }
        },
        INVERSE {

            @Override
            public String getStyle() {
                return "btn-inverse";
            }
        },
        MINI {

            @Override
            public String getStyle() {
                return "btn-mini";
            }
        };

        public abstract String getStyle();
    }

    {
        removeStyleName("gwt-Button");
        addStyleName(OPTION.DEFAULT.getStyle());
    }
    
    private String text;
    
    private Button() {
    	
    	super("a");
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

    public Button(String text, OPTION[] options) {
        this(text, options, null);
    }

    public Button(String text, OPTION[] options, Icon icon) {
        this(text, icon);
        for (OPTION option : options) {
            addStyleName(option.getStyle());
        }
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
	
	public void setOptions(String optionstring) {
		String[] options = optionstring.split(" ");
		String output = "";
		for (String s : options) {
			output += (" btn-" + s);
		}
		addStyleDependentName(output);
	}

    public void addOption(OPTION option) {
        addStyleDependentName(option.getStyle());
    }

    public void removeOption(OPTION option) {
        if (getStyleName().contains(option.getStyle())) {
            removeStyleName(option.getStyle());
        }
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    public HandlerRegistration addDoubleClickHandler(DoubleClickHandler handler) {
        return addDomHandler(handler, DoubleClickEvent.getType());
    }

    public boolean isEnabled() {
        return getStyleName().contains("disabled");
    }

    public void setEnabled(boolean enabled) {
        addStyleName("disabled");
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
