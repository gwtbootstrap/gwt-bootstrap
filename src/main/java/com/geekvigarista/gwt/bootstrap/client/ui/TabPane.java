package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Random;

/**
 * Tab Pane for tabbable nav.
 * 
 * @author Dominik Mayer
 */
public class TabPane extends DivWidget {
	
	private String heading;
	
	private String href;
	
	public @UiConstructor TabPane(String heading) {
		setStyleName(Bootstrap.tab_pane);
		this.heading = heading;
		createHref();
	}
	
	private void createHref() {
		String randomString = String.valueOf(Random.nextInt(2147483647));
		setHref("bs-" + randomString);
	}
	
	public void setHref(String href) {
		this.href = href;
		getElement().setId(href);
	}

	public void setActive(boolean active) {
		if (active)
			setStyleName(Bootstrap.active);
		else
			removeStyleName(Bootstrap.active);
	}
	
	public String getHeading() {
		return heading;
	}
	
	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getId() {
		return href;
	}

	public boolean isActive() {
		return getStyleName().contains(Bootstrap.active);
	}
}
