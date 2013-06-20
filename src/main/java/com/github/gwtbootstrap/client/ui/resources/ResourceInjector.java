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
package com.github.gwtbootstrap.client.ui.resources;

import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.resources.internal.InternalResourceInjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to inject our resources into modules page. Use it to inject
 * JavaScript and CSS files.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 */
public class ResourceInjector {

    private static final Configurator ADAPTER = GWT.create(Configurator.class);
    
    private static final InternalResourceInjector INJECTOR = GWT.create(InternalResourceInjector.class);

    private static HeadElement head;

    /**
     * Injects the required CSS styles and JavaScript files into the document header.
     * <pre>
     * It's for NoStyle Module.
     * </pre>
     */
    public static void configureWithCssFile() {
        
        injectResourceCssAsFile("bootstrap.min.css");
        injectResourceCssAsFile("gwt-bootstrap.css");
        injectResourceCssAsFile("font-awesome.min.css");

        configure();
        
    }
    
    /**
     * Injects the required CSS styles and JavaScript files into the document
     * header.
     */
    public static void configure() {
        INJECTOR.preConfigure();

        Resources res = ADAPTER.getResources();
        if(isNotLoadedJquery()) 
            injectJs(res.jquery());

        injectJs(res.bootstrapJs());

        if (ADAPTER.hasResponsiveDesign())
            activateResponsiveDesign(res);

        INJECTOR.configure();
    }

    private native static boolean isNotLoadedJquery() /*-{
        return !$wnd['jQuery'] || (typeof $wnd['jQuery'] !== 'function');
    }-*/;

    private static void injectCss(TextResource r) {
        StyleInjector.inject(r.getText());
    }

    /**
     * Inject public resource css file as a file.
     * @param filename inject file name
     */
    public static void injectResourceCssAsFile(String filename) {
        LinkElement link = Document.get().createLinkElement();
        link.setType("text/css");
        link.setRel("stylesheet");
        link.setHref(GWT.getModuleName() + "/css/" + filename);
        getHead().appendChild(link);
    }

    private static HeadElement getHead() {
        if (head == null) {
            Element elt = Document.get().getElementsByTagName("head").getItem(0);
            assert elt != null : "The host HTML page does not have a <head> element"
                    + " which is required by StyleInjector";
            head = HeadElement.as(elt);
        }
        return head;
    }

    private static void injectJs(TextResource r) {
        JavaScriptInjector.inject(r.getText());
    }

    private static void activateResponsiveDesign(Resources res) {
        injectCss(res.bootstrapResponsiveCss());
        MetaInjector
                .inject("viewport", "width=device-width, initial-scale=1.0");
    }

}
