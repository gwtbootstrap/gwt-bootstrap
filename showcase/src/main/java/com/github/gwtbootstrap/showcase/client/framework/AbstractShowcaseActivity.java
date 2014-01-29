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
