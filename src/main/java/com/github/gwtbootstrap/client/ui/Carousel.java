/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.event.SlidEvent;
import com.github.gwtbootstrap.client.ui.event.SlidHandler;
import com.github.gwtbootstrap.client.ui.event.SlideEvent;
import com.github.gwtbootstrap.client.ui.event.SlideHandler;
import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Carousel is a widget for cycling through elements.
 *
 * @author Cássio de Freitas e Silva
 */
public class Carousel extends DivWidget {

    static {
        Configurator ADAPTER = GWT.create(Configurator.class);
        JavaScriptInjector.inject(ADAPTER.getResources().bootstrapCarouselJs().getText());
    }
    
    protected AnchorElement leftControl = DOM.createAnchor().cast();
    protected AnchorElement rightControl = DOM.createAnchor().cast();
    protected DivWidget inner = new DivWidget();

    public Carousel() {
        String elementId = HTMLPanel.createUniqueId();
        getElement().setId(elementId);

        addStyleName("carousel");
        addStyleName("slide");

        inner.addStyleName("carousel-inner");
        add(inner);
        
        leftControl.addClassName("left");
        leftControl.addClassName("carousel-control");
        leftControl.setInnerText("‹");
        leftControl.setHref("#" + elementId);
        leftControl.setAttribute("data-slide", "prev");
        getElement().appendChild(leftControl);

        rightControl.addClassName("right");
        rightControl.addClassName("carousel-control");
        rightControl.setInnerText("›");
        rightControl.setHref("#" + elementId);
        rightControl.setAttribute("data-slide", "next");
        getElement().appendChild(rightControl);
        
        setHandlerFunctions(getElement());
    }
    
    /**
     * Add a default displayed widget
     * 
     * @param widget A default displayed widget to be added
     * @param title The title of widget
     * @param description The description of widget
     */
    public void addActiveItem(Widget widget, String title, String description) {
        DivWidget item = new DivWidget();
        item.addStyleName("active");
        item.addStyleName("item");
        item.add(widget);
        
        if (title != null || description != null) {
            DivWidget carouselCaption = new DivWidget();
            carouselCaption.addStyleName("carousel-caption");
            
            if (title != null) {
                Element titleElement = DOM.createElement("h4");
                titleElement.setInnerText(title);
                carouselCaption.getElement().appendChild(titleElement);
            }
            
            if (description != null) {
                Element descriptionElement = DOM.createElement("p");
                descriptionElement.setInnerText(description);
                carouselCaption.getElement().appendChild(descriptionElement);
            }
            
            item.add(carouselCaption);
        }
        
        inner.add(item);
    }
    
    /**
     * Add a widget
     * 
     * @param widget A widget to be added
     * @param title The title of widget
     * @param description The description of widget
     */
    public void addItem(Widget widget, String title, String description) {
        DivWidget item = new DivWidget();
        item.addStyleName("item");
        item.add(widget);
        
        if (title != null || description != null) {
            DivWidget carouselCaption = new DivWidget();
            carouselCaption.addStyleName("carousel-caption");
            
            if (title != null) {
                Element titleElement = DOM.createElement("h4");
                titleElement.setInnerText(title);
                carouselCaption.getElement().appendChild(titleElement);
            }
            
            if (description != null) {
                Element descriptionElement = DOM.createElement("p");
                descriptionElement.setInnerText(description);
                carouselCaption.getElement().appendChild(descriptionElement);
            }
            
            item.add(carouselCaption);
        }
        
        inner.add(item);
    }
    
    /**
     * Starts the cycling of carousel
     * 
     * @param interval Cycling interval in ms
     */
    public void carousel(int interval) {
        carousel(getElement(), interval);
    }
    
    /**
     * Pause the cycling of carousel
     */
    public void pause() {
        pause(getElement());
    }
    
    /**
     * Cycles the carousel to a particular item
     * 
     * @param index Index of item (0 based, similar to an array)
     */
    public void selectItem(int index) {
        selectItem(getElement(), index);
    }
    
    /**
     * Cycles to the previous item
     */
    public void previousItem() {
        previousItem(getElement());
    }
    
    /**
     * Cycles to the next item
     */
    public void nextItem() {
        nextItem(getElement());
    }

    /**
     * This event fires immediately when the slide instance method is invoked
     */
    public HandlerRegistration addSlideHandler(SlideHandler handler) {
        return addHandler(handler, SlideEvent.getType());
    }

    /**
     * This event is fired when the carousel has completed its slide transition
     */
    public HandlerRegistration addSlidHandler(SlidHandler handler) {
        return addHandler(handler, SlidEvent.getType());
    }
    
    protected void onSlide() {
        fireEvent(new SlideEvent());
    }
    
    protected void onSlid() {
        fireEvent(new SlidEvent());
    }
    
    private native void carousel(Element e, int interval)/*-{
        $wnd.jQuery(e).carousel({
            interval: interval
        });
    }-*/;
    
    private native void pause(Element e)/*-{
        $wnd.jQuery(e).carousel('pause');
    }-*/;
    
    private native void selectItem(Element e, int index)/*-{
        $wnd.jQuery(e).carousel(index);
    }-*/;
    
    private native void previousItem(Element e)/*-{
        $wnd.jQuery(e).carousel('prev');
    }-*/;
    
    private native void nextItem(Element e)/*-{
        $wnd.jQuery(e).carousel('next');
    }-*/;
    
    /**
    * Links the Java functions that fire the events.
    */
    private native void setHandlerFunctions(Element e) /*-{
        var that = this;
        $wnd.jQuery(e).on('slide', function() {
            that.@com.github.gwtbootstrap.client.ui.Carousel::onSlide()();
        });
        $wnd.jQuery(e).on('slid', function() {
            that.@com.github.gwtbootstrap.client.ui.Carousel::onSlid()();
        });
    }-*/;
}
