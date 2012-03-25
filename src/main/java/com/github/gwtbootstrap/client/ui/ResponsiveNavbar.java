package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * A {@link Navbar} that hides the contents of a {@link NavCollapse} whenever
 * the width of the window is too small.
 * (Works only in combination with bootstrap-responsive.css.)
 * 
 * @author Dominik Mayer
 * @since 2012-03-25
 *
 */
public class ResponsiveNavbar extends Navbar {

	private static final int RESPONSIVE_WIDTH_IN_PIXEL = 980;
	
	private final NavbarButton collapseButton = new NavbarButton();
	
	public ResponsiveNavbar() {
		super();
		collapseButton.getElement().setAttribute(
				Bootstrap.data_toggle, Bootstrap.collapse);
		collapseButton.getElement().setAttribute(
				Bootstrap.data_target, Bootstrap.nav_collapse_target);
		collapseButton.add(new Icon("bar"));
		collapseButton.add(new Icon("bar"));
		collapseButton.add(new Icon("bar"));
		add(collapseButton);
		addWindowHandlers();
		setPaddingTop();
	}
	
	private void addWindowHandlers() {

		Window.addResizeHandler(new ResizeHandler() {

			Timer resizeTimer = new Timer() {  
				@Override
				public void run() {
					setPaddingTop();
				}
			};

			public void onResize(ResizeEvent event) {
				resizeTimer.cancel();
				resizeTimer.schedule(250);
			}
		});
	}
	
	private void setPaddingTop() {
		setPaddingTop(Window.getClientWidth() > RESPONSIVE_WIDTH_IN_PIXEL);
	}
	
	
//	@Override
//	protected void onLoad() {
//		super.onLoad();
//		configure(collapseButton.getElement());
//	}
//	
//	private native void configure(Element e) /*-{
//		$wnd.jQuery(e).collapse();
//	}-*/;
}
