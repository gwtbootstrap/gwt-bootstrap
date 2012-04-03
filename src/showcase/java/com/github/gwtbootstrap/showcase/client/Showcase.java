/*
 *  Copyright 2012 GWT Bootstrap
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

import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Section;
import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Showcase extends Composite implements EntryPoint {

	public void onModuleLoad() {
	}

	@UiField
	FlowPanel sections;
	@UiField
	Nav nav;

	private static ShowcaseUiBinder uiBinder = GWT
			.create(ShowcaseUiBinder.class);

	interface ShowcaseUiBinder extends UiBinder<Widget, Showcase> {
	}

	public Showcase() {
		initWidget(uiBinder.createAndBindUi(this));
//        addSectionToContainer("Get Started", "setup", new Setup());
//		addSectionToContainer("Get Support", "support", new Support());
		addSectionToContainer("Buttons", "buttons", new Buttons());
		addSectionToContainer("Grid System", "gridSystem", new GridSystem());
        addSectionToContainer("NavEntries", "navEntries", new NavigationEntries());
        addSectionToContainer("NavPanels", "navPanels", new NavigationPanels());

		RootPanel.get("content").add(this);
		Document doc = Document.get();
		ScriptElement script = doc.createScriptElement();
		script.setSrc("https://apis.google.com/js/plusone.js");
		script.setType("text/javascript");
		script.setLang("javascript");
		doc.getBody().appendChild(script);
		
		JavaScriptInjector.inject("!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=\"//platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");");
		JavaScriptInjector.inject("(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));");
	}

	private void addSectionToContainer(String sectionName, String target,
			Widget section) {
		nav.add(new NavLink(sectionName, "#" + target));
		Section sec = new Section(target);
		sec.add(section);
		sections.add(sec);
	}
}
