package com.geekvigarista.gwt.bootstrap.client.ui.base;

import com.geekvigarista.gwt.bootstrap.client.ui.Close;
import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.Bootstrap.Alert;
import com.google.gwt.user.client.ui.HasHTML;

/**
 * Base class for Alert widgets.
 * 
 * @author Dominik Mayer
 */
public abstract class AlertBase extends DivWidget implements HasHTML {
	
	private Close close;
	
	private String html = "";
	
	private String heading = "";
	
	public AlertBase() {
		this(true);
	}
	
	public AlertBase(boolean hasClose) {
		super.setStyle(Bootstrap.Alert.ALERT);
		setClose(hasClose);
	}
	
	public AlertBase(Alert style) {
		this();
		setStyle(style);
	}
	
	public void setStyle(Alert style) {
		super.setStyle(Bootstrap.Alert.ALERT);
		super.addStyle(style);
	}
	
	public void setStyle(String stylename) {
		if (stylename.equalsIgnoreCase("error"))
			setStyle(Bootstrap.Alert.ERROR);
		else if (stylename.equalsIgnoreCase("success"))
			setStyle(Bootstrap.Alert.SUCCESS);
		else if (stylename.equalsIgnoreCase("info"))
			setStyle(Bootstrap.Alert.INFO);
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
