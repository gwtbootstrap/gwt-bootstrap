package com.geekvigarista.gwt.bootstrap.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * BootStrap Resources.
 * 
 * @author Carlos Alexandro Becker
 * @since 22/01/2012
 */
public interface Resources extends ClientBundle {

	public static Resources RESOURCES = GWT.create(Resources.class);

	/*
	 * importing as a textresource, for now, at least.
	 */
	@Source("bootstrap.min.css")
	TextResource bootstrap();

	@Source("jquery-1.7.1.min.js")
	TextResource jquery();

	@Source("bootstrap-alerts.js")
	TextResource alerts();

	@Source("bootstrap-buttons.js")
	TextResource buttons();

	@Source("bootstrap-dropdown.js")
	TextResource dropdown();

	@Source("bootstrap-modal.js")
	TextResource modal();

	@Source("bootstrap-popover.js")
	TextResource popover();

	@Source("bootstrap-scrollspy.js")
	TextResource scrollspy();

	@Source("bootstrap-tabs.js")
	TextResource tabs();

	@Source("bootstrap-twipsy.js")
	TextResource twipsy();
}
