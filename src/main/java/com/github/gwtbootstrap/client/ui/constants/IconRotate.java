/*
 *  Copyright 2013 GWT-Bootstrap
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

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Rotation for {@link Icon}
 *
 * @author Sven Jacobs
 * @see Icon
 * @see Icon#setRotate(IconRotate)
 * @since 2.3.2.0
 */
public enum IconRotate implements Style {

    NONE(""),
    ROTATE_90("icon-rotate-90"),
    ROTATE_180("icon-rotate-180"),
    ROTATE_270("icon-rotate-270");

    private final String className;

    private IconRotate(final String className) {
        this.className = className;
    }

    @Override
    public String get() {
        return className;
    }
}
