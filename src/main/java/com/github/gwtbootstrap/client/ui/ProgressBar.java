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
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
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
    
	public enum Style implements com.github.gwtbootstrap.client.ui.base.Style {

		DEFAULT(""),

		STRIPED(Bootstrap.progress_striped),
		
		ANIMATED(Bootstrap.progress_animated);		
		
		private final String styleName;

        private Style(String styleName) {
            this.styleName = styleName;
		    
		}

		public String get() {
		    return this.styleName;
		}
	}
	
	public enum Color implements com.github.gwtbootstrap.client.ui.base.Style {
        DEFAULT(""),
	    INFO("progress-info"),
        SUCCESS("progress-success"),
        DANGER("progress-danger"),
        WARNING("progress-warning")
        ;
        
        private final String styleName;

        private Color(String styleName) {
            this.styleName = styleName;
        }

        @Override
        public String get() {
            return this.styleName;
        }
	    
	}

	private DivWidget bar = new DivWidget();

	public ProgressBar() {
	    setStylePrimaryName(Bootstrap.progress);
		addStyleName(Bootstrap.progress);
		bar.addStyleName(Bootstrap.bar);
		setColor(Color.DEFAULT);
		add(bar);
	}

	public ProgressBar(Style style) {
		this();
		setType(style);
	}

	public void setType(Style style) {
	    StyleHelper.changeStyle(this, style, Style.class);
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
	
	public void setColor(Color color) {
	    StyleHelper.changeStyle(this, color, Color.class);
	}

}
