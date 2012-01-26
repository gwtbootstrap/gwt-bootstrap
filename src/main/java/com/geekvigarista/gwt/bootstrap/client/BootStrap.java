package com.geekvigarista.gwt.bootstrap.client;

import com.geekvigarista.gwt.bootstrap.client.ui.ActionPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.Alert;
import com.geekvigarista.gwt.bootstrap.client.ui.Button;
import com.geekvigarista.gwt.bootstrap.client.ui.ContentPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.DangerButton;
import com.geekvigarista.gwt.bootstrap.client.ui.DividerListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.DropdownListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.ErrorAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.FluidLayout;
import com.geekvigarista.gwt.bootstrap.client.ui.InfoAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.InfoButton;
import com.geekvigarista.gwt.bootstrap.client.ui.InlineLabel.InlineLabelType;
import com.geekvigarista.gwt.bootstrap.client.ui.Modal;
import com.geekvigarista.gwt.bootstrap.client.ui.NavListItem;
import com.geekvigarista.gwt.bootstrap.client.ui.PrimaryButton;
import com.geekvigarista.gwt.bootstrap.client.ui.SearchItem;
import com.geekvigarista.gwt.bootstrap.client.ui.SemanticTextBuilder;
import com.geekvigarista.gwt.bootstrap.client.ui.SidebarPanel;
import com.geekvigarista.gwt.bootstrap.client.ui.StrongLabel;
import com.geekvigarista.gwt.bootstrap.client.ui.SuccessAlert;
import com.geekvigarista.gwt.bootstrap.client.ui.SuccessButton;
import com.geekvigarista.gwt.bootstrap.client.ui.TextBox;
import com.geekvigarista.gwt.bootstrap.client.ui.Topbar;
import com.geekvigarista.gwt.bootstrap.client.ui.Twipsy;
import com.geekvigarista.gwt.bootstrap.client.ui.TypographyBase.TypographyType;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Size;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Span;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Type;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootStrap implements EntryPoint {
	public void onModuleLoad() {

		BootstrapConfigurator.configure();

		Topbar topbar = new Topbar("GWT-Bootstrap");
		topbar.addPrimaryNavItem(new NavListItem("Blog",
				"http://geekvigarista.com"));
		topbar.addPrimaryNavItem(new NavListItem("GitHub",
				"http://github.com/caarlos0/gwt-bootstrap"));
		topbar.addPrimaryNavItem(new NavListItem("twitter",
				"http://twitter.com/caarlos0"));

		DropdownListItem dli = new DropdownListItem("Dropdown");
		dli.addItem(new NavListItem("Hi,", "#"));
		dli.addItem(new DividerListItem());
		dli.addItem(new NavListItem("You", "#"));
		dli.addItem(new NavListItem("Can", "#"));
		dli.addItem(new NavListItem("Have", "#"));
		dli.addItem(new NavListItem("More", "#"));
		dli.addItem(new NavListItem("Options", "#"));
		dli.addItem(new NavListItem("Here", "#"));

		topbar.addSecondaryNavItem(dli);
		SearchItem si = new SearchItem("Searh for ANYTHING!!");
		si.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					Window.alert("oi");
				}
			}
		});
		topbar.addItem(si);

		RootPanel.get("menu").add(topbar);

		RootPanel.get("conteudo").add(new TextBox());
		RootPanel.get("conteudo").add(new PrimaryButton("oi"));

		final Alert a = new Alert("Clica no OIZAO pra fechar essa jossa!",
				Type.DANGER);
		a.setSize(Span._7);
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

		RootPanel.get("conteudo").add(a);
		RootPanel.get("conteudo").add(pb);

		RootPanel.get("conteudo").add(new Button("ola que tal"));
		RootPanel.get("conteudo").add(new InfoButton("ola que tal"));
		RootPanel.get("conteudo").add(new DangerButton("medo"));
//		RootPanel.get("conteudo").add(new SuccessButton("eeeba"));
		RootPanel.get("conteudo").add(new Alert("teste"));

		RootPanel.get("conteudo").add(new ErrorAlert("oi, ERROR alert."));

		RootPanel.get("conteudo").add(new InfoAlert("info: aaasldlas"));
		RootPanel.get("conteudo").add(new SuccessAlert("sucessfull"));

		RootPanel.get("conteudo").add(new Label("sdas"));
		RootPanel.get("conteudo").add(new StrongLabel("sou forte, lol"));

		modal.setBody(new SemanticTextBuilder(TypographyType.SPAN)
				.append("Oi, ", TypographyType.STRONG).append("tudo bem?")
				.append("PUTA QUE PARIU", TypographyType.H1)
				.appendInLast("sou um small", TypographyType.SMALL).asWidget());
		modal.setFooter(new PrimaryButton("Oi, posso fazer algo?"));
		modal.setFooter(new Label("Escolha:"));
		modal.setHeader(new Label("Oi, sou um modal muito legal :)"));

		RootPanel.get("conteudo").add(modal);

		RootPanel.get("conteudo").add(
				new com.geekvigarista.gwt.bootstrap.client.ui.InlineLabel(
						"warn", InlineLabelType.WARNING));

		ActionPanel ap = new ActionPanel();
		HorizontalPanel hp = new HorizontalPanel();

		hp.add(new DangerButton("Cuidado"));
		hp.add(new SuccessButton("Cuidado"));
		hp.add(new Twipsy("oi, sou um twipsy tittle",
				"http://geekvigarista.com", "Sou um twipsy!!"));

		ap.setWidget(hp);

		// RootPanel.get("conteudo").add(ap);

		FluidLayout fc = new FluidLayout();
		ContentPanel cp = new ContentPanel();
		SidebarPanel sp = new SidebarPanel();
		fc.add(cp);
		fc.add(sp);
		cp.add(ap);
		cp.add(new Twipsy("oi, sou um twipsy tittle",
				"http://geekvigarista.com", "Sou um twipsy!!"));
		cp.add(new Alert("teste"));

		VerticalPanel vp = new VerticalPanel();
		vp.add(new Button("ola que tal"));
		vp.add(new InfoButton("ola que tal"));
		vp.add(new DangerButton("medo"));
		vp.add(new SuccessButton("eeeba"));
		sp.add(vp);
		cp.add(new Alert("teste"));
		cp.add(new SemanticTextBuilder(TypographyType.H1).append("oi")
				.asWidget());

		RootPanel.get("conteudo").add(fc);
		RootPanel.get("conteudo").add(
				new Twipsy("oi, sou um twipsy tittle",
						"http://geekvigarista.com", "Sou um twipsy!!"));
		RootPanel.get("conteudo").add(
				new SemanticTextBuilder(TypographyType.CODE).append(
						"var oi = function(){alert('oi'); }; ").asWidget());
	}
}
