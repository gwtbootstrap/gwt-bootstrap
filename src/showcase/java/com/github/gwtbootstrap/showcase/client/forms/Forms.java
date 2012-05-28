package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ButtonGroup;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.Controls;
import com.github.gwtbootstrap.client.ui.Fieldset;
import com.github.gwtbootstrap.client.ui.FileUpload;
import com.github.gwtbootstrap.client.ui.Form.SubmitCompleteEvent;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
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
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;


public class Forms extends Composite {

	private static FormsUiBinder uiBinder = GWT.create(FormsUiBinder.class);

	@UiField CodeBlock basicFormCode;
	@UiField CodeBlock searchFormCode;
	@UiField CodeBlock inlineFormCode;
	@UiField CodeBlock horizontalFormCode;
	@UiField TextBox name;
	@UiField ListBox example;
	
	
	@UiField ButtonGroup controlGroupButtons;
	@UiField Fieldset controlFieldset;
	@UiField TextBox controlText;
	@UiField PasswordTextBox controlPasswordTextBox;
	@UiField FileUpload controlFileUpload;
	@UiField TextArea controlTextarea;
	@UiField CheckBox controlCheckbox;
	@UiField Controls controlRadioControls;
	@UiField ListBox controlList;
	
	
	
	@UiField(provided=true) CellTable<Sample> exampleTable;
	ListDataProvider<Sample> dataProvider = new ListDataProvider<Forms.Sample>();
	
	
	interface FormsUiBinder extends UiBinder<Widget, Forms> {
	}

	public Forms() {
		
		exampleTable = new SampleTable();
		initWidget(uiBinder.createAndBindUi(this));
		basicFormCode.setHTML(CustomResources.RESOURCES.basicFormCode().getText());
		searchFormCode.setHTML(CustomResources.RESOURCES.searchFormCode().getText());
		inlineFormCode.setHTML(CustomResources.RESOURCES.inlineFormCode().getText());
		horizontalFormCode.setHTML(CustomResources.RESOURCES.horizontalFormCode().getText());
		dataProvider.addDataDisplay(exampleTable);
		

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
	
	@UiHandler("submitExampleForm")
	public void onSubmitForm(SubmitEvent e) {
		
		String show = "user name: " + name.getValue() + "\n favorite: " + example.getValue();
		
		Window.alert(show);
		
	}
	
	@UiHandler("submitExampleForm")
	public void onSubmitCompleteForm(SubmitCompleteEvent e) {
		
		dataProvider.getList().add(new Sample(name.getText(), example.getValue()));
		dataProvider.flush();
	}
	
	public static class Sample {
		
		public Sample(String userName,
			String choice) {
			super();
			this.userName = userName;
			this.choice = choice;
		}

		private String userName;
		
		private String choice;
	}
	
	private static class SampleTable extends CellTable<Sample>{
		public SampleTable() {
			super(100);
			setEmptyTableWidget(new Label("Please add data."));

			addColumn(new TextColumn<Forms.Sample>() {

				@Override
				public String getValue(Sample object) {
					return String.valueOf(SampleTable.this.getRowCount());
				}
			} , "#");

			addColumn(new TextColumn<Forms.Sample>() {

				@Override
				public String getValue(Sample object) {
					return object.userName;
				}
			},"User Name");

			
			addColumn(new TextColumn<Forms.Sample>() {

				@Override
				public String getValue(Sample object) {
					return object.choice;
				}
			},"Favorite");
			
			setStriped(true);
			setCondensed(true);
			setBordered(true);
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
