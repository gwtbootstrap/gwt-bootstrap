package com.github.gwtbootstrap.client.ui.resources.internal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class LowVersionIEResourceInjector implements InternalResourceInjector {

    @Override
    public void configure() {
        ScriptInjector.fromUrl(GWT.getModuleBaseURL() + "/js/html5.js").inject();
    }

}
