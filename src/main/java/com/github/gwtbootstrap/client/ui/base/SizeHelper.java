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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.gwtbootstrap.client.ui.config.ColumnSizeConfigurator;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.UIObject;

/**
 * THe helper for {@link HasSize} interface.
 * 
 * @since 2.0.4.0
 * @author ohashi keisuke
 * 
 */
public class SizeHelper {

	private static List<SizeSpan> SIZE_LIST;
	
	private static final ColumnSizeConfigurator CONFIGURATOR = GWT.create(ColumnSizeConfigurator.class);

	// create SIZE_LIST
	static {

		List<SizeSpan> list = new ArrayList<SizeSpan>();

		for (int i = CONFIGURATOR.getMinimumSpanSize(); i <= CONFIGURATOR.getMaximumSpanSize(); i++) {
			list.add(new SizeSpan(i));
		}

		SIZE_LIST = Collections.unmodifiableList(list);
	}

	/**
	 * change size style
	 * 
	 * @param widget
	 *            target widget
	 * @param size
	 *            size
	 */
	public static void setSize(UIObject widget, int size) {
		StyleHelper.changeStyle(widget,
								new SizeSpan(size),
								SIZE_LIST.toArray(new SizeSpan[SIZE_LIST.size()])
						);
	}

	private static class SizeSpan implements Style {

	    private static final ColumnSizeConfigurator CONFIGURATOR = GWT.create(ColumnSizeConfigurator.class);
		private static final String SIZE_ERROR_MESSAGE = "The size of the Column has to be between "
		                                                    + CONFIGURATOR.getMinimumSpanSize() + " and " + CONFIGURATOR.getMaximumSpanSize()+ "!";

		private final int size;

		private SizeSpan(int size) {

			if (size < CONFIGURATOR.getMinimumSpanSize())
				throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);

			if (size > CONFIGURATOR.getMaximumSpanSize())
				throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);

			this.size = size;
		}

		@Override
		public String get() {
			return Constants.SPAN + size;
		}

	}

}
