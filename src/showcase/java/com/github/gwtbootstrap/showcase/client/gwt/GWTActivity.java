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
