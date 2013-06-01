package com.github.gwtbootstrap.datetimepicker.client.ui.base;

/**
 * @author Thomas Buckel (thomas@livewirelabs.com.au)
 */
public enum PickerPosition {

    TOP_LEFT("top-left"),
    TOP_RIGHT("top-right"),
    BOTTOM_LEFT("bottom-left"),
    BOTTOM_RIGHT("bottom-right");

    private final String value;

    private PickerPosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
