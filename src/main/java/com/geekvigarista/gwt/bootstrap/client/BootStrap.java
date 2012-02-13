package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.ui.buttons.Button;
import com.geekvigarista.gwt.bootstrap.client.ui.buttons.ButtonSize;
import com.geekvigarista.gwt.bootstrap.client.ui.buttons.DangerButton;
import com.geekvigarista.gwt.bootstrap.client.ui.buttons.PrimaryButton;
import com.geekvigarista.gwt.bootstrap.client.ui.buttons.SuccessButton;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.ResourceInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrap implements EntryPoint {
	public void onModuleLoad() {

		ResourceInjector.configure();
		
		HorizontalPanel vpbtns = new HorizontalPanel();
		PrimaryButton pb = new PrimaryButton(ButtonSize.LARGE);
		pb.setText("Primary big button");
		vpbtns.add(pb);
		vpbtns.add(new SuccessButton("Save this shit!"));
		vpbtns.add(new DangerButton("Ola, vou lhe causar perigos!"));
		vpbtns.add(new Button("Oi :|"));
		RootPanel.get().add(vpbtns);
	}
}
