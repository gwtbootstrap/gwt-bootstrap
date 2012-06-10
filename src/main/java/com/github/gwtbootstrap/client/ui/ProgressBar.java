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
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Style.Unit;

//@formatter:off
/**
 * The progress bar.
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 */
//@formatter:on
public class ProgressBar extends DivWidget {

	public enum Style {

		DEFAULT {

			@Override
			public String get() {
				return "";
			}
		},
		STRIPED {

			@Override
			public String get() {
				return Bootstrap.progress_striped;
			}
		},
		ANIMATED {

			@Override
			public String get() {
				return Bootstrap.progress_animated;
			}
		};

		public abstract String get();
	}

	private DivWidget bar = new DivWidget();

	public ProgressBar() {
		addStyleName(Bootstrap.progress);
		bar.addStyleName(Bootstrap.bar);
		add(bar);
	}

	public ProgressBar(Style style) {
		this();
		setType(style);
	}

	public void setType(Style style) {
		setStyleName(Bootstrap.progress);
		addStyleName(style.get());
	}

	public void setPercent(int percent) {
		bar.getElement().getStyle().setWidth(percent, Unit.PCT);
	}

	public int getPercent() {
		String width = bar.getElement().getStyle().getWidth();
		if (width == null)
			return 0;
		else
			return Integer.valueOf(width.substring(0, width.indexOf("%")));
	}

}
