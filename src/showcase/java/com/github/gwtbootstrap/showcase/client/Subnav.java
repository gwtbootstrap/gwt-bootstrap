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
package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.Affix;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.NavPills;
import com.github.gwtbootstrap.client.ui.Scrollspy;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.DOM;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Subnav extends DivWidget implements HasId {

    private final NavPills container = new NavPills();
    private boolean scrollspy = true;
    private Scrollspy spy;
    private boolean isFixed;
    int navtop;

    public Subnav() {
        super("subnav");
        super.add(container);
        setId(DOM.createUniqueId());
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        getElement().setId(id);
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return getElement().getId();
    }

    /**
     * Defines whether the Navbar should contain a {@link Scrollspy}.
     * 
     * @param scrollspy
     *            <code>true</code> to include a Scrollspy. Default:
     *            <code>false</code>
     */
    public void setScrollspy(boolean scrollspy) {
        this.scrollspy = scrollspy;
        if (scrollspy) {
            spy = new Scrollspy();
            spy.setTarget("#" + getId());
        }
    }

    /**
     * Defines scrollspy target element.
     * 
     * @param spyElement
     *            target element
     */
    public void setSpyElement(Element spyElement) {

        assert spyElement != null;

        if (spy == null) {
            spy = new Scrollspy();
            spy.setTarget("#" + getId());
        }

        this.scrollspy = true;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        if (spy == null) {
            spy = new Scrollspy();
            spy.setTarget("#" + getId());
        }

        if (scrollspy) {
            spy.setOffset(this.getOffsetTop(getElement()));
            spy.configure();
        }

    }

    private native int getOffsetTop(Element e) /*-{
                                               return $wnd.jQuery(e).offset().top;
                                               }-*/;

    @Override
    public void add(Widget w) {
        container.add(w);
        
        
        String id = spy.getSpyElement().getId();
        
        if(id == null || id.isEmpty()) {
            id = DOM.createUniqueId();
            spy.getSpyElement().setId(id);
        }
        
        
        if(w instanceof NavLink) {
            NavLink link = (NavLink) w;
            IconAnchor anchor = link.getAnchor();
            anchor.getElement().setAttribute(Constants.DATA_TARGET, "#" + id + " [id='" + anchor.getTargetHistoryToken() + "']");
        }
    }

    public Scrollspy getSpy() {
        return spy;
    }

    @Override
    public void clear() {
        container.clear();
    }
}
