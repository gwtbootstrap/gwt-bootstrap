package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.ComplexWidget;
import com.github.gwtbootstrap.client.ui.base.HasIcon;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.HasText;


/**
 * input add-on.
 * <p>
 * AddOn can set text or icon.
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <!-- text addon -->
 * <b:AddOn text="@"/>
 * 
 * <!-- text addon another usage -->
 * <b:AddOn>@</b:AddOn>
 * 
 * <!-- icon addon -->
 * <b:AddOn icon="STAR"/>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.0.3.0
 * 
 * @author ohashi keisuke
 * @see InputAddOn
 * @see IconType
 * @see http://twitter.github.com/bootstrap/base-css.html#forms
 */
public class AddOn extends ComplexWidget implements HasText, HasIcon {

	/** text */
	private String text;
	
	/** icon */
	private Icon icon = new Icon();

	/**
	 * Creates an empty widget.
	 */
	public AddOn() {
		super("span");
		setStyleName("add-on");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return getElement().getInnerText();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		this.text = text;

		if(icon.isAttached()) {
			icon.removeFromParent();
		}
		getElement().setInnerText(text);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setIcon(IconType iconType) {
		
		if(text != null) {
			getElement().setInnerHTML("");
		}

		icon.setType(iconType);
		
		if(!icon.isAttached()) {
			add(icon);
		}
	}

    @Override
    public void setIconSize(IconSize size) {
        icon.setIconsSize(size);
    }

}
