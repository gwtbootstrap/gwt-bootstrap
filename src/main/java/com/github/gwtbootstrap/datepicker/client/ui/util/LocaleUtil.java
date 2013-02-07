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
package com.github.gwtbootstrap.datepicker.client.ui.util;

import java.util.ArrayList;
import java.util.List;

import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.github.gwtbootstrap.datepicker.client.ui.resources.Resources;
import com.google.gwt.resources.client.TextResource;

/**
 * A utility class to get the User's Browser Locale.
 *
 * @author Carlos A Becker
 * @since 2.0.4.0
 */
public class LocaleUtil {

    private static String locale = null;
    private static String LANGUAGE = null;

    private static List<String> loaded = new ArrayList<String>();
    
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


    public static final void forceLocale(String locale_) {
        locale = locale_;
        TextResource t = setupLocale();
        if (!loaded.contains(locale) && t != null) {
            JavaScriptInjector.inject(t.getText());
        }
    }

    private static TextResource setupLocale() {
        Resources r = Resources.RESOURCES;
        TextResource tr = null;

        /*
           Script used to gen the basic if-else block:
           for a in `ls`; do echo "else if(locale.equals(\"`echo $a | cut -f2 -d.`\")) { tr = r.`echo $a | cut -f2 -d.`(); LANGUAGE = \"`echo $a | cut -f2 -d.`\"; }"; done
        */

        String locale = getLocale();

        if (locale.equals("bg")){
            tr = r.bg();
            LANGUAGE = "bg";
        } else if (locale.equals("br")) {
            tr = r.br();
            LANGUAGE = "br";
        } else if (locale.equals("cs")) {
            tr = r.cs();
            LANGUAGE = "cs";
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
        } else if (locale.equals("id")) {
            tr = r.id();
            LANGUAGE = "id";
        } else if (locale.equals("is")) {
            tr = r.is();
            LANGUAGE = "is";
        } else if (locale.equals("it")) {
            tr = r.it();
            LANGUAGE = "it";
        } else if (locale.equals("ja")) {
            tr = r.ja();
            LANGUAGE = "ja";
        } else if (locale.equals("kr")) {
            tr = r.kr();
            LANGUAGE = "kr";
        } else if (locale.equals("lt")) {
            tr = r.lt();
            LANGUAGE = "lt";
        } else if (locale.equals("lv")) {
            tr = r.lv();
            LANGUAGE = "lv";
        } else if (locale.equals("ms")) {
            tr = r.ms();
            LANGUAGE = "ms";
        } else if (locale.equals("nb")) {
            tr = r.nb();
            LANGUAGE = "nb";
        } else if (locale.equals("nl")) {
            tr = r.nl();
            LANGUAGE = "nl";
        } else if (locale.equals("pl")) {
            tr = r.pl();
            LANGUAGE = "pl";
        } else if (locale.equals("pt-BR")) {
            tr = r.pt_BR();
            LANGUAGE = "pt-BR";
        } else if (locale.equals("pt")) {
            tr = r.pt();
            LANGUAGE = "pt";
        } else if (locale.equals("ru")) {
            tr = r.ru();
            LANGUAGE = "ru";
        } else if (locale.equals("sl")) {
            tr = r.sl();
            LANGUAGE = "sl";
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
            LANGUAGE = "zh-TW";
        } else if (locale.equals("zh-TW")) {
            tr = r.zh_TW();
            LANGUAGE = "zh-TW";
        } else {
            tr = null;
            LANGUAGE = "en";
        }

        loaded.add(LANGUAGE);

        return tr;
    }
}
