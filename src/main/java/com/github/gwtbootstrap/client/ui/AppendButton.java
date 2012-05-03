package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;

/**
 * Can append Buttons in a TextInput.
 * <br /><br />
 * 
 * <pre>
 * {@code
 * <b:AppendButton>
 * 		<b:TextBox /> 
 * 		<b:Button text="OK" />
 * 		<b:Button text="Cancel" />
 * </b:AppendButton>
 * }
 * </pre>
 * 
 * @since 2.0.3.0
 * @author Carlos Alexandro Becker
 * @see http://twitter.github.com/bootstrap/base-css.html#forms
 */
public class AppendButton extends DivWidget {
	{
		setStyleName("input-append");
	}
}
