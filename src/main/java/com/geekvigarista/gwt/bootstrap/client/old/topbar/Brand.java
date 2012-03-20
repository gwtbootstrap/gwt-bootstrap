package com.geekvigarista.gwt.bootstrap.client.old.topbar;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.Anchor;

public class Brand extends Anchor {
	public Brand(String projectName) {
		getElement().setClassName(BootstrapCssResources.brand);
		getElement().addClassName(BootstrapCssResources.active);
		getElement().setAttribute("href", "#");
		getElement().setInnerText(projectName);
	}
}
