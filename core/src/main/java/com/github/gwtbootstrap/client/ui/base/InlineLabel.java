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
package com.github.gwtbootstrap.client.ui.base;

import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.user.client.ui.Label;

/**
 * {@link com.google.gwt.user.client.ui.InlineLabel InlineLabel} without the GWT
 * CSS Styles.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
public class InlineLabel extends com.google.gwt.user.client.ui.InlineLabel {

	/**
	 * Creates an empty widget.
	 */
	public InlineLabel() {
		super();
		setStyleName("");
	}

	/**
	 * Creates a widget with the specified text.
	 * 
	 * @param text
	 *            the new widget's text
	 */
	public InlineLabel(String text) {
		this();
		setText(text);
	}

	/**
	 * Creates a label with the specified text and direction.
	 * 
	 * @param text
	 *            the new label's text
	 * @param dir
	 *            the text's direction. Note: {@code Direction.DEFAULT} means
	 *            direction should be inherited from the widget's parent
	 *            element.
	 */
	public InlineLabel(String text,
		Direction dir) {
		this();
		setText(text, dir);
	}

	/**
	 * Creates a label with the specified text and a default direction
	 * estimator.
	 * 
	 * @param text
	 *            the new label's text
	 * @param directionEstimator
	 *            A DirectionEstimator object used for automatic direction
	 *            adjustment. For convenience,
	 *            {@link Label#DEFAULT_DIRECTION_ESTIMATOR} can be used.
	 */
	public InlineLabel(String text,
		DirectionEstimator directionEstimator) {
		this();
		setDirectionEstimator(directionEstimator);
		setText(text);
	}

	/**
	 * This constructor may be used by subclasses to explicitly use an existing
	 * element. This element must be either a &lt;div&gt; &lt;span&gt; element.
	 * 
	 * @param element
	 *            the element to be used
	 */
	protected InlineLabel(Element element) {
		// super(element) also asserts that element is either a &lt;div&gt; or
		// &lt;span&gt;.
		super(element);
	}
}
