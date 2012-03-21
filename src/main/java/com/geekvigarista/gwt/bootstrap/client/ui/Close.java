package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Anchor;

/**
 * A close icon.
 * 
 * @author Dominik Mayer
 */
public class Close extends Anchor {

	public Close() {
		setStyleName(BootstrapCssResources.close);
		setHTML("&times;");
	}
}
