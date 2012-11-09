package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Style type for {@link com.github.gwtbootstrap.client.ui.Image}
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 */
public enum ImageType implements Style {
    ROUNDED,CIRCLE,POLAROID;

    /**
     * {@inheritDoc}
     */
    @Override
    public String get() {
        return "img-" + this.name().toLowerCase();
    }
}
