package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;

/**
 * Can prepend Buttons in a TextInput.
 * <br /><br />
 * 
 * <pre>
 * {@code
 * <b:PrependButton>
 * 		<b:Button text="Foo" />
 * 		<b:TextBox /> 
 * </b:PrependButton>
 * }
 * </pre>
 * 
 * @since 2.0.2.0
 * @author Carlos Alexandro Becker
 * @see http://twitter.github.com/bootstrap/base-css.html#forms
 */
public class PrependButton extends DivWidget {
	{
		setStyleName("input-prepend");
	}
}
