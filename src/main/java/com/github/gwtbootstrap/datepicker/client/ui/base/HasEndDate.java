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
package com.github.gwtbootstrap.datepicker.client.ui.base;

import java.util.Date;

/**
 * Define a element to the endDate Property
 *
 * @author Carlos Alexandro Becker
 * @since 2.0.4.0
 */
public interface HasEndDate {

    /**
     * Set the max date in the component.
     * @param date: the date format when the calendar will end
     */
    void setEndDate(String date);

    /**
     * Set the max date in the component.
     * @param date: the date format when the calendar will end
     */
    void setEndDate_(Date date);


}
