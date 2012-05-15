/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.constants.NavbarConstants;
import com.github.gwtbootstrap.client.ui.constants.NavbarPosition;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * Navbar with optional text, links and forms.
 * <p>
 * The Navbar can be fixed on the top or bottom of the site where it will stay
 * when the user scrolls the page. For proper rendering, a fixed Navbar cannot
 * be part of any container! It has to be attached directly to the 
 * {@link RootPanel}. 
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <g:FlowPanel>
 *     <b:Navbar>
 *         <b:Brand>Bootstrap</b:Brand>
 *         <b:Nav>
 *             <b:NavLink>Link 1</b:NavLink>
 *             <b:NavLink>Link 2</b:NavLink>
 *         </b:Nav>
 *         <b:NavForm size="1" />
 *         <b:Nav alignment="RIGHT">
 *             <b:NavLink>Link 3</b:NavLink>
 *         </b:Nav>
 *     </b:Navbar>
 *     <b:Container>
 *         [...]
 *     </b:Container>
 * </g:FlowPanel>
 * 
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.3.0
 * 
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 * @see ResponsiveNavbar
 */
//@formatter:on
public class Navbar extends DivWidget {

	protected static final int TOP_SPACE_IN_PIXEL = 50;

	private boolean fixedTop = false;

	private class NavbarInner extends DivWidget {

		public NavbarInner() {
			setStyleName(NavbarConstants.NAVBAR_INNER);
		}
	}

	private final Container container = getContainer();
	private final NavbarInner navbarInner = new NavbarInner();
	private Scrollspy spy;
	
	private Element spyElement;

	private boolean scrollspy;

	/**
	 * Creates an empty Navbar.
	 */
	public Navbar() {
		setStyleName(NavbarConstants.NAVBAR);
		navbarInner.add(container);
		super.add(navbarInner);
	}

	/**
	 * Defines the default container implementation. You can override this in a
	 * extended class if you want another implementation, like a
	 * {@link FluidContainer}.
	 */
	protected Container getContainer() {
		return new Container();
	}

	/**
	 * Defines whether the Navbar should contain a {@link Scrollspy}.
	 * 
	 * @param scrollspy
	 *            <code>true</code> to include a Scrollspy. Default:
	 *            <code>false</code>
	 */
	public void setScrollspy(boolean scrollspy) {
		this.scrollspy = scrollspy;
	}
	
	/**
	 * Defines scrollspy target element.
	 * @param spyElement target element
	 */
	public void setSpyElement(Element spyElement) {
		
		assert spyElement != null;
		
		this.spyElement = spyElement;
		if (spy == null)
			spy = new Scrollspy(this);
		
		spy.setSpyElement(spyElement);
		this.scrollspy = true;
	}
	
	@Override
	protected void onAttach() {
		super.onAttach();
		if (spy == null)
			spy = new Scrollspy(this);

		if (scrollspy) {
			spy.configure();
		}
		// TODO make a unconfigure feature.
	}
	
	/**
	 * Fix the Navbar at the top or bottom of the screen.
	 * <p>
	 * For this to work properly, the Navbar must not be a child of a
	 * {@link Container}.
	 * 
	 * @param position
	 *            the position of the Navbar
	 */
	public void setPosition(NavbarPosition position) {
		if (position == NavbarPosition.TOP)
			fixedTop = true;
		else
			fixedTop = false;

		for (NavbarPosition p : NavbarPosition.values())
			if (!p.get().isEmpty())
				removeStyleName(p.get());

		addStyle(position);
		setPaddingTop(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget child) {
		container.add(child);
	}

	/**
	 * Adds a widget to the Navbar element, <b>not</b> the container.
	 * 
	 * @param widget
	 *            widget to add
	 */
	protected void addWidget(Widget widget) {
		super.add(widget);
	}

	/**
	 * Activates or deactivates a top padding.
	 * <p>
	 * This method can be overridden. The default implementation sets a padding
	 * only when the Navbar is fixed to the top.
	 * 
	 * @param padding
	 */
	protected void setPaddingTop(boolean padding) {
		if (padding && fixedTop)
			setPaddingTop(TOP_SPACE_IN_PIXEL);
		else
			setPaddingTop(0);
	}

	private void setPaddingTop(int pixels) {
		BodyElement body = Document.get().getBody();
		body.getStyle().setPaddingTop(pixels, Unit.PX);
	}
	
}
