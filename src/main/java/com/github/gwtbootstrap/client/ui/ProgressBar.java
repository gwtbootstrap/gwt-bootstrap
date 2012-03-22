package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.dom.client.Style.Unit;

/**
 * The progress bar.
 * 
 * @author Dominik Mayer
 */
public class ProgressBar extends DivWidget {

    public enum Style {

        DEFAULT {

            @Override
            public String get() {
                return "";
            }
        },
        STRIPED {

            @Override
            public String get() {
                return Bootstrap.progress_striped;
            }
        },
        ANIMATED {

            @Override
            public String get() {
                return Bootstrap.progress_animated;
            }
        };
        public abstract String get();
    }
    
	private DivWidget bar = new DivWidget();
	
	public ProgressBar() {
		addStyleName(Bootstrap.progress);
		bar.addStyleName(Bootstrap.bar);
		add(bar);
	}
	
	public ProgressBar(Style style) {
		this();
		setStyle(style);
	}
	
	public void setStyle(Style style) {
		setStyleName(Bootstrap.progress);
		addStyleName(style.get());
	}

	public void setStyle(String stylename) {
		setStyleName(Bootstrap.progress);
		if (stylename.equalsIgnoreCase("striped"))
			addStyleName(Bootstrap.progress_striped);
		else if (stylename.equalsIgnoreCase("animated"))
			addStyleName(Bootstrap.progress_animated);
	}
	
	public void setPercent(int percent) {
		bar.getElement().getStyle().setWidth(percent, Unit.PCT);
	}
	
	public int getPercent() {
		String width = bar.getElement().getStyle().getWidth();
		if (width == null)
			return 0;
		else
			return Integer.valueOf(width);
	}
	
}
