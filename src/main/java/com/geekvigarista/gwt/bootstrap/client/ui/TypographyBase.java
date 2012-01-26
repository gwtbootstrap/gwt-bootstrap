package com.geekvigarista.gwt.bootstrap.client.ui;

import java.util.Iterator;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * Base of Typography widgets. Yeah man, semantics rock!
 * 
 * @author Carlos Alexandro Becker
 * @since 25/01/2012
 */
public class TypographyBase extends Widget implements HasWidgets {

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

	private static class CodeElementCreator {
		static {
			BootstrapConfigurator.injectCss(Resources.RESOURCES.prettify_css());
			BootstrapConfigurator.injectJs(Resources.RESOURCES.prettify_js());
		}

		static Element getElement() {
			Element e = Document.get().createElement(TypographyType.CODE.tag());
			e.setAttribute("class", "prettyprint");
			return e;
		}
	}

	WidgetCollection childs;

	public TypographyBase(TypographyType type) {
		if (type == TypographyType.CODE) {
			setElement(CodeElementCreator.getElement());
		} else {
			setElement(Document.get().createElement(type.tag()));
		}
		childs = new WidgetCollection(this);
	}

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
		configurePrettify();
	}

	public void add(Widget w) {
		// logical add
		childs.add(w);

		// physical add
		getElement().appendChild(w.getElement());
	}

	public void clear() {
		Iterator<Widget> it = iterator();
		while (it.hasNext()) {
			remove(it.next());
		}
	}

	public Iterator<Widget> iterator() {
		return childs.iterator();
	}

	public boolean remove(Widget w) {
		try {
			childs.remove(w);
			getElement().removeChild(w.getElement());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private native void configurePrettify() /*-{
		if (typeof $wnd.prettyPrint != "undefined") {
			$wnd.prettyPrint();
		}
	}-*/;

}