package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Base of Typography widgets. Yeah man, semantics rock!
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class TypographyBase extends ComplexWidget implements HasWidgets {

	public enum TypographyType {
		H1 {
			@Override
			String tag() {
				return "h1";
			}
		},
		H2 {
			@Override
			String tag() {
				return "h2";
			}
		},
		H3 {
			@Override
			String tag() {
				return "h3";
			}
		},
		H4 {
			@Override
			String tag() {
				return "h4";
			}
		},
		H5 {
			@Override
			String tag() {
				return "h5";
			}
		},
		H6 {
			@Override
			String tag() {
				return "h6";
			}
		},
		SMALL {
			@Override
			String tag() {
				return "small";
			}
		},
		STRONG {
			@Override
			String tag() {
				return "strong";
			}
		},
		EM {
			@Override
			String tag() {
				return "em";
			}
		},
		ADDRESS {
			@Override
			String tag() {
				return "address";
			}
		},
		ABBR {
			@Override
			String tag() {
				return "abbr";
			}
		},
		B {
			@Override
			String tag() {
				return "b";
			}
		},
		I {
			@Override
			String tag() {
				return "i";
			}
		},
		P {
			@Override
			String tag() {
				return "p";
			}
		},
		BLOCKQUOTE {
			@Override
			String tag() {
				return "blockquote";
			}
		},
		SPAN {
			@Override
			String tag() {
				return "span";
			}
		},
		CODE {
			@Override
			String tag() {
				return "code";
			}
		},
		PRE {
			@Override
			String tag() {
				return "pre";
			}
		};

		abstract String tag();
	}

	private static class CodeElementAssitent {
		public static void injectResources() {
			if (isPrettifyInjected()) {
				BootstrapConfigurator.injectCss(Resources.RESOURCES
						.prettify_css());
				BootstrapConfigurator.injectJs(Resources.RESOURCES
						.prettify_js());
			}
		}

		public static native boolean isPrettifyInjected() /*-{
			return typeof $wnd.prettyPrint != "undefined";
		}-*/;

		public static native void configurePrettify() /*-{
			if (typeof $wnd.prettyPrint != "undefined") {
				$wnd.prettyPrint();
			}
		}-*/;
	}

	private TypographyType type;

	/**
	 * Create an empty Typography element based on type of it.
	 * 
	 * @param type
	 */
	public TypographyBase(TypographyType type) {
		super(type.tag());
		this.type = type;
		if (type == TypographyType.CODE) {
			addStyleName("prettyprint");
			CodeElementAssitent.injectResources();
		}
	}

	/**
	 * Create Typography element based on type of it and with the text.
	 * 
	 * @param text
	 * @param type
	 */
	public TypographyBase(String text, TypographyType type) {
		this(type);
		setText(text);
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}

	public String getText() {
		return getElement().getInnerText();
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		if (type == TypographyType.CODE) {
			CodeElementAssitent.configurePrettify();
		}
	}

}