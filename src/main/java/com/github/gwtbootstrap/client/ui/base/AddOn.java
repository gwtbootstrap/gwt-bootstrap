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
package com.github.gwtbootstrap.client.ui.base;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.InputAddOn;
import com.github.gwtbootstrap.client.ui.constants.*;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Input add-on.
 * <p>
 * AddOn can set text or icon.
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <!-- text addon -->
 * <b:AddOn text="@"/>
 * 
 * <!-- text addon another usage -->
 * <b:AddOn>@</b:AddOn>
 * 
 * <!-- icon addon -->
 * <b:AddOn icon="STAR"/>
 * 
 * <!-- widget addon -->
 * <b:Addon><b:widget><b:CheckBox/></b:widget></b:AddOn>
 * }
 * </pre>
 * 
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 * @see InputAddOn
 * @see IconType
 * @see <a
 *      href="http://twitter.github.com/bootstrap/base-css.html#forms">Bootstrap
 *      Docs</a>
 */
public class AddOn extends ComplexWidget implements HasText, HasIcon {

    /** text */
    private String text;

    /** icon */
    private Icon icon = new Icon();

    /**
     * Creates an empty widget.
     */
    public AddOn() {
        super("span");
        setStyleName(Constants.ADD_ON);
    }

    /**
     * {@inheritDoc}
     */
    public String getText() {
        return getElement().getInnerText();
    }

    /**
     * {@inheritDoc}
     */
    public void setText(String text) {
        this.text = text;

        if (icon.isAttached()) {
            icon.removeFromParent();
        }
        getElement().setInnerText(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIcon(IconType type) {
        setBaseIcon(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBaseIcon(BaseIconType type) {
        if (text != null) {
            getElement().setInnerHTML("");
        }

        icon.setBaseType(type);

        if (!icon.isAttached()) {
            add(icon);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

    /**
     * Add widget. Its method is for uibinder syntax.
     * 
     * @param w
     *            added widget
     */
    @UiChild(tagname = "widget", limit = 1)
    public void addWidget(IsWidget w) {
        add(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCustomIconStyle(String customIconStyle) {
        icon.addStyleName(customIconStyle);
    }

    @Override
    @Deprecated
    public void setIconPosition(IconPosition position) {
        throw new UnsupportedOperationException("Addon does not support this methods");
    }

}
