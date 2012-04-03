package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.showcase.client.resources.CustomResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class GridSystem extends Composite {

	@UiField
	CodeBlock gridCode;

	@UiField
	CodeBlock offsetGridCode;
	
	@UiField
	CodeBlock nestedGridCode;
	
	private static GridSystemUiBinder uiBinder = GWT.create(GridSystemUiBinder.class);

	interface GridSystemUiBinder extends UiBinder<Widget, GridSystem> {
	}

	public GridSystem() {
		initWidget(uiBinder.createAndBindUi(this));
		CustomResources resources = CustomResources.RESOURCES;
		gridCode.setHTML(resources.gridCode().getText());
		offsetGridCode.setHTML(resources.offsetGridCode().getText());
		nestedGridCode.setHTML(resources.nestedGridCode().getText());
	}

}
