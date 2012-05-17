package com.github.gwtbootstrap.datepicker.client.ui.util;

import com.github.gwtbootstrap.datepicker.client.ui.resources.Resources;
import com.google.gwt.resources.client.TextResource;

/**
 * A utility class to get the User's Browser Locale.
 *
 * @author Carlos A Becker
 * @since 2.0.3.0
 */
public class LocaleUtil {

    private static String locale = null;
    private static String LANGUAGE = null;

    public static String getLanguage() {
        if (LANGUAGE == null) {
            setupLocale();
        }
        return LANGUAGE;
    }

    /**
     * Get the string of locale based on user's browser configuration.
     *
     * @return
     */
    public static String getLocale() {
        if (locale == null) {
            locale = getBrowserLocale();
        }
        return locale;
    }

    public static TextResource getLocaleJsResource() {
        String locale = getLocale();
        if (locale == null) {
            return null;
        }
        return setupLocale();
    }

    private static final native String getBrowserLocale() /*-{
        return $wnd.navigator.userLanguage || $wnd.navigator.language;
    }-*/;

    private static TextResource setupLocale() {
        Resources r = Resources.RESOURCES;
        TextResource tr = null;

        /*
           Script used to gen the basic if-else block:
           for a in `ls`; do echo "else if(locale.equals(\"`echo $a | cut -f2 -d.`\")) { tr = r.`echo $a | cut -f2 -d.`(); LANGUAGE = \"`echo $a | cut -f2 -d.`\"; }"; done
        */


        if (locale.equalsIgnoreCase("pt-br") || locale.contains("pt")) {
            tr = r.br();
            LANGUAGE = "br";
        } else if (locale.equals("da")) {
            tr = r.da();
            LANGUAGE = "da";
        } else if (locale.equals("de")) {
            tr = r.de();
            LANGUAGE = "de";
        } else if (locale.equals("es")) {
            tr = r.es();
            LANGUAGE = "es";
        } else if (locale.equals("fi")) {
            tr = r.fi();
            LANGUAGE = "fi";
        } else if (locale.equals("fr")) {
            tr = r.fr();
            LANGUAGE = "fr";
        } else if (locale.equals("is")) {
            tr = r.is();
            LANGUAGE = "is";
        } else if (locale.equals("it")) {
            tr = r.it();
            LANGUAGE = "it";
        } else if (locale.equals("lv")) {
            tr = r.lv();
            LANGUAGE = "lv";
        } else if (locale.equals("nb")) {
            tr = r.nb();
            LANGUAGE = "nb";
        } else if (locale.equals("nl")) {
            tr = r.nl();
            LANGUAGE = "nl";
        } else if (locale.equals("pl")) {
            tr = r.pl();
            LANGUAGE = "pl";
        } else if (locale.equals("ru")) {
            tr = r.ru();
            LANGUAGE = "ru";
        } else if (locale.equals("sv")) {
            tr = r.sv();
            LANGUAGE = "sv";
        } else if (locale.equals("th")) {
            tr = r.th();
            LANGUAGE = "th";
        } else if (locale.equals("tr")) {
            tr = r.tr();
            LANGUAGE = "tr";
        } else if (locale.equals("zh-CN")) {
            tr = r.zh_CN();
            LANGUAGE = "zh-CN";
        } else {
            tr = null;
            LANGUAGE = "en";
        }
        return tr;
    }

}
