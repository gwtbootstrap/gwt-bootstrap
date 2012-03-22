package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A block of Code
 * 
 * @author Dominik Mayer
 */
public class CodeBlock extends HTMLPanel {
	
	public CodeBlock() {
		super("pre", "");
	}
	
	public CodeBlock(String html) {
		super("pre", html);
		setHTML(html);
	}
	
	public void setLinenums(boolean linenums) {
		if (linenums)
			addStyleName(Bootstrap.linenums);
		else
			removeStyleName(Bootstrap.linenums);
	}
	
	// TODO: http://code.google.com/p/google-code-prettify/
	//       Only inject when really needed
	public void setScrollable(boolean scrollable) {
		if (scrollable)
			addStyleName(Bootstrap.pre_scrollable);
		else
			removeStyleName(Bootstrap.pre_scrollable);
	}
	
	public void setPrettify(boolean prettify) {
		if (prettify)
			addStyleName(Bootstrap.prettyprint);
		else
			removeStyleName(Bootstrap.prettyprint);
	}
	
	public String getHTML() {
		return getElement().getInnerHTML();
	}

	public void setHTML(String html) {
		String[] lines = html.split("\\\\n");
		SafeHtmlBuilder shb = new SafeHtmlBuilder();
		
		for(String s : lines) {
			shb.appendEscaped(s);
			shb.appendHtmlConstant("<br/>");
		}
		
		getElement().setInnerHTML(shb.toSafeHtml().asString());
	}

	public String getText() {
		return getHTML();
	}

	public void setText(String text) {
		setHTML(text);
	}
}
