package com.github.gwtbootstrap.client.ui.plugin;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.event.CloseEvent;
import com.github.gwtbootstrap.client.ui.event.ClosedEvent;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;
import com.google.gwt.user.client.Event;

/**
 * The Alert Plugin
 * 
 * @since 2.1.0.0
 * @author ohashi keisuke
 */
public class Alert extends GQuery {
    
    /** dismiss selector */
    private static final String DISSMISS = "[data-dismiss=\"alert\"]";

    /** is initialized */
    private static boolean initialized = false;

    /** Register Data Name */
    private static final String DATA_NAME = "alert";

    /**
     * The Alert plugin functional Class
     * 
     * @since 2.1.0.0
     * @author ohashi keisuke
     */
    public static class AlertHandler {

        /** The Event Bus for Close/ClosedEvent */
        private final EventBus eventBus;

        /**
         * Default Constructor
         * @param e target element
         * @param eventBus [optional] event bus
         */
        public AlertHandler(GQuery e, EventBus eventBus) {
            this.eventBus = eventBus;
            if(e != null) {
                e.delegate(DISSMISS, Event.ONCLICK, new Function() {
                    @Override
                    public boolean f(Event event) {
                        return close(event);
                    }
                });
            }
        }
        
        /**
         * Constructor, not event handle.
         * @param e target element
         */
        public AlertHandler(GQuery e) {
            this(e , null);
        }
        public boolean close(Event e) {
            if(e != null) {
                try {
                    e.preventDefault();
                } catch (Exception ex) {
                }
            }
            
            return close($(e.getEventTarget()));
        }
        
        public boolean close(GQuery element) {
            GQuery target = element;
            String selector = target.attr("data-target");

            if (selector == null || selector.isEmpty()) {
                selector = target.attr("href");
                if (selector != null && !selector.isEmpty()) {
                    selector =  selector.replace(".*(?=#[^\\s]*$", "");
                }
            }

            GQuery parent = $(selector);

            if (parent.length() == 0) {
                parent = target.hasClass(Constants.ALERT) ? target : target.parent();
            }
            
            if (eventBus != null) {
                
                final CloseEvent closeEvent = new CloseEvent();
                parent.each(new Function() {
                    @Override
                    public void f(com.google.gwt.user.client.Element e) {
                        eventBus.fireEventFromSource(closeEvent , e);
                    }
                });
                if (closeEvent.isCanceled()) {
                    return false;
                }
            }

            parent.removeClass("in");

            final GQuery p = parent;

            final Function removeElement = new Function() {
                @Override
                public void f() {
                    if (eventBus != null) {
                        p.each(new Function() {
                            @Override
                            public void f(com.google.gwt.user.client.Element e) {
                                eventBus.fireEventFromSource(new ClosedEvent() , e);
                            }
                        });
                    }
                    p.remove();
                }
            };

            // TODO keisuke.oohashi 2012/08/13 delay time should be setting from
            // outer.
            // TODO keisuke.oohashi 2012/08/13 if trasition style is not supported,it should not be called.
            if (parent.hasClass(Constants.FADE)) {
                Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

                    @Override
                    public boolean execute() {
                        removeElement.f();
                        return false;
                    }
                }, 150);
            } else {
                removeElement.f();
            }

            return false;
        }

    }

    /** Plugin Class for GQuery */
    public static final Class<Alert> Alert = GQuery.registerPlugin(Alert.class,
            new Plugin<Alert>() {
                public Alert init(GQuery gq) {
                    return new Alert(gq);
                }
            });

    protected Alert(GQuery gq) {
        super(gq);
    }

    /**
     * initialized Alert Data API
     * @return alert
     */
    public Alert initialize() {
        
        if(initialized) {
            return this;
        }
        
        $("body").delegate(DISSMISS, Event.ONCLICK, new Function() {
            @Override
            public boolean f(Event e) {
                e.preventDefault();
                new AlertHandler(null, null).close(e);
                
                return false;
            }
        });
        
        initialized = true;
        
        return this;
    }

    public Alert alert(EventBus eventBus) {

        for (Element e : elements()) {
            GQuery elem = $(e);

            AlertHandler handler = elem.data(DATA_NAME, AlertHandler.class);

            if (handler == null) {
                handler = new AlertHandler(elem, eventBus);
                elem.data(DATA_NAME, handler);
            }
        }
        return this;
    }

    /**
     * Close Alert
     * @return this
     */
    public Alert close() {

        for (Element e : elements()) {
            GQuery elem = $(e);
            AlertHandler handler = elem.data(DATA_NAME, AlertHandler.class);

            if (handler != null) {
                handler.close(elem);
            }
        }
        return this;
    }
    
    /**
     * Destroy Alert Data
     * @return this
     */
    public Alert destroy() {
        
        for (Element e : elements()) {
            GQuery elem = $(e);
            
            if(elem.data(DATA_NAME) != null) {
                elem.removeData(DATA_NAME);
            }
        }
        
        return this;
    }
    
}
