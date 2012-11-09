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
package com.github.gwtbootstrap.datepicker.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Interface that provides the DateBox resources.
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.4.0
 */
public interface Resources extends ClientBundle {

    public static Resources RESOURCES = GWT.create(Resources.class);

    @Source("css/datepicker.css")
    TextResource datepickerCss();

    @Source("js/bootstrap-datepicker.js")
    TextResource datepickerJs();

    /*
        Script used to gen the basic Locale resources declarations:

        for a in `ls`; do  echo "@Source(\"js/locales/$a\")"; echo  "TextResource ` echo $a | cut -f2 -d.`();"; done
     */
    @Source("js/locales/bootstrap-datepicker.bg.js")
    TextResource bg();
    
    @Source("js/locales/bootstrap-datepicker.br.js")
    TextResource br();

    @Source("js/locales/bootstrap-datepicker.cs.js")
    TextResource cs();

    @Source("js/locales/bootstrap-datepicker.da.js")
    TextResource da();
    
    @Source("js/locales/bootstrap-datepicker.de.js")
    TextResource de();

    @Source("js/locales/bootstrap-datepicker.es.js")
    TextResource es();

    @Source("js/locales/bootstrap-datepicker.fi.js")
    TextResource fi();

    @Source("js/locales/bootstrap-datepicker.fr.js")
    TextResource fr();

    @Source("js/locales/bootstrap-datepicker.id.js")
    TextResource id();

    @Source("js/locales/bootstrap-datepicker.is.js")
    TextResource is();

    @Source("js/locales/bootstrap-datepicker.it.js")
    TextResource it();

    @Source("js/locales/bootstrap-datepicker.ja.js")
    TextResource ja();

    @Source("js/locales/bootstrap-datepicker.kr.js")
    TextResource kr();

    @Source("js/locales/bootstrap-datepicker.lt.js")
    TextResource lt();

    @Source("js/locales/bootstrap-datepicker.lv.js")
    TextResource lv();

    @Source("js/locales/bootstrap-datepicker.ms.js")
    TextResource ms();

    @Source("js/locales/bootstrap-datepicker.nb.js")
    TextResource nb();

    @Source("js/locales/bootstrap-datepicker.nl.js")
    TextResource nl();

    @Source("js/locales/bootstrap-datepicker.pl.js")
    TextResource pl();

    @Source("js/locales/bootstrap-datepicker.pt.js")
    TextResource pt();

    @Source("js/locales/bootstrap-datepicker.pt-BR.js")
    TextResource pt_BR();

    @Source("js/locales/bootstrap-datepicker.ru.js")
    TextResource ru();

    @Source("js/locales/bootstrap-datepicker.sl.js")
    TextResource sl();

    @Source("js/locales/bootstrap-datepicker.sv.js")
    TextResource sv();

    @Source("js/locales/bootstrap-datepicker.th.js")
    TextResource th();

    @Source("js/locales/bootstrap-datepicker.tr.js")
    TextResource tr();

    @Source("js/locales/bootstrap-datepicker.zh-CN.js")
    TextResource zh_CN();
    
    @Source("js/locales/bootstrap-datepicker.zh-TW.js")
    TextResource zh_TW();

    

}
