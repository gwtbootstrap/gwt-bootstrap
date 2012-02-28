/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geekvigarista.gwt.bootstrap.client.v2;

/**
 * Bootstrap Button Component.
 *
 * @author Carlos A Becker
 */
public class Button extends com.google.gwt.user.client.ui.Button {

    public enum OPTION {

        DEFAULT {

            @Override
            public String getStyle() {
                return "btn";
            }
        },
        LARGE {

            @Override
            public String getStyle() {
                return "btn-large";
            }
        },
        SMALL {

            @Override
            public String getStyle() {
                return "btn-small";
            }
        },
        PRIMARY {

            @Override
            public String getStyle() {
                return "btn-primary";
            }
        },
        INFO {

            @Override
            public String getStyle() {
                return "btn-info";
            }
        },
        DANGER {

            @Override
            public String getStyle() {
                return "btn-danger";
            }
        },
        SUCCESS {

            @Override
            public String getStyle() {
                return "btn-success";
            }
        };

        public abstract String getStyle();
    }

    {
        removeStyleName("gwt-Button");
        addStyleName(OPTION.DEFAULT.getStyle());
    }

    public Button(String text) {
        setText(text);
    }

    public Button(String text, OPTION[] options) {
        this(options);
        setText(text);
    }

    public Button(OPTION[] options) {
        for (OPTION option : options) {
            addStyleName(option.getStyle());
        }
    }

    public void addOption(OPTION option) {
        addStyleDependentName(option.getStyle());
    }

    public void removeOption(OPTION option) {
        if (getStyleName().contains(option.getStyle())) {
            removeStyleName(option.getStyle());
        }
    }
}
