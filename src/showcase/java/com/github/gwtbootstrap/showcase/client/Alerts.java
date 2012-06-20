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

import com.github.gwtbootstrap.client.ui.Alert;
import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Alerts extends Composite {

	@UiField
	Alert alert;

	@UiField
	AlertBlock alertBlock;

	private static AlertsUiBinder uiBinder = GWT.create(AlertsUiBinder.class);

	interface AlertsUiBinder extends UiBinder<Widget, Alerts> {
	}

	public Alerts() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("alertClose")
	public void onClickClose(ClickEvent e) {
		alert.close();
	}
	@UiHandler("alertBlockClose")
	public void onClickBlockClose(ClickEvent e) {
		alertBlock.close();
	}

}
