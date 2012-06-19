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
package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.Divider;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.NavText;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.github.gwtbootstrap.client.ui.constants.Placement;
import com.github.gwtbootstrap.client.ui.constants.VisibilityChange;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author: Carlos A Becker
 */
public class Tooltips extends Composite {

	@UiField
	NavLink fooNavlink;

	@UiField
	NavLink barNavlink;

	@UiField
	Divider divider;

	@UiField
	NavText navText;

	interface TooltipsUiBinder extends UiBinder<Widget, Tooltips> {
	}

	private static TooltipsUiBinder ourUiBinder = GWT.create(TooltipsUiBinder.class);

	public Tooltips() {
		initWidget(ourUiBinder.createAndBindUi(this));
		
		setupTooltip(fooNavlink, "say foo!");
		setupTooltip(barNavlink, "say bar!");
		setupTooltip(divider, "It's a divider");
		setupTooltip(navText, "You can use this after login.");

	}
	
	private void setupTooltip(Widget w, String message) {
		Tooltip tooltip = new Tooltip();
		
		tooltip.setWidget(w);
		
		tooltip.setText(message);
		
		tooltip.setPlacement(Placement.RIGHT);
		
		tooltip.reconfigure();
	}

	@UiHandler("button")
	public void onClickButton(ClickEvent e) {
		Tooltip.changeVisibility(e.getRelativeElement(), VisibilityChange.TOGGLE.get());
	}
}