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

import java.util.EnumMap;
import java.util.Map;

import com.github.gwtbootstrap.client.ui.Divider;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.github.gwtbootstrap.showcase.client.framework.AppActivityMapper;
import com.github.gwtbootstrap.showcase.client.framework.HasMenuPlace;
import com.github.gwtbootstrap.showcase.client.framework.Menus;
import com.github.gwtbootstrap.showcase.client.overview.OverviewPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Showcase extends Composite implements EntryPoint {
    @UiField
    FlowPanel sections;
    @UiField
    Nav nav;
    @UiField
    HTMLPanel github_buttons;
    
    @UiField
    SimplePanel main;
    
    @UiField(provided=true)
    Subnav subnav;

    private static ShowcaseUiBinder uiBinder = GWT
            .create(ShowcaseUiBinder.class);

    interface ShowcaseUiBinder extends UiBinder<Widget, Showcase> {
    }

    public Showcase() {
    }

    public void onModuleLoad() {
        ClientFactory factory = GWT.create(ClientFactory.class);
        
        subnav = factory.getSubnav();
        
        initWidget(uiBinder.createAndBindUi(this));


        ActivityMapper activityMapper = new AppActivityMapper(factory);
        
        ActivityManager activityManager = new ActivityManager(activityMapper, factory.getEventBus());
        
        activityManager.setDisplay(main);
        PlaceHistoryMapper mapper = factory.getPlaceHistoryMapper();
        final PlaceHistoryHandler handler = new PlaceHistoryHandler(mapper);
        handler.register(factory.getPlaceController(), factory.getEventBus(), new OverviewPlace(""));

        final Map<Menus , NavLink> map = new EnumMap<Menus, NavLink>(Menus.class);
        for (Menus menu : Menus.values()) {
            NavLink link = new NavLink(menu.getDisplay());
            link.setHref("#" + menu.getName() + ":");
            
            if(menu == Menus.GWT) {
                nav.add(new Divider());
            }
            nav.add(link);
            
            map.put(menu, link);
        }
        
        factory.getEventBus().addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
            
            @Override
            public void onPlaceChange(PlaceChangeEvent event) {
                Place place = event.getNewPlace();
                
                if (place instanceof HasMenuPlace) {
                    HasMenuPlace menuPlace = (HasMenuPlace) place;
                    
                    for (Map.Entry<Menus, NavLink> entry : map.entrySet()) {
                        if(entry.getKey().equals(menuPlace.getMenu())) {
                            entry.getValue().setActive(true);
                        } else {
                            entry.getValue().setActive(false);
                        }
                    }
                    
                }
            }
        });
        
        // addSectionToContainer("Get Started", "setup", new Setup());
        // addSectionToContainer("Get Support", "support", new Support());
        // addSectionToContainer("Buttons", "buttons", new Buttons());
        // addSectionToContainer("Grid System", "gridSystem", new GridSystem());
        // addSectionToContainer("Navigation", "navigation", new Navigation());
        // addSectionToContainer("Hero Unit", "hero", new HeroUnit());
        // addSectionToContainer("Forms", "forms", new Forms());
        // addSectionToContainer("Page Header", "pageheader", new PageHeader());
        // addSectionToContainer("Progress Bar", "progressbar", new
        // ProgressBar());
        // addSectionToContainer("Alerts", "alerts", new Alerts());
        // addSectionToContainer("Pagination", "pagination", new Pagination());
        // addSectionToContainer("Dropdown", "dropdown", new Dropdown());
        // addSectionToContainer("Modal", "modal", new Modal());
        // addSectionToContainer("Datepicker", "datepicker", new Datepicker());
        // addSectionToContainer("Tooltip", "tooltip", new Tooltips());
        // addSectionToContainer("Popover", "popover", new Popovers());
        // addSectionToContainer("Icons", "icons", new Icons());

        RootPanel.get("content").add(this);
        Document doc = Document.get();
        ScriptElement script = doc.createScriptElement();
        script.setSrc("https://apis.google.com/js/plusone.js");
        script.setType("text/javascript");
        script.setLang("javascript");
        doc.getBody().appendChild(script);

//        github_buttons
//                .getElement()
//                .setInnerHTML(
//                        "<iframe src=\"http://ghbtns.com/github-btn.html?user=gwtbootstrap&repo=gwt-bootstrap&type=watch&count=true\"\n"
//                                + "                                allowtransparency=\"true\" frameborder=\"0\" scrolling=\"0\" width=\"110px\" height=\"20px\"></iframe>"
//                                + "<br /><iframe src=\"http://ghbtns.com/github-btn.html?user=gwtbootstrap&repo=gwt-bootstrap&type=fork&count=true\"\n"
//                                + "  allowtransparency=\"true\" frameborder=\"0\" scrolling=\"0\" width=\"95px\" height=\"20px\"></iframe>");

        JavaScriptInjector
                .inject("!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=\"//platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");");
        JavaScriptInjector
                .inject("(function(d, s, id) {var js, fjs = d.getElementsByTagName(s)[0];if (d.getElementById(id)) return;js = d.createElement(s); js.id = id;js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";fjs.parentNode.insertBefore(js, fjs);}(document, 'script', 'facebook-jssdk'));");
        
        String token = History.getToken();
        if(!token.equals("")) {
            History.newItem("");
            History.newItem(token);
        }
    }

//    private void addSectionToContainer(String sectionName, String target,
//            Widget section) {
//        nav.add(new NavLink(sectionName, "#" + target));
//        Section sec = new Section(target);
//        sec.add(section);
//        sections.add(sec);
//    }
    
    @UiHandler("backToTopAnchor")
    void onClickBackToTop(ClickEvent e) {
        Document.get().setScrollTop(0);
    }
}
