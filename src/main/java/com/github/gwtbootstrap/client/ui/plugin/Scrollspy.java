package com.github.gwtbootstrap.client.ui.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.query.client.plugins.Plugin;

/**
 * The Scrollspy Plugin
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 */
public class Scrollspy extends GQuery {
    
    /** is initialized */
    private static boolean initialized = false;

    /** Register Data Name */
    private static final String DATA_NAME = "scrollspy";

    public static class Option {
        
        public Option(){
        }
        
        public Option(String target, int offset) {
            this.target = target;
            this.offset = offset;
        }

        private String target = null;
        
        private int offset = 10;

        /**
         * Get target
         * @return target
         */
        public String getTarget() {
            return target;
        }

        /**
         * Set target
         * @param target target
         */
        public void setTarget(String target) {
            this.target = target;
        }

        /**
         * Get offset
         * @return offset
         */
        public int getOffset() {
            return offset;
        }

        /**
         * Set offset
         * @param offset offset
         */
        public void setOffset(int offset) {
            this.offset = offset;
        }

    }
    
    private static class Targets {
        
        public Targets(int offset, String href) {
            super();
            this.offset = offset;
            this.href = href;
        }
        public int offset;
        public String href;
        
    }
    
    /**
     * The Scrollspy plugin functional Class
     * 
     * @since 2.1.0.0
     * @author ohashi keisuke
     */
    public static class ScrollspyHandler {

        GQuery element;
        private Option option;
        private String target;
        private GQuery bodyElement;
        private List<Integer> offsets = new ArrayList<Integer>();
        private List<String> targets = new ArrayList<String>();
        private String activeTarget;
        private EventBus eventBus;
        
        public EventBus getEventBus() {
            return eventBus;
        }
        
        
        
        /**
         * Default Constructor
         * @param e target element
         * @param option option 
         * @param eventBus [optional] event bus
         */
        public ScrollspyHandler(GQuery e, Option option, EventBus eventBus) {
            this.eventBus = eventBus;
            this.element = e.is("body") ? $(getNativeWindow()) : e;
            this.option = option;
            element.bind("scroll.scroll-spy.data-api" , new Function(){
                @Override
                public void f() {
                    ScrollspyHandler.this.process();
                }
            });
            
            String href = e.attr("href");
            
            if(option.getTarget() != null && !option.getTarget().isEmpty()) {
                target = option.getTarget();
            } else if(href != null && !href.isEmpty()) {
                target = href.replaceAll(".*(?=#[^\\s]+$)", "");
            } else {
                target = "";
            }
            
            target += " .nav li > a";
            bodyElement = $("body");
            refresh();
            process();
        }

        private void refresh() {
            
            this.offsets = new ArrayList<Integer>();
            this.targets = new ArrayList<String>();
            
            List<Targets> targetsList = bodyElement.find(this.target).map(new Function() {
                @Override
                public Object f(com.google.gwt.user.client.Element e, int i) {
                    GQuery element = $(e);
                    GQuery target = null;
                    String href = element.attr("data-target");
                    if(href == null || href.isEmpty()) {
                        href = element.attr("href");
                        
                    }
                    if(href.startsWith("#")) {
                        target = $(href);
                    }
                    
                    if(target != null && target.length() > 0) {
                        return new Targets(target.position().top, href);
                    } else {
                        return null;
                    }
                }
            });
            
            
            
            Collections.sort(targetsList, new Comparator<Targets>(){

                @Override
                public int compare(Targets arg0, Targets arg1) {
                    return arg0.offset - arg1.offset;
                }
            });
            
            for (Targets target : targetsList) {
                this.offsets.add(target.offset);
                this.targets.add(target.href);
            }
            
        }

        protected void process() {
            int scrollTop = element.scrollTop() + option.getOffset();
            
            int scrollHeight = element.get(0).getScrollHeight();

            if(scrollHeight == 0) {
                scrollHeight = bodyElement.get(0).getScrollHeight();
            }
            
            int maxScroll = scrollHeight - element.height();
            if(scrollTop >= maxScroll && targets.size() > 0) {
                String target = targets.get(targets.size() - 1);
                if(target != null && !target.equals(activeTarget)) {
                    activate(target);
                }
                return;
            }
            
            for(int i = offsets.size() - 1; i > 0;i--) {
                if(targets.get(i) != null 
                        && !targets.get(i).equals(activeTarget)
                        && scrollTop >= offsets.get(i)
                        && (i + 1 < offsets.size() && scrollTop <= offsets.get(i + 1))){
                    this.activate(targets.get(i));
                }
            }
        }
        
        public void activate(String target) {
            activeTarget = target;
            
            $(this.target).parent(".active").removeClass("active");
            
            String selector = this.target + "[data-target=\""+ target + "\"],"
                    + this.target + "[href=\"" + target + "\"]";
            
            GQuery active = $(selector).parent("li").addClass("active");
            
            if(active.parent(".dropdown-menu").length() != 0) {
                active = active.closest("li.dropdown").addClass("active");
            }
            //TODO trigger active activate
        }

    }
    
    private static native JavaScriptObject getNativeWindow() /*-{
        return $wnd;
    }-*/;

    /** Plugin Class for GQuery */
    public static final Class<Scrollspy> Scrollspy = GQuery.registerPlugin(Scrollspy.class,
            new Plugin<Scrollspy>() {
                public Scrollspy init(GQuery gq) {
                    return new Scrollspy(gq);
                }
            });

    protected Scrollspy(GQuery gq) {
        super(gq);
    }

    /**
     * initialized Alert Data API
     * @return alert
     */
    public Scrollspy initialize() {
        
        if(initialized) {
            return this;
        }
        
        $(window).bind("load", new Function() {
            @Override
            public void f(com.google.gwt.user.client.Element e) {
                $("[data-spy=\"scroll\"]").each(new Function() {
                    @Override
                    public void f(com.google.gwt.user.client.Element e) {
                        $(e).as(Scrollspy).scrollspy();
                    }
                });
            }
        });
        
        initialized = true;
        return this;
    }

    public Scrollspy scrollspy(Option option , EventBus eventBus) {
        initialize();
        for (Element e : elements()) {
            GQuery elem = $(e);

            ScrollspyHandler handler = elem.data(DATA_NAME, ScrollspyHandler.class);

            if (handler == null) {
                handler = new ScrollspyHandler(elem, option, eventBus);
                elem.data(DATA_NAME, handler);
            }
        }
        return this;
    }
    
    public Scrollspy scrollspy() {
        return this.scrollspy(new Option());
    }
    
    public Scrollspy scrollspy(Option option) {
        return this.scrollspy(option, null);
    }
    
    public Scrollspy refresh() {
        
        this.scrollspy(new Option());
        
        for (Element e : elements()) {
            ScrollspyHandler handler = $(e).data(DATA_NAME , ScrollspyHandler.class);
            if(handler != null) {
                handler.refresh();
            }
        }
        return this;
    }    
}
