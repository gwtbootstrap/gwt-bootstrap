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
import com.github.gwtbootstrap.client.ui.base.NavbarButton;
import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * A {@link Navbar} that hides the contents of a {@link NavCollapse} whenever
 * the width of the window is too small.
 * <p>
 * Only works when the Responsive Layout ist turned on. Create your own
 * {@link Configurator} and let {@link Configurator#hasResponsiveDesign()
 * hasResponsiveDesign()} return <code>true</code>.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <g:FlowPanel>
 *     <b:ResponsiveNavbar>
 *         <b:Brand>Bootstrap</b:Brand>
 *         <b:NavCollapse>
 *             <b:Nav>
 *                 <b:NavLink>Link 1</b:NavLink>
 *                 <b:NavLink>Link 2</b:NavLink>
 *             </b:Nav>
 *             <b:NavForm size="1" />
 *             <b:Nav alignment="RIGHT">
 *                 <b:NavLink>Link 3</b:NavLink>
 *             </b:Nav>
 *         </b:NavCollapse>
 *     </b:ResponsiveNavbar>
 *     <b:Container>
 *         [...]
 *     </b:Container>
 * </g:FlowPanel>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation</a>
 */
//@formatter:on
public class ResponsiveNavbar extends Navbar {

	private final NavbarButton collapseButton = new NavbarButton();
	private final DivWidget navCollapse = new DivWidget("nav-collapse");

	/**
	 * Creates an empty widget.
	 */
	public ResponsiveNavbar() {
		super();
		addCollapseButton();
	}

    private void addCollapseButton() {
		collapseButton.getElement().setAttribute(Constants.DATA_TOGGLE,
				Bootstrap.collapse);
		collapseButton.getElement().setAttribute(Bootstrap.data_target,
				Bootstrap.nav_collapse_target);
		collapseButton.add(new Icon(IconType.BAR));
		collapseButton.add(new Icon(IconType.BAR));
		collapseButton.add(new Icon(IconType.BAR));
		add(collapseButton);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget child) {
		if (child instanceof Nav) {
			// without this, the order of elements in navbar will bug.
			if (!getChildren().contains(navCollapse))
				super.add(navCollapse);
			navCollapse.add(child);
		} else
			super.add(child);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Container getContainer() {
		return new FluidContainer();
	}
}
