package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapConfigurator;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapElementHelper;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Resources;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A ModalDialog element based on Modal Plugin from Twitter's bootstrap.
 * 
 * @author Carlos Alexandro Becker
 * @since 23/01/2012
 */
public class Modal extends SimplePanel {
	private final BootstrapElementHelper el_helper;
	private Element header;
	private Element footer;
	private Element body;

	static {
		// injecting the Modal plugin javascript file.
		BootstrapConfigurator.injectJs(Resources.RESOURCES.modal());
	}

	{
		// create the basics of element godness.
		el_helper = new BootstrapElementHelper();

		setStyleName(BootstrapCssResources.modal);
		addStyleName(BootstrapCssResources.fade);

		header = Document.get().createDivElement();
		header.setClassName(BootstrapCssResources.modal_header);
		footer = Document.get().createDivElement();
		footer.setClassName(BootstrapCssResources.modal_footer);
		body = Document.get().createDivElement();
		body.setClassName(BootstrapCssResources.modal_body);

		// assert that modal doesnt show up by default.
		setVisible(false);

		getElement().appendChild(header);
		getElement().appendChild(body);
		getElement().appendChild(footer);
	}

	public Modal() {
	}
	
	public void setHeader(Widget w) {
//		could do ulgy things when setting the header multiple times. FIXME
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
