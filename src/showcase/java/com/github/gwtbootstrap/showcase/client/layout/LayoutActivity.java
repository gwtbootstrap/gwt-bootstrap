package com.github.gwtbootstrap.showcase.client.layout;

import com.github.gwtbootstrap.showcase.client.framework.AbstractShowcaseActivity;
import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class LayoutActivity extends AbstractShowcaseActivity {
	

	@AsyncProxy.ConcreteType(LayoutActivity.class)
	@AsyncProxy.AllowNonVoid
	public interface Proxy extends AsyncProxy<IShowcaseActivity> , IShowcaseActivity {};
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		LayoutView view = new LayoutView(clientFactory);
		
		panel.setWidget(view);
	}

}
