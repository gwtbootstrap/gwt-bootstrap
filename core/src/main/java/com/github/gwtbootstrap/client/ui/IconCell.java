package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.IconFlip;
import com.github.gwtbootstrap.client.ui.constants.IconRotate;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * A IconCell supporting icon type, icon size, light, mute, border, spin, alignment, rotate, flip and tooltip
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
	private boolean light;
	private boolean muted;
	private boolean border;
	private boolean spin;
	private Alignment alignment;
	private IconRotate iconRotate;
	private IconFlip iconFlip;
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
		light = false;
		muted = false;
		border = false;
		spin = false;
		alignment = Alignment.NONE;
		iconRotate = IconRotate.NONE;
		iconFlip = IconFlip.NONE;
	}
	
	@Override
	public void render(Context context, Void value, SafeHtmlBuilder sb) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<i")
				.append(tooltip == null ? "" : " title=\"" + tooltip + "\"")
				.append(" class=\"")
				.append(iconType.get())
				.append(" ").append(iconSize.get())
				.append(light ? " icon-light" : "")
				.append(muted ? " icon-muted" : "")
				.append(border ? " icon-border" : "")
				.append(spin ? " icon-spin" : "");
		
		if (alignment == Alignment.LEFT)
			builder.append(" pull-left");
		if (alignment == Alignment.RIGHT)
			builder.append(" pull-right");
		
		if (iconRotate == IconRotate.ROTATE_90)
			builder.append(" icon-rotate-90");
		if (iconRotate == IconRotate.ROTATE_180)
			builder.append(" icon-rotate-180");
		if (iconRotate == IconRotate.ROTATE_270)
			builder.append(" icon-rotate-270");
		
		if (iconFlip == IconFlip.HORIZONTAL)
			builder.append(" icon-flip-horizontal");
		if (iconFlip == IconFlip.VERTICAL)
			builder.append(" icon-flip-vertical");
		
		builder.append("\"></i>");
		
		sb.appendHtmlConstant(builder.toString());
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
	
	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean muted) {
		this.muted = muted;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public boolean isSpin() {
		return spin;
	}

	public void setSpin(boolean spin) {
		this.spin = spin;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public IconRotate getIconRotate() {
		return iconRotate;
	}

	public void setIconRotate(IconRotate iconRotate) {
		this.iconRotate = iconRotate;
	}

	public IconFlip getIconFlip() {
		return iconFlip;
	}

	public void setIconFlip(IconFlip iconFlip) {
		this.iconFlip = iconFlip;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

}
