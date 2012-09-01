/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * A ButtonCell with Bootstrap Style, supporting Icons and icon types.
 * 
 * @author Carlos A Becker
 * @since 2.0.4.0
 * 
 * @see Button
 * 
 */
public class ButtonCell extends com.google.gwt.cell.client.ButtonCell {

	private IconType icon = null;
	private ButtonType type = null;
	private ButtonSize size = null;

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
	
	public ButtonCell(ButtonSize size) {
		super();
		this.size = size;
	}

    public ButtonCell(IconType icon, ButtonType type) {
		super();
		this.icon = icon;
		this.type = type;
	}
    
    public ButtonCell(IconType icon, ButtonSize size) {
		super();
		this.icon = icon;
		this.size = size;
	}
    
    public ButtonCell(ButtonType type, ButtonSize size) {
		super();
		this.type = type;
		this.size = size;
	}
    
    public ButtonCell(IconType icon, ButtonType type, ButtonSize size) {
		super();
		this.icon = icon;
		this.type = type;
		this.size = size;
	}

	@Override
	public void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {
		sb.appendHtmlConstant("<button type=\"button\" class=\"btn "
				+ (type != null ? type.get() : "") + (size != null ? " " + size.get() : "") + "\" tabindex=\"-1\">");
		if (data != null) {
			if (icon != null) {
                sb.appendHtmlConstant("<i class=\"" + icon.get() + "\"></i> ");
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

	public ButtonSize getSize() {
		return size;
	}

	public void setSize(ButtonSize size) {
		this.size = size;
	}
	
    // TODO add icon size support
}
