package com.github.gwtbootstrap.client.ui.plugin;

import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import java.util.HashMap;

/**
 * The Transition plugin
 *
 * @since 2.1.0.0
 * @author Cássio de Freitas e Silva
 */
public class Transition extends GQuery {
    
    private HashMap<String, String> transEndEventNames = new HashMap<String, String>();
    public final String end;
    private boolean supported;
    
    // Register the plugin in GQuery plugin system and
    // set a shortcut to the class
    public static final Class<Transition> Transition = GQuery.registerPlugin(
            Transition.class, new Plugin<Transition>() {
                @Override
                public Transition init(GQuery gq) {
                    return new Transition(gq);
                }
            });
    

    /**
     * Default plugin constructor
     */
    protected Transition(GQuery gq) {
        super(gq);
        
        transEndEventNames.put("WebkitTransition", "webkitTransitionEnd");
        transEndEventNames.put("MozTransition", "transitionend");
        transEndEventNames.put("OTransition", "oTransitionEnd otransitionend");
        transEndEventNames.put("transition", "transitionend");
        
        String end__ = null;
        for (String name : transEndEventNames.keySet()) {
            if (check(name)) {
                end__ = transEndEventNames.get(name);
                break;
            }
        }
        end = end__;
        if (end != null) {
            supported = true;
        }
    }

    /**
     * @return <code>true</code> if transiction is supported by the browser
     */
    public boolean isSupported() {
        return supported;
    }
    
    private native boolean check(String name) /*-{
        var el = document.createElement('gwtbootstrap');
        if (el.style[name] !== undefined) {
            return true;
        }
        return false;
    }-*/;

}