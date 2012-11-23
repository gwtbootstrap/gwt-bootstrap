package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;

/**
 * This interface allows the creation of own IconType-Enumerations
 * Default implementation: {@link IconType}
 *
 * @author Dominik Scholl (y9676)
 *         Date: 23.11.12
 *         Time: 13:01
 */
public interface IconBaseType extends Style {

    /**
     * Helper method for the {@link com.github.gwtbootstrap.client.ui.base.StyleHelper}
     *
     * @return all available Icon-styles of this IconCollection
     */
    IconBaseType[] availableIcons();
}
