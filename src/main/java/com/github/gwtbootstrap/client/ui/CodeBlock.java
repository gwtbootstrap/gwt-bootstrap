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
	
	private boolean injected = false;
	
	public CodeBlock() {
		super("pre", "");
	}
	
	public CodeBlock(String html) {
		super("pre", html);
		setHTML(html);
	}
	
	public void setScrollable(boolean scrollable) {
		if (scrollable)
			addStyleName(Bootstrap.pre_scrollable);
		else
			removeStyleName(Bootstrap.pre_scrollable);
	}
	
	// TODO: http://code.google.com/p/google-code-prettify/
	//       Only inject when really needed
	public void setPrettify(boolean prettify) {
		if (prettify) {
			addStyleName(Bootstrap.prettyprint + " lang-html");
//			injectPrettify();
		} else {
			removeStyleName(Bootstrap.prettyprint);
		}
	}
	
	public void setLinenums(boolean linenums) {
		if (linenums) {
			addStyleName(Bootstrap.linenums);
//			injectPrettify();
		} else {
			removeStyleName(Bootstrap.linenums);
		}
	}

//	private void injectPrettify() {
//		if (!injected) {
//			StyleInjector.inject(Resources.RESOURCES.bootstrap_js().getText());
//			JavaScriptInjector.inject(Resources.RESOURCES.bootstrap_css().getText());
//			prettyPrint();
//		}
//	}
	
	private native void prettyPrint() /*-{
		$wnd.prettyPrint();
	}-*/;
	
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
