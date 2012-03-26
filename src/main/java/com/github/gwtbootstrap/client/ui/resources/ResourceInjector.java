/*
 *  Copyright 2012 GWT Bootstrap
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to inject our resources into modules page. Use it to inject
 * JavaScript and CSS files.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class ResourceInjector {

	private static final ResourceAdapter ADAPTER = GWT.create(ResourceAdapter.class);

	/**
	 * Import the required styles and JSs to the head of modules HTML.
	 */
	public static void configure() {
		
		Resources res = ADAPTER.getResources();
		
		injectCss(res.bootstrapCss());
		if (ADAPTER.hasResponsiveDesign())
			activateResponsiveDesign(res);
		injectJs(res.jquery());
		injectJs(res.bootstrapJs());
//		injectJs(res.bootstrapCollapseJs());
	}

	public static void injectCss(TextResource r) {
//		r.ensureInjected();
		StyleInjector.inject(r.getText());
	}

	public static void injectJs(TextResource r) {
		JavaScriptInjector.inject(r.getText());
	}
	
	private static void activateResponsiveDesign(Resources res) {
		injectCss(res.bootstrapResponsiveCss());
		MetaInjector.inject("viewport", "width=device-width, initial-scale=1.0");
	}
	

	
}
