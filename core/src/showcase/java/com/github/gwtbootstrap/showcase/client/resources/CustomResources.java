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
package com.github.gwtbootstrap.showcase.client.resources;

import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface CustomResources extends Resources {
	
	public static final CustomResources RESOURCES = GWT.create(CustomResources.class);
	
	@Source("css/bootstrap.min.css")
	TextResource bootstrapCss();

	@Source("gridCode.txt")
	TextResource gridCode();
	
	@Source("offsetGridCode.txt")
	TextResource offsetGridCode();
	
	@Source("nestedGridCode.txt")
	TextResource nestedGridCode();

	@Source("basicFormCode.txt")
	TextResource basicFormCode();
	
	@Source("searchFormCode.txt")
	TextResource searchFormCode();

	@Source("inlineFormCode.txt")
	TextResource inlineFormCode();

    @Source("baseIconCode.txt")
    TextResource baseIconCode();

    @Source("css/baseIcons.css")
    TextResource baseIconCss();

	TextResource horizontalFormCode();

    ImageResource logo();

    @Source("css/showcase.css")
    Showcase showcase();

}
