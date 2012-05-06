package com.github.gwtbootstrap.client.ui.constants;

import com.github.gwtbootstrap.client.ui.base.Style;


/**
 * input alternate size
 * @author ohashi keisuke
 */
public enum AlternateSize implements Style {
	MINI("input-mini"),
	SMALL("input-small"),
	MEDIUM("input-medium"),
	LARGE("input-large"),
	XLARGE("input-xlarge"),
	XXLARGE("input-xxlarge");

	private AlternateSize(String styleName) {
		this.styleName = styleName;
	}
	
	private final String styleName;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String get() {
		return styleName;
	}

}
