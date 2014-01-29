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
package com.github.gwtbootstrap.showcase.client.gwt;

import com.github.gwtbootstrap.showcase.client.CellTables;
import com.github.gwtbootstrap.showcase.client.framework.AbstractShowcaseActivity;
import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class GWTActivity extends AbstractShowcaseActivity {
	
	@AsyncProxy.ConcreteType(GWTActivity.class)
	@AsyncProxy.AllowNonVoid
	public interface Proxy extends AsyncProxy<IShowcaseActivity>,IShowcaseActivity{}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
	    //TODO should create GWTView()
		CellTables forms = new CellTables();
		
		panel.setWidget(forms);
	};

}
