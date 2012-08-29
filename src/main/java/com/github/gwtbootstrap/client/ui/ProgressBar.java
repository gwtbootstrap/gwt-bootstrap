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

import com.github.gwtbootstrap.client.ui.base.ProgressBarBase;
import com.github.gwtbootstrap.client.ui.constants.Constants;

//@formatter:off
/**
 * The progress bar.
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 */
//@formatter:on
public class ProgressBar extends ProgressBarBase {
    
	private Bar bar = new Bar();

	/**
	 * Create a progressbar.
	 */
	public ProgressBar() {
	    setStylePrimaryName(Constants.PROGRESS);
		addStyleName(Constants.PROGRESS);
		setColor(Color.DEFAULT);
		add(bar);
	}

	/**
	 * Create a progressbar with type
	 * @param style ProgressBar type
	 */
	public ProgressBar(Style style) {
		this();
		setType(style);
	}

    /**
     * Set bar width as a percent unit
     * @param percent percent
     */
	public void setPercent(int percent) {
		bar.setPercent(percent);
	}

    /**
     * Get bar width as a percent unit
     * @return percent
     */
	public int getPercent() {
	    return bar.getPercent();
	}
	
	/**
	 * Clear bar.
	 */
	@Override
	public void clear() {
	    bar.clear();
	    bar.setPercent(0);
	}
	
	/**
	 * Set bar label text
	 * @param text bar label text
	 */
	public void setText(String text) {
	    bar.setText(text);
	}

}
