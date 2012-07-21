package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.ClientFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;


public abstract class AbstractShowcaseActivity extends AbstractActivity implements IShowcaseActivity {

	protected ClientFactory clientFactory;
	protected Place place;

	@Override
	public void setClientFactory(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void setPlace(Place place) {
		this.place = place;

	}

}
