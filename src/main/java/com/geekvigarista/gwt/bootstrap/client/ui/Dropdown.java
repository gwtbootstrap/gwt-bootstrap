package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 */
public class Dropdown extends ComplexWidget {

	static {

	}

	private UnorderedList ul;

	public @UiConstructor
	Dropdown() {
		super("li");
		addStyleName("dropdown");
	}
	
	public Dropdown(String text) {
		this();
		setText(text);
	}

	public void setText(String text) {
		Element anchor = Document.get().createAnchorElement();
		anchor.addClassName("dropdown-toggle");
		anchor.setAttribute("data-toggle", "dropdown");
		anchor.setInnerText(text);

		Element caret = Document.get().createElement("b");
		caret.addClassName("caret");
		anchor.appendChild(caret);

		Widget wanchor = new Widget();
		wanchor.getElement().appendChild(anchor);
		add(wanchor);

		ul = new UnorderedList();
		ul.setStyleName("dropdown-menu");

		configure(getElement());

	}

	@Override
	public void add(Widget w) {
		assert w instanceof ListItem : "you have to add only list itens";
		ul.add(w);
	}

	private native void configure(Element e) /*- {
												$wnd.jQuery(e).dropdown();
												}-*/;
}
