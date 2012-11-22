package com.github.gwtbootstrap.client.ui.plugin;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;

public class Dropdown extends GQuery {

    
    public static final String TOGGLE = "[data-toggle=\"dropdown\"]";
    
    
    /** is initialized */
    private static boolean initialized = false;

    /** Register Data Name */
    private static final String DATA_NAME = "dropdown";
    
    /** Plugin Class for GQuery */
    public static final Class<Dropdown> Dropdown = GQuery.registerPlugin(Dropdown.class,
            new Plugin<Dropdown>() {
                public Dropdown init(GQuery gq) {
                    return new Dropdown(gq);
                }
            });

    public static class DropdownHandler {
        
        public DropdownHandler(final GQuery element) {
            
            element.bind("click.dropdown.data-api" , new Function() {
                @Override
                public boolean f(Event e) {
                    return toggle(e);
                }
            });
            
            $("html").bind("click.dropdown.data-api", new Function() {
                @Override
                public boolean f(Event e) {
                    element.parent().removeClass("open");
                    return true;
                }
            });
            
        }
        
        public static boolean toggle(JavaScriptObject e) {
            GQuery that = $(e);
            if(that.is(".disabled" , ":disabled")) {
                return false;
            }
            GQuery parent = getParent(that);
            
            boolean isActive = parent.hasClass("open");
            
            cleanMenus();
            
            if(!isActive) {
                parent.toggleClass("open");
                that.focus();
            }
            return false;
        }
        
        public static boolean keydown(Event e) {
            int keyCode = e.getKeyCode();
            
            if(!(keyCode == 38 || keyCode == 40 || keyCode == 27)) {
                return true;
            }
            
            GQuery that = $(e);
            try {
                e.preventDefault();
                e.stopPropagation();
            } catch(Throwable t) {
            }
            
            if(that.is(".disabled, :disabled")) return true;
            
            GQuery parent = getParent(that);
            
            boolean isActive = parent.hasClass("open");
            
            if(!isActive || (isActive && keyCode == 27)) {
                that.click();
                return true;
            }
            
            GQuery items = $("[role=menu] li:not(.divider) a" , parent.get(0));
            
            if(items.length() == 0) {
                return true;
            }
            
            GQuery focusedItems = items.filter(":focus");
            
            int index = 0;
            if(focusedItems.length() != 0) {
                index = items.index(focusedItems.get(0));
            }
            
            if(keyCode == 38 && index > 0) index--;
            if(keyCode == 40 && index < items.length() -1) index++;
            
            items.eq(index).focus();
            return true;
        }
        
        public static void cleanMenus() {
            $(TOGGLE).each(new Function() {
                @Override
                public void f(Element e) {
                    getParent($(e)).removeClass("open");
                }
            });
        }
        
        private static GQuery getParent(GQuery e) {
            String selector = e.attr("data-target");
            
            if(selector == null || selector.isEmpty()) {
                selector = e.attr("href");
                if(selector != null && !selector.isEmpty() && selector.contains("#")) {
                    selector = selector.replaceAll(".*(?=#[^\\s]*$", "");
                }
            }
            
            GQuery parent = $(selector);
            if(parent.length() == 0) {
                parent = e.parent();
            }
            
            return parent;
        }
        
    }
    
    protected Dropdown(GQuery gq) {
        super(gq);
    }
    
    private void initialize(){
        if(initialized) {
            return;
        }
        
        $(Document.get()).as(GQuery.Events)
            .bind("click.dropdown.data-api touchstart.dropdown.data-api", new Function() {
                @Override
                public void f() {
                    DropdownHandler.cleanMenus();
                }
            })
            .delegate(".dropdown for", "", new Function() {
                @Override
                public boolean f(Event e) {
                    e.stopPropagation();
                    return false;
                }
            })
            .delegate(TOGGLE, Event.ONCLICK | Event.ONTOUCHSTART , new Function() {
                @Override
                public boolean f(Event e) {
                    
                    return DropdownHandler.toggle(e);
                }
            })
            .delegate(TOGGLE + ", [role=menu]", Event.ONKEYDOWN | Event.ONTOUCHSTART, new Function() {
                @Override
                public boolean f(Event e) {
                    return DropdownHandler.keydown(e);
                }
            });
        initialized = true;
    }
    
    public GQuery dropdown(){
        initialize();
        
        for(Element element : elements()) {
            GQuery that = $(element);
            DropdownHandler handler = that.data(DATA_NAME, DropdownHandler.class);
            if(handler == null) {
                that.data(DATA_NAME, new DropdownHandler(that));
            }
        }
        return this;
    }
    
    public GQuery dropdown(String function) {
        dropdown();
        if(function == null) return this;
        
        for (Element element : elements()) {
            if(function.equals("toggle")) {
                DropdownHandler.toggle(element);
            }
        }
        
        return this;
    }
    
    
}
