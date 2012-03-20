package com.geekvigarista.gwt.bootstrap.client.ui.inputs;

import com.geekvigarista.gwt.bootstrap.client.v2.resources.BootstrapCssResources;

public class DisabledTextBox extends TextBox {
	{
		addStyleName(BootstrapCssResources.disabled);
		getElement().setAttribute("disabled", "disabled");
	}
}
