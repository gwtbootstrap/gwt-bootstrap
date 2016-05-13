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
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.NavbarConstants;
import com.github.gwtbootstrap.client.ui.constants.NavbarPosition;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
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
 * <p/>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
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
 * <b>NOTE</b>: We assume that most people will use the {@linkplain ResponsiveNavbar}, so, we automatically
 * add a <code>padding-top: 50px</code> in <code>body</code>.If you don't want this, you have to put
 * a <code>padding-top: 0px;</code> manually in your document <code>body</code> tag.
 *
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 * @see <a href="http://getbootstrap.com/2.3.2/components.html#navbar">Bootstrap documentation</a>
 * @see ResponsiveNavbar
 * @since 2.0.4.0
 */
//@formatter:on
public class Navbar extends DivWidget {

	private class NavbarInner extends DivWidget {

		public NavbarInner() {
			setStyleName(NavbarConstants.NAVBAR_INNER);
		}
	}

	private final Container container = getContainer();

	private final NavbarInner navbarInner = new NavbarInner();

	private Scrollspy spy;

	private boolean scrollspy;

	/**
	 * Creates an empty Navbar.
	 */
	public Navbar() {
		setStyleName(NavbarConstants.NAVBAR);
		navbarInner.add(container);
		super.add(navbarInner);
		
		setId(Document.get().createUniqueId());
	}

	public void setId(String id) {
		getElement().setId(id);
	}
	
	public String getId() {
		return getElement().getId();
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
		if(scrollspy) {
		    spy = new Scrollspy(this);
		}
	}

	/**
	 * Defines scrollspy target element.
	 * 
	 * @param spyElement
	 *            target element
	 */
	public void setSpyElement(Element spyElement) {

		assert spyElement != null;

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
	 * <p/>
	 * For this to work properly, the Navbar must not be a child of a
	 * {@link Container}.
	 * 
	 * @param position
	 *            the position of the Navbar
	 */
	public void setPosition(NavbarPosition position) {
		for (NavbarPosition p : NavbarPosition.values()) {
			if (!p.get().isEmpty()) {
				removeStyleName(p.get());
			}
		}
		addStyle(position);
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
    public Scrollspy getSpy() {
        return spy;
    }
    
    /**
     * Set inverse style.
     * @param inverse true:set false:unset
     */
    public void setInverse(boolean inverse) {
        setStyleName(Constants.NAVBAR_INVERSE , inverse);
    }
}
