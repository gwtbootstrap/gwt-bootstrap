package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.ui.ActionPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.Alert;
import com.geekvigarista.gwt.bootstrap.client.ui.Button;
import com.geekvigarista.gwt.bootstrap.client.ui.ErrorAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.DangerButton;
import com.geekvigarista.gwt.bootstrap.client.ui.InfoAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.InfoButton;
import com.geekvigarista.gwt.bootstrap.client.ui.Modal;
import com.geekvigarista.gwt.bootstrap.client.ui.PrimaryButton;
import com.geekvigarista.gwt.bootstrap.client.ui.StrongLabel;
import com.geekvigarista.gwt.bootstrap.client.ui.SuccessAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.SuccessButton;
import com.geekvigarista.gwt.bootstrap.client.ui.TextBox;
import com.geekvigarista.gwt.bootstrap.client.ui.InlineLabel.InlineLabelType;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Size;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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

		final Alert a = new Alert("Clica no OIZAO pra fechar essa jossa!",
				Type.DANGER);
		final Modal modal = new Modal();

		a.setHTMLText("<strong>oi cara,</strong>", "clica ae no ",
				"<strong>OIZAO</strong>", "e seja feliz.", "flw lesks");

		PrimaryButton pb = new PrimaryButton("OIZAO");
		pb.setSize(Size.LARGE);
		pb.addMouseUpHandler(new MouseUpHandler() {
			public void onMouseUp(MouseUpEvent event) {
				a.close();
				modal.toggle();
			}
		});

		RootPanel.get().add(a);
		RootPanel.get().add(pb);

		RootPanel.get().add(new Button("ola que tal"));
		RootPanel.get().add(new InfoButton("ola que tal"));
		RootPanel.get().add(new DangerButton("medo"));
		RootPanel.get().add(new SuccessButton("eeeba"));
		RootPanel.get().add(new Alert("teste"));

		RootPanel.get().add(new ErrorAlert("oi, ERROR alert."));

		RootPanel.get().add(new InfoAlert("info: aaasldlas"));
		RootPanel.get().add(new SuccessAlert("sucessfull"));

		RootPanel.get().add(new Label("sdas"));
		RootPanel.get().add(new StrongLabel("sou forte, lol"));

		modal.setBody(new StrongLabel("Corpo dessa bosta, lol"));
		modal.setFooter(new PrimaryButton("Oi, posso fazer algo?"));
		modal.setFooter(new Label("Escolha:"));
		modal.setHeader(new Label("Oi, sou um modal muito legal :)"));

		RootPanel.get().add(modal);
		
		RootPanel.get().add(new com.geekvigarista.gwt.bootstrap.client.ui.InlineLabel("CUIDADO", InlineLabelType.WARNING));
		
		ActionPanel ap = new ActionPanel();
		HorizontalPanel hp = new HorizontalPanel();
		
		hp.add(new DangerButton("Cuidado"));
		hp.add(new SuccessButton("Cuidado"));
		
		ap.setWidget(hp);
		
		RootPanel.get().add(ap);
	}
}
