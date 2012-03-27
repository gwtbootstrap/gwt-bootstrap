package com.github.gwtbootstrap.client.ui;

import com.google.gwt.dom.client.Element;

/**
 * {@linkplain Navbar} uses this class for the scrollspy.
 * 
 * @author Carlos A Becker
 * 
 */
public class Scrollspy {

	private Navbar navbar;

	/**
	 * 
	 * @param navbar: The navbar that will be spied.
	 */
	public Scrollspy(Navbar navbar) {
		super();
		this.navbar = navbar;
	}

	public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}

	/**
	 * Configure the scrollspy in the configured navbar.
	 */
	public void configure() {
		// TODO make it works for other things too... not only for body scroll.
		Element body = com.google.gwt.dom.client.Document.get()
				.getElementsByTagName("body").getItem(0);
		assert body != null : "houston, we need a body here!";
		body.setAttribute("data-spy", "scroll");
		jsConfigure(navbar.getElement());
	}

	private native void jsConfigure(Element e) /*-{
		$wnd.jQuery(e).scrollspy();
	}-*/;

}
