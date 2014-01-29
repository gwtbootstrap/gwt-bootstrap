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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.IconAnchor;
import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.event.HideEvent;
import com.github.gwtbootstrap.client.ui.event.HideHandler;
import com.github.gwtbootstrap.client.ui.event.ShowEvent;
import com.github.gwtbootstrap.client.ui.event.ShowHandler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * A dropdown that accepts any type of widget.
 * <p>
 * <h3>UiBinder Usage:</h3>
 *
 * <pre>
 * {@code
 * <b:DropdownContainer text="I am the Caption">
 *     <b:NavHeader>Header</b:NavHeader>
 *     <b:NavLink>Link 1</b:NavLink>
 *     <b:NavLink>Link 2</b:NavLink>
 *     <b:Button>Hey you, I'm a button</b:Button>
 * </b:DropdownContainer>
 * }
 * </pre>
 * </p>
 *
 * @since 2.0.4.0
 *
 * @author Carlos Alexandro Becker
 * @author Cássio de Freitas e Silva
 *
 * @see <a href="http://twitter.github.com/bootstrap/javascript.html#dropdowns">Bootstrap documentation</a>
 * @see DropdownButton
 * @see SplitDropdownButton
 * @see Dropdown
 */
public class DropdownContainer extends Dropdown {

    private UnorderedList menu = new UnorderedList();
    private boolean menuVisible;
    private HandlerManager handlerManager;

    @Override
    protected IconAnchor createTrigger() {
        final IconAnchor trigger = super.createTrigger();
        trigger.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if (menuVisible) {
                    hideContainer();
                } else {
                    showContainer();
                }
            }
        }, ClickEvent.getType());

        return trigger;
    }

    public DropdownContainer() {
        this("");
    }

    public DropdownContainer(String caption) {
        super(caption);
        for (Widget widget : getChildren()) {
            if (widget instanceof UnorderedList) {
                menu = (UnorderedList) widget;
                break;
            }
        }
        menu.getElement().getStyle().clearDisplay();
        menu.getElement().getStyle().setDisplay(Style.Display.NONE);

        handlerManager = createHandlerManager();
    }

    public void showContainer() {
        menu.getElement().getStyle().setDisplay(Style.Display.BLOCK);
        menuVisible = true;

        for (int i = 0; i < handlerManager.getHandlerCount(ShowEvent.getType()); i++) {
            ShowHandler sh = handlerManager.getHandler(ShowEvent.getType(), i);
            sh.onShow(new ShowEvent(null));
        }
    }

    public void hideContainer() {
        menu.getElement().getStyle().setDisplay(Style.Display.NONE);
        menuVisible = false;

        for (int i = 0; i < handlerManager.getHandlerCount(HideEvent.getType()); i++) {
            HideHandler hh = handlerManager.getHandler(HideEvent.getType(), i);
            hh.onHide(new HideEvent(null));
        }
    }

    public HandlerRegistration addHideHandler(HideHandler hideHandler) {
        return handlerManager.addHandler(HideEvent.getType(), hideHandler);
    }

    public HandlerRegistration addShowHandler(ShowHandler showHandler) {
        return handlerManager.addHandler(ShowEvent.getType(), showHandler);
    }
}
