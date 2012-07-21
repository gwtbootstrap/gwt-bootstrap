package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.ClientFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;


public interface IShowcaseActivity extends Activity {

	public void setClientFactory(ClientFactory clientFactory);
	
	public void setPlace(Place place);
	
}
