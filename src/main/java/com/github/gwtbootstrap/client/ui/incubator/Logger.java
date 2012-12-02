package com.github.gwtbootstrap.client.ui.incubator;

import com.google.gwt.core.client.JavaScriptObject;

public class Logger {
    
    public native static void log(JavaScriptObject jso)/*-{
        console.log(jso);
    }-*/;
    
    public native static void log(int i)/*-{
        console.log(i);
    }-*/;
    
    public native static void log(String i)/*-{
        console.log(i);
    }-*/;
    

}
