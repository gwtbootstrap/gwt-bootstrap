package com.geekvigarista.gwt.bootstrap.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

public class TypographyBase extends Widget {
	enum TypographyType {
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
		};

		abstract String tag();
	}

	public TypographyBase(String text, TypographyType type) {
		setElement(Document.get().createElement(type.tag()));
		setText(text);
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}

}
