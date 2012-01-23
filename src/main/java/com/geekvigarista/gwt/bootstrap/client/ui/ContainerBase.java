package com.geekvigarista.gwt.bootstrap.client.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * Container base for Fixed and fluid layouts.
 * 
 * @see FixedLayout
 * @see FluidLayout
 * @see SidebarPanel
 * @see ContentPanel
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class ContainerBase extends Widget implements HasWidgets {

	private List<Widget> childs;

	{
		setElement(Document.get().createDivElement());
		childs = new ArrayList<Widget>();
	}

	public void add(Widget w) {
		childs.add(w);
		getElement().appendChild(w.getElement());
	}

	public void clear() {
		for (int i = 0; i < getElement().getChildNodes().getLength(); i++) {
			getElement().removeChild(getElement().getChild(i));
		}
	}

	public Iterator<Widget> iterator() {
		return childs.iterator();
	}

	public boolean remove(Widget w) {
		assert w != null : "widget should not be null";
		Iterator<Widget> it = iterator();
		while (it.hasNext()) {
			Widget ww = it.next();
			if (ww.equals(w)) {
				getElement().removeChild(ww.getElement());
				return true;
			}
		}

		return false;
	}

}
