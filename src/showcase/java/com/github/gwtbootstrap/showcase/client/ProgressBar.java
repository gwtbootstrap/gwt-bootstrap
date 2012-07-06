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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProgressBar extends Composite {

    @UiField
    com.github.gwtbootstrap.client.ui.ProgressBar progress1;

    private static ProgressBarUiBinder uiBinder = GWT.create(ProgressBarUiBinder.class);

    interface ProgressBarUiBinder extends UiBinder<Widget, ProgressBar> {
    }

    public ProgressBar() {
        initWidget(uiBinder.createAndBindUi(this));
        progress1.getPercent();
    }

}
