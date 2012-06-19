package com.github.gwtbootstrap.showcase.client;

import java.util.Arrays;

import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.Divider;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.NavText;
import com.github.gwtbootstrap.client.ui.Popover;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.Trigger;
import com.github.gwtbootstrap.showcase.client.util.EnumRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class Popovers extends Composite implements Editor<Popover> {

	@UiField
	@Editor.Ignore
	NavLink fooNavlink;

	@UiField
	@Editor.Ignore
	NavLink barNavlink;

	@UiField
	@Editor.Ignore
	Divider divider;

	@UiField
	@Editor.Ignore
	NavText navText;

	@UiField
	Popover popover;
	
	@UiField
	CheckBox animation;

	@UiField
	TextBox text;

	@UiField
	TextBox heading;
	
	@UiField(provided=true)
	ValueListBox<Placement> placement = new ValueListBox<Placement>(new EnumRenderer<Placement>("choose display placement"));
	
	@UiField(provided=true)
	ValueListBox<Trigger> trigger = new ValueListBox<Trigger>(new EnumRenderer<Trigger>("choose trigger"));

	@UiField
	IntegerBox showDelay;
	
	@UiField
	IntegerBox hideDelay;
	
	interface Driver extends SimpleBeanEditorDriver<Popover, Popovers> {
	}

	Driver driver = GWT.create(Driver.class);

	private static PopoversUiBinder uiBinder = GWT.create(PopoversUiBinder.class);

	interface PopoversUiBinder extends UiBinder<Widget, Popovers> {
	}

	public Popovers() {
		
		initWidget(uiBinder.createAndBindUi(this));
		
		placement.setAcceptableValues(Arrays.asList(Placement.values()));
		trigger.setAcceptableValues(Arrays.asList(Trigger.values()));
		
		driver.initialize(this);
		
		driver.edit(popover);
		
		setupPopover(fooNavlink, "Foo", "say foo!");
		setupPopover(barNavlink, "Bar", "say bar!");
		setupPopover(divider, "Divider", "It's a divider");
		setupPopover(navText, "NavText", "You can use this after login.");
	}

	private void setupPopover(Widget w, String heading, String message) {
		Popover popover = new Popover();
		
		popover.setWidget(w);
		
		popover.setText(message);
		
		popover.setHeading(heading);
		
		popover.setPlacement(Placement.RIGHT);
		
		popover.reconfigure();
	}
	
	@UiHandler({"text" , "heading" })
	public void onChangeText(ValueChangeEvent<String> e) {
		if(e.getValue() == null) {
			return;
		}
		reconfigurePopover();		
	}
	
	@UiHandler({"showDelay" , "hideDelay"})
	public void onChangeDelay(ValueChangeEvent<Integer> e) {
		if(e.getValue() == null) {
			return;
		}
		reconfigurePopover();
	}
	
	@UiHandler("placement")
	public void onChangePlacement(ValueChangeEvent<Placement> e) {
		if(e.getValue() == null) {
			return;
		}
		reconfigurePopover();
	}
	
	@UiHandler( "trigger")
	public void onChangeTrigger(ValueChangeEvent<Trigger> e) {
		if(e.getValue() == null) {
			return;
		}
		reconfigurePopover();
	}
	
	@UiHandler("animation")
	public void onChangeAnimation(ValueChangeEvent<Boolean> e) {
		if(e.getValue() == null) {
			return;
		}
		reconfigurePopover();
	}

	private void reconfigurePopover() {
		
		popover = driver.flush();
		
		if(popover.getText() == null
			|| popover.getHeading() == null
			|| popover.getTrigger() == null
			|| popover.getPlacement() == null) {
			return;
		}
		
		popover.reconfigure();
		
		
	}

}
