/*
 *  Copyright 2012 GWT Bootstrap
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
import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

/**
 * A {@link Navbar} that hides the contents of a {@link NavCollapse} whenever
 * the width of the window is too small.
 * <p>
 * Only works when the Responsive Layout ist turned on. Create your own
 * {@link Configurator} and let {@link Configurator#hasResponsiveDesign()}
 * return true.
 * 
 * @since 2.0.2.0
 * 
 * @author Dominik Mayer
 * @author Carlos Alexandro Becker
 */
public class ResponsiveNavbar extends Navbar {

	private static final int RESPONSIVE_WIDTH_IN_PIXEL = 980;

	private final NavbarButton collapseButton = new NavbarButton();
	private final DivWidget navCollapse = new DivWidget("nav-collapse");

	public ResponsiveNavbar() {
		super();
		collapseButton.getElement().setAttribute(Constants.DATA_TOGGLE,
				Bootstrap.collapse);
		collapseButton.getElement().setAttribute(Bootstrap.data_target,
				Bootstrap.nav_collapse_target);
		collapseButton.add(new Icon(IconType.BAR));
		collapseButton.add(new Icon(IconType.BAR));
		collapseButton.add(new Icon(IconType.BAR));
		add(collapseButton);
		addWindowHandlers();
		setPaddingTop();

	}

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

	private void addWindowHandlers() {

		Window.addResizeHandler(new ResizeHandler() {

			Timer resizeTimer = new Timer() {

				@Override
				public void run() {
					setPaddingTop();
//					navCollapse.getElement().setAttribute("style",
//							"height: auto;");
				}
			};

			public void onResize(final ResizeEvent event) {
				resizeTimer.cancel();
				resizeTimer.schedule(250);
			}
		});
	}

	private void setPaddingTop() {
		setPaddingTop(!isResponsive());
	}

	private boolean isResponsive() {
		return Window.getClientWidth() < RESPONSIVE_WIDTH_IN_PIXEL;
	}

	@Override
	protected Container getContainer() {
		return new FluidContainer();
	}
}
