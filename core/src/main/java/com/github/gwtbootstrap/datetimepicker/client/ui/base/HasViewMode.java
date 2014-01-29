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

/**
 * Define a element that have the startView property.
 *
 * @author Carlos Alexandro Becker
 * @author Alain Penders
 * @since 2.1.1.0
 */
public interface HasViewMode {

    public static enum ViewMode {HOUR, DAY, MONTH, YEAR, DECADE}

    /**
     * Set the Min ViewMode
     *
     * @param mode ViewMode.{HOUR,DAY,MONTH,YEAR,DECADE}
     */
    void setMinView(ViewMode mode);

    /**
     * Set the Min ViewMode
     *
     * @param mode One of (HOUR,DAY,MONTH,YEAR,DECADE), case-insensitive
     */
    void setMinView(String mode);

    /**
     * Set the Start ViewMode
     *
     * @param mode ViewMode.{HOUR,DAY,MONTH,YEAR,DECADE}
     */
    void setStartView(ViewMode mode);

    /**
     * Set the Start ViewMode
     *
     * @param mode One of (HOUR,DAY,MONTH,YEAR,DECADE), case-insensitive
     */
    void setStartView(String mode);

    /**
     * Set the Max ViewMode
     *
     * @param mode ViewMode.{HOUR,DAY,MONTH,YEAR,DECADE}
     */
    void setMaxView(ViewMode mode);

    /**
     * Set the Max ViewMode
     *
     * @param mode One of (HOUR,DAY,MONTH,YEAR,DECADE), case-insensitive
     */
    void setMaxView(String mode);
}
