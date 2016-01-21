package com.github.gwtbootstrap.client.ui.incubator;

/**
 * User: Halil Karakose
 * Date: 10/18/13
 * Time: 6:41 PM
 */
public class NameValuePairImpl implements NameValuePair {
    private final String name;
    private final String value;

    public NameValuePairImpl(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String value() {
        return value;
    }
}
