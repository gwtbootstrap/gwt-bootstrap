package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Carlos A Becker
 */
public class Dropdown extends ComplexWidget {

	private UnorderedList ul;
	private Element anchor;
	
	private NavLink link;

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
		anchor = Document.get().createAnchorElement();
		anchor.addClassName("dropdown-toggle");
		anchor.setAttribute("data-toggle", "dropdown");
		anchor.setInnerText(text);

		Element caret = Document.get().createElement("b");
		caret.addClassName("caret");
		anchor.appendChild(caret);

		getElement().appendChild(anchor);
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		if (anchor != null) {
			configure(anchor);
		}
	}

	@Override
	public void add(Widget w) {
		assert w instanceof NavLink : "You can only add NavLink items";
		if (ul == null) {
			ul = new UnorderedList();
			ul.setStyleName("dropdown-menu");
			super.add(ul);
		}
		ul.add(w);
	}

	private native void configure(Element e) /*-{
		$wnd.jQuery(e).dropdown();
	}-*/;
}
