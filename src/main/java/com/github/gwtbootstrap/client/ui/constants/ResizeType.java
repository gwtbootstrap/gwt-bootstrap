/*
 * Copyright (c) 2012, i-Free. All Rights Reserved.
 * Use is subject to license terms.
 */

package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * Resize type of {@link com.github.gwtbootstrap.client.ui.TextArea}
 *
 * @author Alexander Ostrovskiy (a.ostrovskiy)
 * @since 2.2.1.0
 */
public enum ResizeType implements Style {

    NONE("none"),
    BOTH("both"),
    HORIZONTAL("horizontal"),
    VERTICAL("vertical"),
    INHERIT("inherit");

    private String type;


    ResizeType(String type) {
        this.type = type;
    }


    @Override
    public String get() {
        return type;
    }
}
