package com.github.gwtbootstrap.client.ui.plugin;

import java.util.HashMap;
import java.util.Map;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;

/**
 * The Button plugin
 * 
 * @since 2.1.0.0
 * @author ohashi keisuke
 */
public class Button extends GQuery {

    private static boolean initialized = false;
    
    // Register the plugin in GQuery plugin system and
    // set a shortcut to the class
    public static final Class<Button> Button = GQuery.registerPlugin(
            Button.class, new Plugin<Button>() {
                public Button init(GQuery gq) {
                    return new Button(gq);
                }
            });

    private static final String DATA_NAME = "button";

    /**
     * Button plugin options
     * 
     * @author ohashi keisuke
     * 
     */
    public static class Option {

        /** stateTextMap */
        private Map<String, String> stateTextMap;

        /**
         * Default Constractor
         */
        public Option() {
            stateTextMap = new HashMap<String, String>();
            stateTextMap.put("loading", "loading...");
        }

        /**
         * Initialize with state text.
         * 
         * @param states
         *            state-text map
         */
        public Option(Map<String, String> states) {
            this();
            stateTextMap.putAll(states);
        }

        /**
         * Get State text
         * 
         * @param state
         *            state (not need suffix "Text")
         * @return State text
         */
        public String getStateText(String state) {
            return stateTextMap.get(state);
        }

        /**
         * Does it have state text?
         * 
         * @param state
         *            check state
         * @return true:has state false: does not have state
         */
        public boolean hasStateText(String state) {
            return stateTextMap.containsKey(state);
        }

        /**
         * Add new state text
         * 
         * @param state
         *            state
         * @param text
         *            state-text
         * @return this for chain
         */
        public Option addStateText(String state, String text) {
            this.stateTextMap.put(state, text);
            return this;
        }
        
        public Option removeStateText(String state) {
            this.stateTextMap.remove(state);
            return this;
        }

    }

    /**
     * The Button plugin functional Class
     * 
     * @author ohashi keisuke
     */
    public static class ButtonHandler {

        private final GQuery elem;
        private final Option option;

        /**
         * Default Constractor
         * 
         * @param elem
         *            target element
         * @param option
         *            options
         */
        public ButtonHandler(GQuery elem, Option option) {
            this.elem = elem;
            this.option = option;
        }

        /**
         * Toggle button
         */
        public void toggle() {
            GQuery parent = elem.parents("[data-toggle=\"buttons-radio\"]");
            if (parent.length() > 0) {
                parent.find("." + Constants.ACTIVE).removeClass(
                        Constants.ACTIVE);
            }

            elem.toggleClass(Constants.ACTIVE);
        }

        /**
         * Change state
         * 
         * @param state
         *            state
         */
        public void setState(final String state) {
            boolean isInput = elem.is("input");

            if (!option.hasStateText(state)) {
                if (isInput) {
                    option.addStateText("reset", elem.val());
                } else {
                    option.addStateText("reset", elem.html());
                }
            }

            if (isInput) {
                elem.val(option.getStateText(state));
            } else {
                elem.html(option.getStateText(state));
            }

            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {

                @Override
                public void execute() {
                    if (state.equals("loading")) {
                        elem.addClass(Constants.DISABLED).attr(
                                Constants.DISABLED, Constants.DISABLED);
                    } else {
                        elem.removeClass(Constants.DISABLED).removeAttr(
                                Constants.DISABLED);
                    }
                }
            });

        }

    }
    
    /**
     * initialized Button Data API
     * @return button
     */
    public GQuery initializeButton() {
        
        if(initialized) {
            return this;
        }
        
        $("body").bind(Event.ONCLICK, "[data-toggle^=button]", new Function(){
            @Override
            public boolean f(com.google.gwt.user.client.Event e) {
                Button elem = $(e.getEventTarget()).as(Button);
                
                if(!elem.hasClass(Constants.BTN)) {
                    elem.closest("." + Constants.BTN);
                }
                
                elem.button("toggle");
                return false;
            }
        });
        
        initialized = true;
        
        return this;
    }

    /**
     * Default Constracutor
     * 
     * @param gq
     *            gq
     */
    protected Button(GQuery gq) {
        super(gq);
    }

    /**
     * Active button plugin
     * 
     * @return this
     */
    public GQuery button() {

        return button(new Option());
    }

    /**
     * Active Button plugin with optoins
     * 
     * @param option
     *            option
     * @return this
     */
    public GQuery button(Option option) {

        for (Element e : elements()) {

            GQuery elem = $(e);

            ButtonHandler handler = elem.data(DATA_NAME, ButtonHandler.class);

            if (handler == null) {
                handler = new ButtonHandler(elem, option);
                elem.data(DATA_NAME, handler);
            }
        }

        return this;
    }

    /**
     * Call button methods
     * 
     * @param state
     *            toggle:call toggle method, other:setState
     * @return this
     */
    public GQuery button(String state) {

        this.button();

        if (state == null) {
            return this;
        }

        for (Element e : elements()) {
            GQuery elem = $(e);

            ButtonHandler handler = elem.data(DATA_NAME, ButtonHandler.class);

            if ("toggle".equals(state)) {
                handler.toggle();
            } else {
                handler.setState(state);
            }

        }
        return this;
    }

}
