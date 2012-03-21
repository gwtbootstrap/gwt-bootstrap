package com.geekvigarista.gwt.bootstrap.client.old.topbar;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Anchor;

public class Brand extends Anchor {
	public Brand(String projectName) {
		getElement().setClassName(Bootstrap.brand);
		getElement().addClassName(Bootstrap.active);
		getElement().setAttribute("href", "#");
		getElement().setInnerText(projectName);
	}
}
