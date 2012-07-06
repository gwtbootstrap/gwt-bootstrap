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

import com.github.gwtbootstrap.client.Bootstrap;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Section;
import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;
import com.github.gwtbootstrap.datepicker.client.ui.resources.DatepickerResourceInjector;
import com.github.gwtbootstrap.showcase.client.forms.Forms;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LinkElement;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class NonResShowcase extends Composite implements EntryPoint {

    public void onModuleLoad() {
        initWidget(uiBinder.createAndBindUi(this));
        // addSectionToContainer("Get Started", "setup", new Setup());
        // addSectionToContainer("Get Support", "support", new Support());
        addSectionToContainer("Buttons", "buttons", new Buttons());
        addSectionToContainer("Grid System", "gridSystem", new GridSystem());
        addSectionToContainer("Navigation", "navigation", new Navigation());
        addSectionToContainer("Hero Unit", "hero", new HeroUnit());
        addSectionToContainer("Forms", "forms", new Forms());
        addSectionToContainer("Page Header", "pageheader", new PageHeader());
        addSectionToContainer("Progress Bar", "progressbar", new ProgressBar());
        addSectionToContainer("Alerts", "alerts", new Alerts());
        addSectionToContainer("Pagination", "pagination", new Pagination());
        addSectionToContainer("Dropdown", "dropdown", new Dropdown());
        addSectionToContainer("Modal", "modal", new Modal());
        addSectionToContainer("Datepicker", "datepicker", new Datepicker());
        addSectionToContainer("Tooltip", "tooltip", new Tooltips());
        addSectionToContainer("Popover", "popover", new Popovers());
        addSectionToContainer("Icons", "icons", new Icons());

        RootPanel.get("content").add(this);
        Document doc = Document.get();
        ScriptElement script = doc.createScriptElement();
        script.setSrc("https://apis.google.com/js/plusone.js");
        script.setType("text/javascript");
        script.setLang("javascript");
        doc.getBody().appendChild(script);

        github_buttons
                .getElement()
                .setInnerHTML(
                        "<iframe src=\"http://markdotto.github.com/github-buttons/github-btn.html?user=gwtbootstrap&repo=gwt-bootstrap&type=watch&count=true\"\n"
                                + "                                allowtransparency=\"true\" frameborder=\"0\" scrolling=\"0\" width=\"110px\" height=\"20px\"></iframe>"
                                + "<br /><iframe src=\"http://markdotto.github.com/github-buttons/github-btn.html?user=gwtbootstrap&repo=gwt-bootstrap&type=fork&count=true\"\n"
                                + "  allowtransparency=\"true\" frameborder=\"0\" scrolling=\"0\" width=\"95px\" height=\"20px\"></iframe>");

        JavaScriptInjector
                .inject("!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=\"//platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");");
        JavaScriptInjector
                .inject("(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));");

        Scheduler.get().scheduleFinally(new ScheduledCommand() {

            @Override
            public void execute() {
                History.fireCurrentHistoryState();
            }
        });
    }

    @UiField
    FlowPanel sections;
    @UiField
    Nav nav;
    @UiField
    HTMLPanel github_buttons;

    private static ShowcaseUiBinder uiBinder = GWT
            .create(ShowcaseUiBinder.class);

    @UiTemplate("Showcase.ui.xml")
    interface ShowcaseUiBinder extends UiBinder<Widget, NonResShowcase> {
    }

    public NonResShowcase() {

        ResourceInjector.configureWithCssFile();
        DatepickerResourceInjector.configureWithCssFile();
    }

    private void addSectionToContainer(String sectionName, String target,
            Widget section) {
        nav.add(new NavLink(sectionName, "#" + target));
        Section sec = new Section(target);
        sec.add(section);
        sections.add(sec);
    }
}
