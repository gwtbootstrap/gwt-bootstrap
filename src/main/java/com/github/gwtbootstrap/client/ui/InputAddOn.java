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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.AddOn;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * append/prepend {@link AddOn} for input tags.
 * <p>
 * If you want to append/prepend add-on,<br/>
 * Set appendText/prependText or appendIcon/prependIcon attribute.
 * 
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <!-- append text -->
 * <b:InputAddOn appendText="@">
 *   <g:TextBox/>
 * </b:InputAddOn>
 * 
 * <!-- above setting is same as blow -->
 * <div class="input-append">
 *   <span class="add-on">@</span><input type="text">
 * </div>
 * 
 * 
 * <!-- prepend text-->
 * <b:InputAddOn prependText="@">
 *   <g:TextBox/>
 * </b:InputAddOn>
 * 
 * <!-- above setting is same as blow -->
 * <div class="input-prepend">
 *   <input type="text"><span class="add-on">@</span>
 * </div>
 * 
 * <!-- append icon and prepend text-->
 * <b:InputAddOn appendIcon="STAR" prependText="@">
 *   <g:TextBox/>
 * </b:InputAddOn>
 * 
 * <!-- above setting is same as blow -->
 * <div class="input-append input-prepend">
 *   <span class="add-on"><i class="icon-star"></i></span><input type="text"><span class="add-on">@</span>
 * </div>
 * }
 * </pre>
 * 
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 * @see AddOn
 * @see http://twitter.github.com/bootstrap/base-css.html#forms
 */
public class InputAddOn extends DivWidget {

    /** prepend add-on */
    private AddOn prependAddOn = new AddOn();

    /** append-add-on */
    private AddOn appendAddOn = new AddOn();

    /** set append add-on */
    private boolean append = false;

    /**
     * Creates an empty widget.
     */
    public InputAddOn() {
        super();
    }

    /**
     * set prepend text
     * 
     * @param prependText
     *            prepend text
     */
    public void setPrependText(String prependText) {
        setPrependStyle();

        prependAddOn.setText(prependText);
    }

    /**
     * set prepend icon
     * 
     * @param prependIcon
     *            IconType
     */
    public void setPrependIcon(IconType prependIcon) {
        setPrependStyle();

        prependAddOn.setIcon(prependIcon);
    }

    private void setPrependStyle() {
        this.setStyleName("input-prepend", true);
        if (!prependAddOn.isAttached()) {
            insert(prependAddOn, 0);
        }
    }

    /**
     * set append text
     * 
     * @param appendText
     *            append text
     */
    public void setAppendText(String appendText) {
        setAppendStyle();

        appendAddOn.setText(appendText);
    }

    /**
     * set append icon
     * 
     * @param appendIcon
     *            append icon
     */
    public void setAppendIcon(IconType appendIcon) {
        setAppendStyle();

        appendAddOn.setIcon(appendIcon);
    }

    private void setAppendStyle() {
        this.setStyleName("input-append", true);
        append = true;

        if (isAttached() && !appendAddOn.isAttached()) {
            add(appendAddOn);
        }

    }

    /**
     * Add prepend widget. its method is for uibinder syntax.
     * @param w Addred widget to prepend addon.
     */
    @UiChild(limit = 1, tagname = "prependWidget")
    public void addPrependWidget(IsWidget w) {
        setPrependStyle();
        prependAddOn.addWidget(w);
    }
    
    /**
     * Add append widget. its method is for uibinder syntax.
     * @param w Addred widget to append addon.
     */
    @UiChild(limit = 1, tagname = "appendWidget")
    public void addAppendWidget(IsWidget w) {
        setAppendStyle();
        appendAddOn.addWidget(w);
    }
    

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLoad() {

        // if setup append add-on and it is not attached,add as last child.
        if (append && !appendAddOn.isAttached()) {
            add(appendAddOn);
        }
        super.onLoad();
    }

}
