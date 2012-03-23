package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.github.gwtbootstrap.client.ui.resources.prettify.HasLang;
import com.github.gwtbootstrap.client.ui.resources.prettify.PrettifyHelper;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A block of Code
 * 
 * @author Dominik Mayer
 */
public class CodeBlock extends HTMLPanel implements HasLang {

	private final PrettifyHelper helper;

	public CodeBlock() {
		super("pre", "");
		helper = new PrettifyHelper(this);
	}

	public CodeBlock(String html) {
		super("pre", html);
		helper = new PrettifyHelper(this);
		setHTML(html);
	}

	public void setScrollable(boolean scrollable) {
		if (scrollable)
			addStyleName(Bootstrap.pre_scrollable);
		else
			removeStyleName(Bootstrap.pre_scrollable);
	}

	public void setLinenums(boolean linenums) {
		if (linenums) {
			addStyleName(Bootstrap.linenums);
		} else {
			removeStyleName(Bootstrap.linenums);
		}
	}

	public String getHTML() {
		return getElement().getInnerHTML();
	}

	public void setHTML(String html) {
		String[] lines = html.split("\\\\n");
		SafeHtmlBuilder shb = new SafeHtmlBuilder();

		for (String s : lines) {
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

	public void setLang(String lang) {
		helper.setLang(lang);
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		helper.configure();
	}
}
