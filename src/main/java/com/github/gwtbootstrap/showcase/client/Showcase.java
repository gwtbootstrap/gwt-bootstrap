package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


public class Showcase extends Composite implements EntryPoint {
	
	public void onModuleLoad() {
		
	}

	private static ShowcaseUiBinder uiBinder = GWT
			.create(ShowcaseUiBinder.class);

	interface ShowcaseUiBinder extends UiBinder<Widget, Showcase> {
	}

	public Showcase() {

		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}

}
