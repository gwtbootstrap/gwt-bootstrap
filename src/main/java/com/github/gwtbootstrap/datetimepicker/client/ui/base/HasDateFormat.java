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
package com.github.gwtbootstrap.datetimepicker.client.ui.base;

//import com.google.gwt.i18n.client.DateTimeFormat;


/**
 * Define a element to have the getter and setter of format (string).
 *
 * @author Carlos Alexandro Becker
 * @author Alain Penders
 * @since 2.1.1.0
 */
public interface HasDateFormat {

    /**
     * Set the format in the component.  (In DPGlobal format!)
     *
     * @param format: the date format (e.g.: dd/mm/yyyy hh:ii)
     */
    void setFormat(String format);
//
//    /**
//     * Set the format in the component (as a GWT DateTimeFormat)
//     *
//     * @param format DateTimeFormat to use.
//     */
//    void setDateTimeFormat(DateTimeFormat format);
}
