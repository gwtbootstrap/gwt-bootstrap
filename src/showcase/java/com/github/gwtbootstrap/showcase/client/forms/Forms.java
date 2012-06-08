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
package com.github.gwtbootstrap.showcase.client.forms;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ButtonGroup;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.Controls;
import com.github.gwtbootstrap.client.ui.Fieldset;
import com.github.gwtbootstrap.client.ui.FileUpload;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.RadioButton;
import com.github.gwtbootstrap.client.ui.TextArea;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.github.gwtbootstrap.showcase.client.resources.CustomResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class Forms extends Composite {

	private static FormsUiBinder uiBinder = GWT.create(FormsUiBinder.class);

	@UiField CodeBlock basicFormCode;
	@UiField CodeBlock searchFormCode;
	@UiField CodeBlock inlineFormCode;
	@UiField CodeBlock horizontalFormCode;
	
	
	@UiField ButtonGroup controlGroupButtons;
	@UiField Fieldset controlFieldset;
	@UiField TextBox controlText;
	@UiField PasswordTextBox controlPasswordTextBox;
	@UiField FileUpload controlFileUpload;
	@UiField TextArea controlTextarea;
	@UiField CheckBox controlCheckbox;
	@UiField Controls controlRadioControls;
	@UiField ListBox controlList;
	
	interface FormsUiBinder extends UiBinder<Widget, Forms> {
	}

	public Forms() {
		
		initWidget(uiBinder.createAndBindUi(this));
		basicFormCode.setHTML(CustomResources.RESOURCES.basicFormCode().getText());
		searchFormCode.setHTML(CustomResources.RESOURCES.searchFormCode().getText());
		inlineFormCode.setHTML(CustomResources.RESOURCES.inlineFormCode().getText());
		horizontalFormCode.setHTML(CustomResources.RESOURCES.horizontalFormCode().getText());
		
		initControlButtonGroups();
	}

	private void initControlButtonGroups() {
		for (final ControlGroupType type : ControlGroupType.values()) {
			Button controlGroupButton = new Button(type.name());
			
			switch (type) {
			case ERROR:
				controlGroupButton.setType(ButtonType.DANGER);
				break;
			case SUCCESS:
				controlGroupButton.setType(ButtonType.INFO);
				break;
			case WARNING:
				controlGroupButton.setType(ButtonType.WARNING);
				break;
			case NONE:
				controlGroupButton.setType(ButtonType.DEFAULT);
			default:
				break;
			}
			
			
			
			controlGroupButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					
					for(Widget w : controlFieldset) {
						if (w instanceof ControlGroup) {
							ControlGroup cg = (ControlGroup) w;
							
							cg.setType(type);
							
						}
					}
					
				}
			});
			
			controlGroupButtons.add(controlGroupButton);
		}
		
		
	}
	
	@UiHandler({"enableButton" , "disableButton"})
	public void onDisabledButtonClick(ClickEvent c) {
		
		Button b = (Button)c.getSource();
		
		String text = b.getText();
		
		boolean enable = text.equals("Enable");
		controlText.setEnabled(enable);
		controlPasswordTextBox.setEnabled(enable);
		controlTextarea.setEnabled(enable);
		controlFileUpload.setEnabled(enable);
		controlCheckbox.setEnabled(enable);
		for (Widget widget : controlRadioControls) {
			
			if (widget instanceof RadioButton) {
				RadioButton radio = (RadioButton) widget;
				radio.setEnabled(enable);
			}
		}
		
		controlList.setEnabled(enable);
		
	}
}
