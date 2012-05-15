package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconColor;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * A ButtonCell with Bootstrap Style, supporting Icons and icon types.
 * 
 * @author Carlos A Becker
 * @since 2.0.3.0
 * 
 * @see Button
 * 
 */
public class ButtonCell extends com.google.gwt.cell.client.ButtonCell {

	private IconType icon = null;
	private ButtonType type = null;
    private String color = null;

	public ButtonCell() {
	}

	public ButtonCell(ButtonType type) {
		super();
		this.type = type;
	}

	public ButtonCell(IconType icon) {
		super();
		this.icon = icon;
	}

    public ButtonCell(String color) {
        this.color = color;
    }

    public ButtonCell(ButtonType type, String color) {
        this.type = type;
        this.color = color;
    }

    public ButtonCell(IconType icon, String color) {
        this.icon = icon;
        this.color = color;
    }

    public ButtonCell(IconType icon, ButtonType type) {
		super();
		this.icon = icon;
		this.type = type;
	}

	@Override
	public void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {
		sb.appendHtmlConstant("<button type=\"button\" class=\"btn "
				+ (type != null ? type.get() : "") + "\" tabindex=\"-1\">");
		if (data != null) {
			if (icon != null) {
                if(color != null) {
                    try {
                        color = " " + IconColor.valueOf(color.toUpperCase()).get();
                    } catch (IllegalArgumentException e) {
                        color = "";
                    }
                } else {
                    color = "";
                }

                sb.appendHtmlConstant("<i class=\"" + icon.get() + color + "\"></i> ");
            }
			sb.append(data);
		}
		sb.appendHtmlConstant("</button>");
	}

    public IconType getIcon() {
        return icon;
    }

    public void setIcon(IconType icon) {
        this.icon = icon;
    }

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
