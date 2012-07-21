package com.github.gwtbootstrap.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class ResponsiveUtilityView extends Composite {

	private static ResponsiveUtilityViewUiBinder uiBinder = GWT.create(ResponsiveUtilityViewUiBinder.class);

	interface ResponsiveUtilityViewUiBinder extends UiBinder<Widget, ResponsiveUtilityView> {
	}

	public ResponsiveUtilityView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
