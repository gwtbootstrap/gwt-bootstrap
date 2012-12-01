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

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.NavList;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.showcase.client.resources.CustomResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author Dominik Scholl
 */
public class BaseIcons extends Composite {

    /**** UI Binder Stuff ****/
    interface IconsUiBinder extends UiBinder<HTMLPanel, BaseIcons> {}
    private static IconsUiBinder ourUiBinder = GWT.create(IconsUiBinder.class);

    @UiField
    HTMLPanel panel;

    @UiField
    CodeBlock javacode;

    @UiField
    CodeBlock csscode;


    /**** Icons' stuff ****/

    /**
     * The resources we use
     */
    public interface IconResources extends ClientBundle {

        /**
         * Get access to the css resource during gwt compilation
         */
        @CssResource.NotStrict
        @Source("resources/css/baseIcons.css")
        CssResource css();

        /**
         * Our sample image icon
         * Make the image resource for the gwt-compiler's css composer accessible
         */
        @Source("resources/logo.jpg")
        ImageResource logo();
    }

    /**
     * My custom base icon collection
     */
    private enum MyCustomIconType implements BaseIconType {

        logo;

        /**
         * Inject the icon's css once at first usage
         */
        static {
            IconResources icons = GWT.create(IconResources.class);
            icons.css().ensureInjected();
        }

        private static final String PREFIX = "myBaseIcon_";

        private String className;

        private MyCustomIconType() {
            this.className = this.name().toLowerCase();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String get() {
            return PREFIX + className;
        }
    }

    public BaseIcons() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);

        javacode.setLang("java");
        javacode.setText(CustomResources.RESOURCES.baseIconCode().getText());

        csscode.setLang("css");
        csscode.setText(CustomResources.RESOURCES.baseIconCss().getText());

        FlowPanel flow = new FlowPanel();
        flow.addStyleName("the-icons");

        for(BaseIconType icon : MyCustomIconType.values()) {
            Tooltip tip = new Tooltip( ((Enum)icon).name());

            IconAnchor anchor = new IconAnchor();
            anchor.setBaseIcon(icon);

            tip.add(anchor);
            tip.getWidget().getElement().getStyle().setMargin(3d, Style.Unit.PX);
            tip.getWidget().getElement().getStyle().setFloat(Style.Float.LEFT);

            flow.add(tip);
        }

        panel.add(flow);
    }
}