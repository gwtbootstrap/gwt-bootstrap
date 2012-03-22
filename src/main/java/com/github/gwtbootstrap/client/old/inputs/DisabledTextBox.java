package com.github.gwtbootstrap.client.old.inputs;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;

public class DisabledTextBox extends TextBox {
	{
		addStyleName(Bootstrap.disabled);
		getElement().setAttribute("disabled", "disabled");
	}
}
