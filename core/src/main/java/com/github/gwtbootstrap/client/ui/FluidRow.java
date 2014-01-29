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

import com.github.gwtbootstrap.client.ui.constants.Constants;

//@formatter:off
/**
 * Row that adapts its size to the parent widget.
 * 
 * <p>
 * Part of the Bootstrap Grid System. It extends {@link Row} so it can be used 
 * in any place that Row can be used in. In contrast to the fixed Row, a
 * FluidRow adapts its size to the parent widget. The {@link Column Columns} are
 * resized to fit that width.
 * </p>
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code 
 * <b:FluidContainer>
 *     <b:FluidRow>
 *         <b:Column size="4">...</b:Column>
 *         <b:Column size="8">...</b:Column>
 *     </b:FluidRow>
 * </b:FluidContainer>}
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see <a href="http://twitter.github.com/bootstrap/scaffolding.html#fluidGridSystem">Bootstrap documentation</a>
 * @see FluidContainer
 * @see Container
 */
//@formatter:on
public class FluidRow extends Row {

	/**
	 * Creates an empty FluidRow.
	 */
	public FluidRow() {
		this("");
	}

	/**
	 * Creates a FluidRow with given html.
	 * 
	 * @param html
	 *            the row's content
	 */
	public FluidRow(String html) {
		setStyleName(Constants.ROW_FLUID);
		getElement().setInnerHTML(html);
	}
}
