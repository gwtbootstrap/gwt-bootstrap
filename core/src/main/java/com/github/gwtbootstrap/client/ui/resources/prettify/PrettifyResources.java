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
package com.github.gwtbootstrap.client.ui.resources.prettify;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Resources for prettify plugin.
 * 
 * @since 2.0.4.0
 * 
 * @author Carlos A Becker
 * 
 */
public interface PrettifyResources extends ClientBundle {

	public static final List<String> speciallangs = Arrays.asList("apollo",
			"clj", "css", "go", "hs", "lisp", "lua", "ml", "n", "proto",
			"scala", "sql", "tex", "vb", "vhdl", "wiki", "xq", "yaml");

	public static PrettifyResources RESOURCES = GWT
			.create(PrettifyResources.class);

	@Source("prettify.css")
	TextResource prettify_css();

	@Source("prettify.js")
	TextResource prettify_js();

	// langs
	@Source("lang-apollo.js")
	TextResource apollo();

	@Source("lang-clj.js")
	TextResource clj();

	@Source("lang-css.js")
	TextResource css();

	@Source("lang-go.js")
	TextResource go();

	@Source("lang-hs.js")
	TextResource hs();

	@Source("lang-lisp.js")
	TextResource lisp();

	@Source("lang-lua.js")
	TextResource lua();

	@Source("lang-ml.js")
	TextResource ml();

	@Source("lang-n.js")
	TextResource n();

	@Source("lang-proto.js")
	TextResource proto();

	@Source("lang-scala.js")
	TextResource scala();

	@Source("lang-sql.js")
	TextResource sql();

	@Source("lang-tex.js")
	TextResource tex();

	@Source("lang-vb.js")
	TextResource vb();

	@Source("lang-vhdl.js")
	TextResource vhdl();

	@Source("lang-wiki.js")
	TextResource wiki();

	@Source("lang-xq.js")
	TextResource xq();

	@Source("lang-yaml.js")
	TextResource yaml();

}
