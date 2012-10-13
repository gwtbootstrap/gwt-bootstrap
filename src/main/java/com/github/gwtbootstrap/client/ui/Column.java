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

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.config.ColumnSizeConfigurator;
import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Column of the Bootstrap grid system.
 * <p>
 * It has to be added to a {@link Row} or a {@link FluidRow}.
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:Column size="3">
 *     <b:Well />
 * </b:Column>}
 * </pre>
 * Setting the <code>size</code> is mandatory.
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/scaffolding.html#gridSystem">Bootstrap documentation</a>
 * @see Configurator#hasResponsiveDesign()
 */
//@formatter:on
public class Column extends DivWidget implements HasSize {

    
    private static final ColumnSizeConfigurator CONFIGURATOR = GWT.create(ColumnSizeConfigurator.class);

	private static final String OFFSET_ERROR_MESSAGE =
			"The offset of the Column has to be between "
					+ CONFIGURATOR.getMinimumOffsetSize()+ " and "
					+ CONFIGURATOR.getMaximumOffsetSize() + "!";

	/**
	 * Creates a new Column of given size.
	 * 
	 * @param size
	 *            the size of the Column in the Bootstrap grid system
	 */
	@UiConstructor
	public Column(int size) {
		super();
		setSize(size);
	}

	/**
	 * Creates a new Column of given size and with given offset.
	 * 
	 * @param size
	 *            the size of the Column in the Bootstrap grid system
	 * @param offset
	 *            the offset from the left side
	 */
	public Column(int size, int offset) {
		this(size);
		setOffset(offset);
	}

	/**
	 * Creates a new Column of given size, with given offset and widgets
	 * 
	 * @param size
	 *            the size of the Column in the Bootstrap grid system
	 * @param offset
	 *            the offset from the left side
	 * @param widgets
	 *            the widgets to be added to the Column
	 */
	public Column(int size, int offset, Widget... widgets) {
		this(size, offset);
		add(widgets);
	}

	/**
	 * Creates a new Column of given size and with given widgets.
	 * 
	 * @param size
	 *            the size of the Column in the Bootstrap grid system
	 * @param widgets
	 *            the widgets to be added to the Column
	 */
	public Column(int size, Widget... widgets) {
		this(size);
		add(widgets);
	}

	/**
	 * Sets the size of the Column in the Bootstrap grid system.
	 * 
	 * @param size
	 *            the size of the Column
	 */
	public void setSize(int size) {
		SizeHelper.setSize(this, size);
	}

	/**
	 * Sets the offset of the Column from the left side.
	 * 
	 * @param offset
	 *            the offset in the Bootstrap grid system
	 */
	public void setOffset(int offset) {
		if (offset < CONFIGURATOR.getMinimumOffsetSize())
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);

		if (offset > CONFIGURATOR.getMaximumOffsetSize())
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);

		addStyleName(Constants.OFFSET + offset);
	}

	/**
	 * Adds the provided widgets to the Column.
	 * 
	 * @param widgets
	 *            the widgets to be added
	 */
	public void add(Widget... widgets) {
		for (Widget widget : widgets) {
			add(widget);
		}
	}
}
