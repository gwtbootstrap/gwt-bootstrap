package com.geekvigarista.gwt.bootstrap.client.old.inputs;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;

public class DisabledTextBox extends TextBox {
	{
		addStyleName(Bootstrap.disabled);
		getElement().setAttribute("disabled", "disabled");
	}
}
