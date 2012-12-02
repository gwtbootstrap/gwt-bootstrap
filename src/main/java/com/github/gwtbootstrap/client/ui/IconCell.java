package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * 
 * <h3>Example</h3>
 * <p>
 * <pre>
 * {@code  
 * final IconCell iCell = new IconCell(IconType.INFO_SIGN, IconSize.LARGE);
 *
 * Column<OneObject, Void> iconColumn = new Column<OneObject, Void>(iCell) {
 * 	
 * 	public Void getValue(OneObject object) {
 *		if (object.getOneValue() > 0) {
 *			iCell.setIconType(IconType.PLUS_SIGN);
 *			iCell.setTooltip("High");
 *		}
 *		if (object.getOneValue() < 0) {
 *			iCell.setIconType(IconType.MINUS_SIGN);
 *			iCell.setTooltip("Low");
 *		}
 *		return null;
 *	}
 * };
 * }
 * </pre>
 * </p>
 */
public class IconCell extends AbstractCell<Void> {
	
	private IconType iconType;
	private IconSize iconSize;
	private String tooltip;
	
	/**
	 * Construct a new {@link IconCell} with the specified icon type
	 * 
	 * @param iconType
	 */
	public IconCell(IconType iconType) {
		this(iconType, IconSize.DEFAULT);
	}
	
	/**
	 * Construct a new {@link IconCell} with the specified icon type and icon size
	 * 
	 * @param iconType
	 * @param iconSize
	 */
	public IconCell(IconType iconType, IconSize iconSize) {
		this.iconType = iconType;
		this.iconSize = iconSize;
	}
	
	@Override
	public void render(Context context, Void value, SafeHtmlBuilder sb) {
		sb.appendHtmlConstant("<i" + (tooltip == null ? "" : " title=\"" + tooltip + "\"") + " class=\"" + iconType.get() + " " + iconSize.get() + "\"></i>");
	}
	
	public IconType getIconType() {
		return iconType;
	}

	public void setIconType(IconType iconType) {
		this.iconType = iconType;
	}

	public IconSize getIconSize() {
		return iconSize;
	}

	public void setIconSize(IconSize iconSize) {
		this.iconSize = iconSize;
	}
	
	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

}
