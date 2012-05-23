package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.Form.SubmitCompleteEvent;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.incubator.CellTable;
import com.github.gwtbootstrap.showcase.client.resources.CustomResources;
import com.google.gwt.core.client.GWT;
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
	
}
