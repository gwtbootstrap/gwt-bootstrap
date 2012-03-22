package com.github.gwtbootstrap.client.old;

import com.github.gwtbootstrap.client.old.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.Span;
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
		setStyleName(Bootstrap.label);
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
				return Bootstrap.success;
			}
		},
		WARNING {
			@Override
			String get() {
				return Bootstrap.warning;
			}
		},
		IMPORTANT {
			@Override
			String get() {
				return Bootstrap.important;
			}
		},
		NOTICE {
			@Override
			String get() {
				return Bootstrap.notice;
			}
		};
		abstract String get();
	}
}
