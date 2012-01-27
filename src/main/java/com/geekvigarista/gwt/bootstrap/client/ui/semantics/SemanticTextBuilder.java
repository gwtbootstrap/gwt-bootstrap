package com.geekvigarista.gwt.bootstrap.client.ui.semantics;

import com.geekvigarista.gwt.bootstrap.client.ui.semantics.TypographyBase.TypographyType;
import com.google.gwt.user.client.ui.Widget;

/**
 * A semantic text builder. You can use it to write text that are semantic, with
 * elements like EM's, P's, ABBR's and etc. You can see all disponible types in
 * {@linkplain TypographyType}.
 * 
 * @author Carlos Alexandro Becker
 * @since 26/01/2012
 */
public class SemanticTextBuilder {

	private TypographyBase t;

	/**
	 * Create a new instance of semantictextBuilder.
	 * 
	 * @param type
	 *            will be the tag that will be around all the text, usually a
	 *            span or p.
	 */
	public SemanticTextBuilder(TypographyType type) {
		this.t = new TypographyBase(type);
	}

	/**
	 * Append a new text to the current primary defined tag.
	 * 
	 * @param text
	 * @param type
	 *            type of this text.
	 * @return
	 */
	public SemanticTextBuilder append(String text, TypographyType type) {
		t.add(new TypographyBase(text, type));
		return this;
	}

	/**
	 * Append a text in the current typography.
	 * 
	 * @param text
	 * @return
	 */
	public SemanticTextBuilder append(String text) {
		append(text, TypographyType.SPAN);
		return this;
	}

	/**
	 * Will append a text into the last added type, not in the primary added
	 * type.
	 * 
	 * @param text
	 * @param type
	 * @return
	 */
	public SemanticTextBuilder appendInLast(String text, TypographyType type) {
		t.getElement().getLastChild()
				.appendChild(new TypographyBase(text, type).getElement());
		return this;
	}

	/**
	 * Will append a text into the last added type, not in the primary added
	 * type.
	 * 
	 * @param text
	 * @return
	 */
	public SemanticTextBuilder appendInLast(String text) {
		append(text, TypographyType.SPAN);
		return this;
	}

	/**
	 * @return the generated widget.
	 */
	public Widget asWidget() {
		return t.asWidget();
	}

}
