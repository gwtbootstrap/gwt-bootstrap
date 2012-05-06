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

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;

/**
 * A integer-only TextBox, for Bootstrap form
 *
 * @author cassio
 */
public class IntegerBox extends TextBox {

    public IntegerBox() {
        addKeyDownHandler(new KeyDownHandler() {

            @Override
            public void onKeyDown(KeyDownEvent event) {
                char key = (char) event.getNativeKeyCode();
                if (!(key >= 37 && key <= 46 || key == 8 || key >= '0' && key <= '9'
                        || key >= 96 && key <= 105 || key == 9 || key == 13)) {
                    cancelKey();
                }
            }
        });
    }
}
