package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.user.client.ui.Widget;

/**
 * Just the modal footer, if you want a different style for it :)
 * 
 * @author Carlos A Becker
 *
 */
public class ModalFooter extends DivWidget {
	
	public ModalFooter() {
		super(Bootstrap.modal_footer);
	}
	
	public ModalFooter(Widget w) {
		this();
		add(w);
	}
}
