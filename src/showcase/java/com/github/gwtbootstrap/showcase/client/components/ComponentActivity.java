package com.github.gwtbootstrap.showcase.client.components;

import com.github.gwtbootstrap.showcase.client.framework.AbstractShowcaseActivity;
import com.github.gwtbootstrap.showcase.client.framework.IShowcaseActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class ComponentActivity extends AbstractShowcaseActivity {

	@AsyncProxy.ConcreteType(ComponentActivity.class)
	@AsyncProxy.AllowNonVoid
	public interface Proxy extends AsyncProxy<IShowcaseActivity> , IShowcaseActivity {};
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		ComponentView view = new ComponentView(clientFactory);
		
		panel.setWidget(view);
	}

}
