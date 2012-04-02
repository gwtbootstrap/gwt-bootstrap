/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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

	@UiField
	SplitDropdownButton splitDropdownButton;

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

	@UiHandler("contentButton")
	void onClickContentSave(ClickEvent e) {

		Modal testModal = new Modal();
		testModal.setTitle("Lalala");
		testModal.show();
//		modal.hide();
//		Window.alert("Hello!");
	}

	@UiHandler("saveButton")
	void onClickSave(ClickEvent e) {
		modal.hide();
//		Window.alert("Hello!");
	}

}
