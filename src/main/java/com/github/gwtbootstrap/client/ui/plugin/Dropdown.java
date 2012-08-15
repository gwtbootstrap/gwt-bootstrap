package com.github.gwtbootstrap.client.ui.plugin;

import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;

public class Dropdown extends GQuery {

    private static final String TOGGLE = "[data-toggle=\"dropdown\"]";
    
    
    
    /** is initialized */
    private static boolean initialized = false;

    /** Register Data Name */
    private static final String DATA_NAME = "dropdown";
    
    /** Plugin Class for GQuery */
    public static final Class<Dropdown> Alert = GQuery.registerPlugin(Dropdown.class,
            new Plugin<Dropdown>() {
                public Dropdown init(GQuery gq) {
                    return new Dropdown(gq);
                }
            });

    public static class DropdownHandler {
        
        public DropdownHandler(final GQuery e) {
            
            e.bind(Event.ONCLICK , null, new Function() {
                
            });
            
            
        }
        
    }
    
    protected Dropdown(GQuery gq) {
        super(gq);
    }
    
    
    

}
