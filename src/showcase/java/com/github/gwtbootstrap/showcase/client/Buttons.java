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

import java.util.Arrays;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.showcase.client.util.EnumRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Buttons extends Composite {

    @UiField
    Button effectiveButton;

    @UiField(provided = true)
    ValueListBox<IconType> icons = new ValueListBox<IconType>(new EnumRenderer<IconType>("Choose icon"));
    
    @UiField(provided=true)
    ValueListBox<IconSize> iconSize = new ValueListBox<IconSize>(new EnumRenderer<IconSize>("Choose icon size"));

    private static ButtonsUiBinder uiBinder = GWT.create(ButtonsUiBinder.class);

    interface ButtonsUiBinder extends UiBinder<Widget, Buttons> {
    }

    public Buttons() {
        
        icons.setValue(null);
        icons.setAcceptableValues(Arrays.asList(IconType.values()));
        
        iconSize.setValue(null);
        iconSize.setAcceptableValues(Arrays.asList(IconSize.values()));
        
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler({ "defaultType", "primary", "info", "success", "warning",
            "danger", "inverse","link" })
    void onClickTypeButton(ClickEvent e) {
        Button b = (Button) e.getSource();
        if (b.getType() != null) {
            effectiveButton.setType(b.getType());
        } else {
            effectiveButton.setType(ButtonType.DEFAULT);
        }

        effectiveButton.setText(b.getText());
    }

    @UiHandler({ "large", "small", "mini" })
    void onClickSizeButton(ClickEvent e) {
        Button b = (Button) e.getSource();
        effectiveButton.setSize(b.getSize());
    }

    @UiHandler("enableButton")
    void onClickEnabled(ClickEvent e) {
        effectiveButton.setEnabled(true);
    }

    @UiHandler("disableButton")
    void onClickDisabled(ClickEvent e) {
        effectiveButton.setEnabled(false);
    }
    
    @UiHandler("icons")
    void onChangeIcons(ValueChangeEvent<IconType> e) {
        effectiveButton.setIcon(e.getValue());
    }
    
    @UiHandler("iconSize")
    void onChangeIconSize(ValueChangeEvent<IconSize> e) {
        effectiveButton.setIconSize(e.getValue());
    }
    
    @UiHandler("toggle")
    void onChangeToggle(ValueChangeEvent<Boolean> e) {
        effectiveButton.setToggle(e.getValue());
    }
    
    @UiHandler("block")
    void onChangeBlock(ValueChangeEvent<Boolean> e) {
        effectiveButton.setBlock(e.getValue());
    }
    
    @UiHandler("loadingText")
    void onChangeLoadingText(ValueChangeEvent<String> e) {
        effectiveButton.setLoadingText(e.getValue());
    }

    @UiHandler("completeText")
    void onChangeCompleteText(ValueChangeEvent<String> e) {
        effectiveButton.setCompleteText(e.getValue());
        GWT.log(e.getValue());
    }
    
    @UiHandler("loading")
    void onClickLoading(ClickEvent e) {
        effectiveButton.state().loading();
    }

    @UiHandler("complete")
    void onClickComplete(ClickEvent e) {
        effectiveButton.state().complete();
    }

    @UiHandler("reset")
    void onClickReset(ClickEvent e) {
        effectiveButton.state().reset();
    }

}
