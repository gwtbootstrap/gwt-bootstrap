package com.github.gwtbootstrap.client.ui.resources.internal;

import com.github.gwtbootstrap.client.ui.resources.ResourceInjector;

public class IE67ResourceInjector extends LowVersionIEResourceInjector {

    @Override
    public void configure() {
        super.configure();
        ResourceInjector.injectResourceCssAsFile("font-awesome-ie7.css");
    }
}
