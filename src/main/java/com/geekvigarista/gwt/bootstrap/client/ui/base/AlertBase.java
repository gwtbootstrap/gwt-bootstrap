package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.geekvigarista.gwt.bootstrap.client.ui.Close;
import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
import com.google.gwt.user.client.ui.HasHTML;

/**
 * Base class for Alert widgets.
 * 
 * @author Dominik Mayer
 */
public abstract class AlertBase extends DivWidget implements HasHTML {
	
	public enum Style {

		DEFAULT {
			@Override
			String get() {
				return "";
			}
		},
		ERROR {
			@Override
			String get() {
				return BootstrapCssResources.alert_error;
			}
		},
		SUCCESS {
			@Override
			String get() {
				return BootstrapCssResources.alert_success;
			}
		},
		INFO {
			@Override
			String get() {
				return BootstrapCssResources.alert_info;
			}
		};
		abstract String get();
	}
	
	private Close close;
	
	private String html = "";
	
	private String heading = "";
	
	public AlertBase() {
		this(true);
	}
	
	public AlertBase(boolean hasClose) {
		setStyleName(BootstrapCssResources.alert);
		setClose(hasClose);
	}
	
	public AlertBase(Style style) {
		this();
		setStyle(style);
	}
	
	public void setStyle(Style style) {
		setStyleName(BootstrapCssResources.alert);
		addStyleName(style.get());
	}
	
	public void setStyle(String stylename) {
		setStyleName(BootstrapCssResources.alert);
		if (stylename.equalsIgnoreCase("error"))
			addStyleName(BootstrapCssResources.alert_error);
		else if (stylename.equalsIgnoreCase("success"))
			addStyleName(BootstrapCssResources.alert_success);
		else if (stylename.equalsIgnoreCase("info"))
			addStyleName(BootstrapCssResources.alert_info);
	}
	
	public void setClose(boolean hasClose) {
		if (hasClose) {
			close = new Close(Close.DataDismiss.ALERT);
			add(close);
		} else {
			clear();
			close = null;
		}
		redraw();
	}
	
	public void setHeading(String text) {
		heading = text;
		redraw();
	}
	
	@Override
	public void clear() {
		getElement().setInnerHTML("");
	}
	
	protected void redraw() {
		setHTML(html);
	}

	public String getText() {
		return getHTML(); // TODO
	}

	public void setText(String text) {
		setHTML(text); // TODO
	}

	public String getHTML() {
		return html;
	}

	public void setHTML(String html) {
		String output = "";
		if (close != null)
			output = close.toString();
		output = output + heading + html;
		setHTMLOutput(html, output);
	}
	
	protected void setHTMLOutput(String html, String output) {
		this.html = html;
		getElement().setInnerHTML(output);
	}
	
	protected void setHTML(String html, String heading) {
	}
}
