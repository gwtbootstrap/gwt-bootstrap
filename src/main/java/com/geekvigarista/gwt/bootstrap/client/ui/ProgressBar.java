package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.base.DivWidget;
import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;
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
                return BootstrapCssResources.progress_striped;
            }
        },
        ANIMATED {

            @Override
            public String get() {
                return BootstrapCssResources.progress_animated;
            }
        };
        public abstract String get();
    }
    
	private DivWidget bar = new DivWidget();
	
	public ProgressBar() {
		addStyleName(BootstrapCssResources.progress);
		bar.addStyleName(BootstrapCssResources.bar);
		add(bar);
	}
	
	public ProgressBar(Style style) {
		this();
		setStyle(style);
	}
	
	public void setStyle(Style style) {
		setStyleName(BootstrapCssResources.progress);
		addStyleName(style.get());
	}

	public void setStyle(String stylename) {
		setStyleName(BootstrapCssResources.progress);
		if (stylename.equalsIgnoreCase("striped"))
			addStyleName(BootstrapCssResources.progress_striped);
		else if (stylename.equalsIgnoreCase("animated"))
			addStyleName(BootstrapCssResources.progress_animated);
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
