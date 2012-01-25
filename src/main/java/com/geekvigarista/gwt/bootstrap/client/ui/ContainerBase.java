package com.geekvigarista.gwt.bootstrap.client.ui;

import java.util.Iterator;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

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
public class ContainerBase extends ComplexPanel implements HasWidgets {
	private WidgetCollection childs;
	private Element div;

	public ContainerBase() {
		div = DOM.createDiv();
		setElement(div);
		childs = new WidgetCollection(this);
	}

	protected void onLoad() {
		super.onLoad();
	}

	@Override
	public void add(Widget w) {
		// logical add
		childs.add(w);
		
		// physical add
		getElement().appendChild(w.getElement());
	}

	public void clear() {
		Iterator<Widget> it = iterator();
		while(it.hasNext()) {
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

}
