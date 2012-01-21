package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.ui.Button;
import com.geekvigarista.gwt.bootstrap.client.ui.DangerButton;
import com.geekvigarista.gwt.bootstrap.client.ui.InfoButton;
import com.geekvigarista.gwt.bootstrap.client.ui.PrimaryButton;
import com.geekvigarista.gwt.bootstrap.client.ui.SuccessButton;
import com.geekvigarista.gwt.bootstrap.client.ui.TextBox;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Size;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrap implements EntryPoint {
	public void onModuleLoad() {
		BootstrapConfigurator.configure();

		RootPanel.get().add(new TextBox());
		RootPanel.get().add(new PrimaryButton("oi"));

		PrimaryButton pb = new PrimaryButton("OIZAO");
		pb.setSize(Size.LARGE);
		RootPanel.get().add(pb);

		RootPanel.get().add(new Button("ola que tal"));
		RootPanel.get().add(new InfoButton("ola que tal"));
		RootPanel.get().add(new DangerButton("medo"));
		RootPanel.get().add(new SuccessButton("eeeba"));
	}
}
