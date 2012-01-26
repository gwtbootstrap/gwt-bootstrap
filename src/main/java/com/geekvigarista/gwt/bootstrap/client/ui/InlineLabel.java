package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.SizeHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Span;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Inline Label Component. You could have multiple types :)
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class InlineLabel extends Widget {

	{
		setElement(DOM.createSpan());
		setStyleName(BootstrapCssResources.label);
	}

	public InlineLabel() {
	}

	public InlineLabel(String text) {
		setText(text);
	}

	public InlineLabel(String text, InlineLabelType type) {
		setText(text);
		setType(type);
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}

	public void setSize(Span spanSize) {
		SizeHelper.setSize(spanSize, this);
	}

	public void setType(InlineLabelType type) {
		assert type != null : "type should not be null";
		for (InlineLabelType t : InlineLabelType.values()) {
			if (t != InlineLabelType.DEFAULT) {
				removeStyleName(t.get());
			}
		}
		addStyleName(type.get());
	}

	/**
	 * Enum for the InlineLabel disponible types.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 23/01/2012
	 */
	public enum InlineLabelType {

		DEFAULT {
			@Override
			String get() {
				return "";
			}
		},
		SUCCESS {
			@Override
			String get() {
				return BootstrapCssResources.success;
			}
		},
		WARNING {
			@Override
			String get() {
				return BootstrapCssResources.warning;
			}
		},
		IMPORTANT {
			@Override
			String get() {
				return BootstrapCssResources.important;
			}
		},
		NOTICE {
			@Override
			String get() {
				return BootstrapCssResources.notice;
			}
		};
		abstract String get();
	}
}
