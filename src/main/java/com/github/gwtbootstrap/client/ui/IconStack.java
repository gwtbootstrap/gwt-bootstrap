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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * An IconStack overlays multiple icons to "create" a new icon.
 * <p/>
 * <a href="http://fontawesome.io/">Font Awesome</a> offers some icons that can be used as a frame or background for
 * other icons, for instance {@code CIRCLE}, {@code CHECK_EMPTY} or {@code SIGN_BLANK}.
 *
 * <pre>
 * {@code
 *     <b:IconStack>
 *         <b:Icon type="CIRCLE" stackBase="true"/>
 *         <b:Icon type="FLAG" light="true"/>
 *     </b:IconStack>
 * }
 * </pre>
 * <p/>
 * See <a href="http://fontawesome.io/examples/#stacked">Font Awesome</a>.
 *
 * @author Sven Jacobs
 * @see Icon
 * @see Icon#setStackBase(boolean)
 * @see com.github.gwtbootstrap.client.ui.constants.IconType
 * @since 2.3.2.0
 */
public class IconStack extends ComplexPanel {

    public IconStack() {
        setElement(Document.get().createSpanElement());
        getElement().addClassName(Constants.ICON_STACK);
    }

    /**
     * Adds an icon to the stack.
     *
     * @param icon Icon to be added to the stack
     * @param stackBase Is this icon the base (bottom icon)?
     */
    public void add(final Icon icon, final boolean stackBase) {
        icon.setStackBase(stackBase);
        add(icon);
    }

    @Override
    public void add(final Widget child) {
        if (!(child instanceof Icon)) {
            throw new IllegalArgumentException("Only instances of Icon can be children of IconStack");
        }

        add(child, getElement());
    }
}
