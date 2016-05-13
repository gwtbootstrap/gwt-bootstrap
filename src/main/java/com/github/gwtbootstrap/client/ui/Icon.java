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

import com.github.gwtbootstrap.client.ui.base.HasAlignment;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.BaseIconType;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconFlip;
import com.github.gwtbootstrap.client.ui.constants.IconRotate;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off

/**
 * Widget with a black or white icon.
 * <p>
 * The icons are provided by <a href="http://glyphicons.com/">Glyphicons</a>
 * and <a href="http://fortawesome.github.com/Font-Awesome/">Font Awesome</a>.
 *
 * <p/>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Icon type="PLANE" />
 * }
 * </pre>
 * </p>
 *
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @author Sven Jacobs
 * @see IconStack
 * @see <a href="http://getbootstrap.com/2.3.2/base-css.html#icons">Bootstrap documentation</a>
 * @see <a href="http://fortawesome.github.com/Font-Awesome/">Font Awesome page</a>
 * @since 2.0.4.0
 */
//@formatter:on
public class Icon extends Widget implements HasAlignment {

    private BaseIconType type;

    /**
     * Creates a widget but doesn't set an icon yet.
     * <p/>
     * (This is probably not what you want to do most of the time.)
     */
    public Icon() {
        setElement(Document.get().createElement("i"));
    }

    /**
     * Creates a black icon of given type.
     *
     * @param type the icon type
     */
    @UiConstructor
    public Icon(IconType type) {
        this();
        setBaseType(type);
    }

    /**
     * Sets the icon type.
     *
     * @param type the icon type
     */
    public void setType(IconType type) {
        setBaseType(type);
    }

    /**
     * Sets the base icon type.
     *
     * @param type the icon type
     */
    public void setBaseType(BaseIconType type) {
        if(this.type != null) {
            StyleHelper.removeStyle(this, this.type);
        }
        this.type = type;
        StyleHelper.addStyle(this, type);
    }

    /**
     * Sets the icon size.
     *
     * @param size the icon size
     */
    public void setIconSize(IconSize size) {
        StyleHelper.changeStyle(this, size, IconSize.class);
    }
    
    /**
     * Sets the icon size.
     *
     * @param size the icon size
     */
    public void setSize(IconSize size) {
        setIconSize(size);
    }
    
    /**
     * Get the icon type
     * 
     * @return icon type, or null, if the Icon is no instance of {@link IconType}
     */
    public IconType getIconType() {
        if(type instanceof IconType) {
            return (IconType) type;
        }
        return null;
    }

    /**
     * Get the base icon type
     *
     * @return base icon type
     */
    public BaseIconType getBaseIconType() {
        return type;
    }

    /**
     * Sets the base icon type.
     *
     * @param type the base icon type
     */
    public void setIcon(IconType type) {
        setBaseType(type);
    }

    /**
     * Sets whether this icon is a "light" (white) icon.
     *
     * @param light White icon if true
     * @since 2.3.2.0
     */
    public void setLight(final boolean light) {
        classNameToggle(light, Constants.ICON_LIGHT);
    }

    /**
     * A muted icon is a grayed out icon.
     *
     * @param muted Is this icon muted (grayed out)?
     * @since 2.3.2.0
     */
    public void setMuted(final boolean muted) {
        classNameToggle(muted, Constants.ICON_MUTED);
    }

    /**
     * Does this icon have a border?
     *
     * @param border True if icon has a border
     * @since 2.3.2.0
     */
    public void setBorder(final boolean border) {
        classNameToggle(border, Constants.ICON_BORDER);
    }

    /**
     * Is the icon the base (bottom) icon of a {@link IconStack}?
     * Only relevant if icon is a child element of {@link IconStack}.
     *
     * @param stackBase Is this icon the base (bottom icon) of an icon stack?
     * @see IconStack
     * @since 2.3.2.0
     */
    public void setStackBase(final boolean stackBase) {
        classNameToggle(stackBase, Constants.ICON_STACK_BASE);
    }

    /**
     * If true icon will spin.
     * </p>
     * Note: Uses CSS3 animations which aren't supported in IE7 - IE9.
     *
     * @param spin true if icon should spin
     * @since 2.3.2.0
     */
    public void setSpin(final boolean spin) {
        classNameToggle(spin, Constants.ICON_SPIN);
    }

    /**
     * Pulls icon left or right.
     *
     * @param alignment Alignment of icon
     * @since 2.3.2.0
     */
    @Override
    public void setAlignment(final Alignment alignment) {
        getElement().removeClassName(Alignment.LEFT.get());
        getElement().removeClassName(Alignment.RIGHT.get());

        if (alignment == null || alignment == Alignment.NONE) {
            return;
        }

        getElement().addClassName(alignment.get());
    }

    /**
     * Sets rotation of icon.
     *
     * @param iconRotate Rotation of icon
     * @see com.github.gwtbootstrap.client.ui.constants.IconRotate
     * @since 2.3.2.0
     */
    public void setRotate(final IconRotate iconRotate) {
        getElement().removeClassName(IconRotate.ROTATE_90.get());
        getElement().removeClassName(IconRotate.ROTATE_180.get());
        getElement().removeClassName(IconRotate.ROTATE_270.get());

        if (iconRotate == null || iconRotate == IconRotate.NONE) {
            return;
        }

        getElement().addClassName(iconRotate.get());
    }

    /**
     * Sets (horizontal or vertical) flip of icon.
     *
     * @param iconFlip Flip of icon
     * @see com.github.gwtbootstrap.client.ui.constants.IconFlip
     * @since 2.3.2.0
     */
    public void setFlip(final IconFlip iconFlip) {
        getElement().removeClassName(IconFlip.HORIZONTAL.get());
        getElement().removeClassName(IconFlip.VERTICAL.get());

        if (iconFlip == null || iconFlip == IconFlip.NONE) {
            return;
        }

        getElement().addClassName(iconFlip.get());
    }

    private void classNameToggle(final boolean value,
                                 final String className) {
        if (value) {
            getElement().addClassName(className);
        } else {
            getElement().removeClassName(className);
        }
    }
}
