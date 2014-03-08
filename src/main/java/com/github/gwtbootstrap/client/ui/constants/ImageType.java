package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Style type for {@link com.github.gwtbootstrap.client.ui.Image}
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 */
public enum ImageType implements Style {
    ROUNDED("rounded"),
    CIRCLE("circle"),
    POLAROID("polaroid");

	private final String name;

	private ImageType(final String name) {
		this.name = name;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public String get() {
        return "img-" + name;
    }
}
