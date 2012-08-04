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
package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.basewidget.BasePlace;
import com.github.gwtbootstrap.showcase.client.components.ComponentPlace;
import com.github.gwtbootstrap.showcase.client.gwt.GWTPlace;
import com.github.gwtbootstrap.showcase.client.layout.LayoutPlace;
import com.github.gwtbootstrap.showcase.client.overview.OverviewPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
        OverviewPlace.Tokenizer.class,
        LayoutPlace.Tokenizer.class,
        BasePlace.Tokenizer.class,
        ComponentPlace.Tokenizer.class,
        GWTPlace.Tokenizer.class

        })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
