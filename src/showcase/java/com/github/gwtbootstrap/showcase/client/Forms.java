package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.Form.SubmitCompleteEvent;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.showcase.client.resources.CustomResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class Forms extends Composite {

	private static FormsUiBinder uiBinder = GWT.create(FormsUiBinder.class);

	@UiField CodeBlock basicFormCode;
	@UiField CodeBlock searchFormCode;
	@UiField CodeBlock inlineFormCode;
	@UiField CodeBlock horizontalFormCode;
	@UiField TextBox name;
	@UiField ListBox example;
	
	interface FormsUiBinder extends UiBinder<Widget, Forms> {
	}

	public Forms() {
		initWidget(uiBinder.createAndBindUi(this));
		basicFormCode.setHTML(CustomResources.RESOURCES.basicFormCode().getText());
		searchFormCode.setHTML(CustomResources.RESOURCES.searchFormCode().getText());
		inlineFormCode.setHTML(CustomResources.RESOURCES.inlineFormCode().getText());
		horizontalFormCode.setHTML(CustomResources.RESOURCES.horizontalFormCode().getText());
	}
	
	@UiHandler("submitExampleForm")
	public void onSubmitForm(SubmitEvent e) {
		
		String show = "user name: " + name.getValue() + "\n favorite: " + example.getValue();
		
		Window.alert(show);
		
	}
	
	@UiHandler("submitExampleForm")
	public void onSubmitCompleteForm(SubmitCompleteEvent e) {
		Window.alert("complete");
	}
	

}
