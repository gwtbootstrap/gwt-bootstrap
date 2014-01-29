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
package com.github.gwtbootstrap.datetimepicker.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Interface that provides the DateTimePicker resources.
 *
 * @author Carlos Alexandro Becker
 * @author Alain Penders
 * @since 2.1.1.0
 */
public interface Resources
	extends ClientBundle
{

	public static Resources RESOURCES = GWT.create(Resources.class);

	@Source("css/datetimepicker.css")
	TextResource datetimepickerCss();

	@Source("js/bootstrap-datetimepicker.js")
	TextResource datetimepickerJs();

	/*
		  Script used to gen the basic Locale resources declarations:

		  for a in `ls`; do  echo "@Source(\"js/locales/$a\")"; echo  "TextResource ` echo $a | cut -f2 -d.`();"; done
	  */
	@Source("js/locales/bootstrap-datetimepicker.bg.js")
	TextResource bg();

	@Source("js/locales/bootstrap-datetimepicker.ca.js")
	TextResource ca();

	@Source("js/locales/bootstrap-datetimepicker.cs.js")
	TextResource cs();

	@Source("js/locales/bootstrap-datetimepicker.da.js")
	TextResource da();

	@Source("js/locales/bootstrap-datetimepicker.de.js")
	TextResource de();

	@Source("js/locales/bootstrap-datetimepicker.el.js")
	TextResource el();

	@Source("js/locales/bootstrap-datetimepicker.es.js")
	TextResource es();

	@Source("js/locales/bootstrap-datetimepicker.fi.js")
	TextResource fi();

	@Source("js/locales/bootstrap-datetimepicker.fr.js")
	TextResource fr();

	@Source("js/locales/bootstrap-datetimepicker.he.js")
	TextResource he();

	@Source("js/locales/bootstrap-datetimepicker.hr.js")
	TextResource hr();

	@Source("js/locales/bootstrap-datetimepicker.id.js")
	TextResource id();

	@Source("js/locales/bootstrap-datetimepicker.is.js")
	TextResource is();

	@Source("js/locales/bootstrap-datetimepicker.it.js")
	TextResource it();

	@Source("js/locales/bootstrap-datetimepicker.ja.js")
	TextResource ja();

	@Source("js/locales/bootstrap-datetimepicker.kr.js")
	TextResource kr();

	@Source("js/locales/bootstrap-datetimepicker.lt.js")
	TextResource lt();

	@Source("js/locales/bootstrap-datetimepicker.lv.js")
	TextResource lv();

	@Source("js/locales/bootstrap-datetimepicker.ms.js")
	TextResource ms();

	@Source("js/locales/bootstrap-datetimepicker.nb.js")
	TextResource nb();

	@Source("js/locales/bootstrap-datetimepicker.nl.js")
	TextResource nl();

	@Source("js/locales/bootstrap-datetimepicker.pl.js")
	TextResource pl();

	@Source("js/locales/bootstrap-datetimepicker.pt.js")
	TextResource pt();

	@Source("js/locales/bootstrap-datetimepicker.pt-BR.js")
	TextResource pt_BR();

	@Source("js/locales/bootstrap-datetimepicker.ro.js")
	TextResource ro();

	@Source("js/locales/bootstrap-datetimepicker.rs.js")
	TextResource rs();

//	@Source("js/locales/bootstrap-datetimepicker.rs-latin.js")
//	TextResource rs-latin();

	@Source("js/locales/bootstrap-datetimepicker.ru.js")
	TextResource ru();

	@Source("js/locales/bootstrap-datetimepicker.sk.js")
	TextResource sk();

	@Source("js/locales/bootstrap-datetimepicker.sl.js")
	TextResource sl();

	@Source("js/locales/bootstrap-datetimepicker.sv.js")
	TextResource sv();

	@Source("js/locales/bootstrap-datetimepicker.sw.js")
	TextResource sw();

	@Source("js/locales/bootstrap-datetimepicker.th.js")
	TextResource th();

	@Source("js/locales/bootstrap-datetimepicker.tr.js")
	TextResource tr();

	@Source("js/locales/bootstrap-datetimepicker.uk.js")
	TextResource uk();

	@Source("js/locales/bootstrap-datetimepicker.zh-CN.js")
	TextResource zh_CN();

	@Source("js/locales/bootstrap-datetimepicker.zh-TW.js")
	TextResource zh_TW();
}
