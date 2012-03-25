package com.github.gwtbootstrap.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Bootstrap Resources.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public interface Resources extends ClientBundle {

	public static Resources RESOURCES = GWT.create(Resources.class);

	// Imported as a TextResource until GWT supports CSS3.
	@Source("css/bootstrap.min.css")
	TextResource bootstrapCss();

//	@Source("css/prettify.css")
//	TextResource prettify_css();

	@Source("js/jquery-1.7.1.min.js")
	TextResource jquery();
	
	@Source("js/bootstrap.min.js")
	TextResource bootstrapJs();

	@Source("css/bootstrap-responsive.min.css")
	TextResource bootstrapResponsiveCss();

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
