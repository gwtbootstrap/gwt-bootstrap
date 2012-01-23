package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapElementHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Modal extends SimplePanel {
	private final BootstrapElementHelper el_helper;
	private Element header;
	private Element footer;
	private Element body;

	static {
		BootstrapConfigurator.injectJs(Resources.RESOURCES.modal());
	}

	{
		el_helper = new BootstrapElementHelper();

		setStyleName(BootstrapCssResources.modal);
		addStyleName(BootstrapCssResources.fade);

		header = Document.get().createDivElement();
		header.setClassName(BootstrapCssResources.modal_header);
		footer = Document.get().createDivElement();
		footer.setClassName(BootstrapCssResources.modal_footer);
		body = Document.get().createDivElement();
		body.setClassName(BootstrapCssResources.modal_body);

		setVisible(false);

		getElement().appendChild(header);
		getElement().appendChild(body);
		getElement().appendChild(footer);

	}

	public Modal() {
	}

	public void setHeader(Widget w) {
		header.appendChild(el_helper.createCloseLinkElement());
		Element h3 = Document.get().createElement("h3");
		h3.appendChild(w.getElement());
		header.appendChild(h3);
	}

	public void setFooter(Widget w) {
		footer.appendChild(w.getElement());
	}

	public void setBody(Widget w) {
		body.appendChild(w.getElement());
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		callModalScript(getElement());
	}

	public void show() {
		showModal(getElement());
	}

	public void toggle() {
		toggleModal(getElement());
	}

	public void hide() {
		hideModal(getElement());
	}

	private native void showModal(Element e) /*-{
		$wnd.jQuery(e).modal('show');
	}-*/;

	private native void toggleModal(Element e) /*-{
		$wnd.jQuery(e).modal('toggle');
	}-*/;

	private native void hideModal(Element e) /*-{
		$wnd.jQuery(e).modal('hide');
	}-*/;

	private native void callModalScript(Element e) /*-{
		$wnd.jQuery(e).modal({
			keyboard : true,
			backdrop : true
		});
	}-*/;

}
