package com.github.gwtbootstrap.demo.client;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Modal;
import com.github.gwtbootstrap.client.ui.SplitDropdownButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;


public class BootstrapUiBinderDemo extends Composite implements HasText {

	private static BootstrapUiBinderDemoUiBinder uiBinder = GWT
			.create(BootstrapUiBinderDemoUiBinder.class);

	interface BootstrapUiBinderDemoUiBinder extends
			UiBinder<Widget, BootstrapUiBinderDemo> {
	}

	public BootstrapUiBinderDemo() {

		initWidget(uiBinder.createAndBindUi(this));
		modalBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				modal.show();
			}
		});
	}

	@UiField
	Button button;
	
	@UiField
	Modal modal;
	
	@UiField
	Button modalBtn;
	
	@UiField SplitDropdownButton splitDropdownButton;

	public BootstrapUiBinderDemo(String firstName) {

		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
		
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {

		Window.alert("Hello!");
	}
	
	@UiHandler("splitDropdownButton")
	void onSplitClick(ClickEvent e) {
		Window.alert("Split");
	}
	
	
	public void setText(String text) {

		button.setText(text);
	}

	public String getText() {

		return button.getText();
	}

}
