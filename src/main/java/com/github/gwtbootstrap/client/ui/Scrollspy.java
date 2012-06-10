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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

//@formatter:off
/**
 * {@linkplain Navbar} uses this class for the scrollspy.
 * 
 * @since 2.0.4.0
 * @author Carlos Alexandro Becker
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#scrollspy">Twitter Bootstrap ScrollSpy</a>
 */
//@formatter:on
public class Scrollspy {

	private Navbar navbar;
	
	/** spy target element */
	private Element spyElement;

	/** data-target */
	private String target;

	/** data-offset */
	private Integer offset;
	
	private boolean configured;

	/**
	 * 
	 * @param navbar
	 *            The navbar that will be spied.
	 */
	public Scrollspy(Navbar navbar) {
		super();
		this.navbar = navbar;
	}

	/**
	 * Get navbar
	 * @return nabvar.
	 */
	public Navbar getNavbar() {
		return navbar;
	}

	/**
	 * set navbar
	 * @param navbar
	 */
	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}
	
	/**
	 * set data-target.
	 * <p>
	 * If set this,{@link #spyElement} is set {@code data-target} attribute this {@code target} when {@link #configure()} is called.
	 * </p>
	 * @param target
	 * 				 data-target value.like this,{@code #some-id} {@code .some-classes}
	 * 
	 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#scrollspy">Twitter Bootstrap ScrollSpy Options</a>
	 */
	public void setTarget(String target) {
		this.target = target;
		
	}
	
	/**
	 * set spy target element.
	 * <p>
	 * If set this,Scrollspy set some setting to this argment 
	 * when {@link #configure()} is called.<br/>
	 * 
	 * If don't set this,Scrollspy set some setting to {@code body} tag.
	 * </p>
	 * 
	 * @param element
	 * 				 spy target element.
	 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#scrollspy">Twitter Bootstrap ScrollSpy Options</a>
	 */
	public void setSpyElement(Element element) {
		this.spyElement = element;
	}
	
	/**
	 * set data-offset.
	 * <p>
	 * If set this,{@link #spyElement} is set {@code data-offset} attribute this {@code target} when {@link #configure()} is called.
	 * </p>
	 * @param target
	 * 				 data-offset value.
	 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#scrollspy">Twitter Bootstrap ScrollSpy Options</a>
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * Configure the scrollspy in the configured navbar.
	 */
	public void configure() {
		
		Element spyTargetElement = getSpyElement();
		
		assert spyTargetElement != null : "houston, we need a spy element here!";
		
		spyTargetElement.setAttribute("data-spy", "scroll");
		
		if(offset != null) {
			spyTargetElement.setAttribute("data-offset", String.valueOf(offset));
		}
		
		if(target != null && target.length() > 0) {
			spyTargetElement.setAttribute("data-target", target);
		}
		
		jsConfigure(navbar.getElement());
		
		configured = true;
	}
	
	public boolean isConfigured() {
		return configured;
	}
	
	public Element getSpyElement() {
		return spyElement != null ? spyElement : Document.get().getBody();
	}
	
	private native void jsConfigure(Element e) /*-{
		$wnd.jQuery(e).scrollspy();
	}-*/;

}
