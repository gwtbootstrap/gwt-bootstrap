package com.geekvigarista.gwt.bootstrap.client.old.inputs;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

public class DisabledTextBox extends TextBox {
	{
		addStyleName(BootstrapCssResources.disabled);
		getElement().setAttribute("disabled", "disabled");
	}
}
