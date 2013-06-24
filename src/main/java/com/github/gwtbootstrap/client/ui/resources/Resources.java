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
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Interface that provides the Bootstrap resources.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * 
 * @author Dominik Mayer
 */
public interface Resources extends ClientBundle {

	public static Resources RESOURCES = GWT.create(Resources.class);

	/**
	 * Returns the Bootstrap CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Bootstrap CSS file
	 */
	// Imported as a TextResource until GWT supports CSS3.
	@Source("css/bootstrap.min.css")
	TextResource bootstrapCss();
	
	/**
	 * Returns the required jQuery version.
	 * <p>
	 * By default, GWT Bootstrap uses jQuery 1.10.1. Override this method to
	 * provide a different version of jQuery.
	 * 
	 * @return the jQuery JavaScript Library
	 */
	@Source("js/jquery-1.10.1.min.js")
	TextResource jquery();

	/**
	 * Returns a version of Bootstrap with all plugins included.
	 * <p>
	 * The first three digits in the GWT Bootstrap version number specify the
	 * provided Bootstrap version. (GWT Bootstrap 2.0.4.0 uses Bootstrap 2.0.2.
	 * GWT Bootstrap 2.1.2.3 will use Bootstrap 2.1.2.)
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of Bootstrap. You
	 * might want to chose a more lightweight implementation without some of the
	 * plugins. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap JavaScript
	 */
	@Source("js/bootstrap.min.js")
	TextResource bootstrapJs();

	/**
	 * Returns the responsive extension to Bootstrap.
	 * <p>
	 * The responsive design is neither injected nor activated by default. You
	 * have to implement your own {@link Configurator} and let
	 * {@link Configurator#hasResponsiveDesign()} return {@code true}.
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of the responsive
	 * extension. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap responsive extension JavaScript
	 */
	@Source("css/bootstrap-responsive.min.css")
	TextResource bootstrapResponsiveCss();

	/**
	 * Returns the GWT-Bootstrap CSS.
	 * <p>
	 * It contains styles that overrides conflicting GWT styles.
	 * </p>
	 * <p>
	 * <b>Don't override this unless you know what you're doing!</b>
	 * </p>
	 * 
	 * @return the GWT-Bootstrap styles
	 */
	@Source("css/gwt-bootstrap.css")
	TextResource gwtBootstrapCss();

    @Source("css/font-awesome.min.css")
    TextResource fontAwesomeCss();

//	@Source("js/bootstrap-collapse.js")
//	TextResource bootstrapCollapseJs();

//	@Source("css/prettify.css")
//	TextResource prettify_css();

//	@Source("js/prettify/prettify.js")
//	TextResource prettify_js();

//	@Source("js/prettify.js")
//	TextResource prettify_js();

//	@Source("js/bootstrap-alerts.js")
//	TextResource alerts();
//
//	@Source("js/bootstrap-buttons.js")
//	TextResource buttons();
//
//	@Source("js/bootstrap-dropdown.js")
//	TextResource dropdown();
//
//	@Source("js/bootstrap-modal.js")
//	TextResource modal();
//
//	@Source("js/bootstrap-popover.js")
//	TextResource popover();
//
//	@Source("js/bootstrap-scrollspy.js")
//	TextResource scrollspy();
//
//	@Source("js/bootstrap-tabs.js")
//	TextResource tabs();
//
//	@Source("js/bootstrap-twipsy.js")
//	TextResource twipsy();
}
