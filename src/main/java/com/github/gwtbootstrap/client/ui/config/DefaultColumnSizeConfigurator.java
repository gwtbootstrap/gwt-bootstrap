package com.github.gwtbootstrap.client.ui.config;

import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * Default column size configurator
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see ColumnSizeConfigurator
 */
public class DefaultColumnSizeConfigurator implements ColumnSizeConfigurator {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaximumSpanSize() {
        return Constants.MAXIMUM_SPAN_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumSpanSize() {
        return Constants.MINIMUM_SPAN_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaximumOffsetSize() {
        return getMaximumSpanSize() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumOffsetSize() {
        return getMinimumSpanSize() -1;
    }

}
