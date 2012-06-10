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
package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Size of {@link com.github.gwtbootstrap.client.ui.Icon}
 * @since 2.0.4.0
 * @author: Carlos A Becker
 */
public enum IconSize implements Style {

    LARGE("large"), SMALL("small"), DEFAULT("");

    private String style;


    private IconSize(String style) {
        this.style = style;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String get() {
        return "icon-" + style;
    }
}
