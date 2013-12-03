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

import java.util.ArrayList;
import java.util.List;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off
/**
 * The container for a tabbable nav.
 * 
 * @since 2.0.4.0
 * @author Dominik Mayer
 * @author ohashi keisuke
 */
//@formatter:on
public class TabPanel extends DivWidget {

    public static class ShowEvent extends DomEvent<ShowEvent.Handler> {
        private static final Type<ShowEvent.Handler> TYPE = new Type<ShowEvent.Handler>(
                "show", new ShowEvent());

        private TabLink target;
        private TabLink relatedTarget;

        protected ShowEvent() {
        }

        public ShowEvent(NativeEvent event) {
            setNativeEvent(event);
            if(Element.is(event.getRelatedEventTarget())) {
                setRelativeElement(Element.as(event.getRelatedEventTarget()));
            }
        }

        public interface Handler extends EventHandler {

            void onShow(ShowEvent showEvent);
        }

        @Override
        protected void dispatch(Handler handler) {
            handler.onShow(this);
        }

        @Override
        public com.google.gwt.event.dom.client.DomEvent.Type<ShowEvent.Handler> getAssociatedType() {
            return TYPE;
        }

        /**
         * Get target
         * 
         * @return target
         */
        public TabLink getTarget() {
            return target;
        }

        /**
         * Set target
         * 
         * @param target
         *            target
         */
        public void setTarget(TabLink target) {
            this.target = target;
        }

        /**
         * Get relatedTarget。
         * 
         * @return relatedTarget
         */
        public TabLink getRelatedTarget() {
            return relatedTarget;
        }

        /**
         * Set relatedTarget
         * 
         * @param relatedTarget
         *            relatedTarget
         */
        public void setRelatedTarget(TabLink relatedTarget) {
            this.relatedTarget = relatedTarget;
        }
    }

    public static class ShownEvent extends DomEvent<ShownEvent.Handler> {
        private static final Type<ShownEvent.Handler> TYPE = new Type<ShownEvent.Handler>(
                "shown", new ShownEvent());

        private TabLink target;
        private TabLink relatedTarget;

        protected ShownEvent() {
        }

        public ShownEvent(NativeEvent event) {
            setNativeEvent(event);
            if(Element.is(event.getRelatedEventTarget())) {
                setRelativeElement(Element.as(event.getRelatedEventTarget()));
            }
        }

        public interface Handler extends EventHandler {

            void onShow(ShownEvent shownEvent);
        }

        @Override
        protected void dispatch(Handler handler) {
            handler.onShow(this);
        }

        @Override
        public com.google.gwt.event.dom.client.DomEvent.Type<ShownEvent.Handler> getAssociatedType() {
            return TYPE;
        }

        /**
         * Get target
         * 
         * @return target
         */
        public TabLink getTarget() {
            return target;
        }

        /**
         * Set target
         * 
         * @param target
         *            target
         */
        public void setTarget(TabLink target) {
            this.target = target;
        }

        /**
         * Get relatedTarget。
         * 
         * @return relatedTarget
         */
        public TabLink getRelatedTarget() {
            return relatedTarget;
        }

        /**
         * Set relatedTarget
         * 
         * @param relatedTarget
         *            relatedTarget
         */
        public void setRelatedTarget(TabLink relatedTarget) {
            this.relatedTarget = relatedTarget;
        }
    }

    private static class TabContent extends DivWidget {

        public TabContent() {
            setStyleName(Bootstrap.tab_content);
        }
    }

    private NavTabs tabs = new NavTabs();

    private List<TabLink> tabLinkList = new ArrayList<TabLink>();

    private TabContent tabContent = new TabContent();

    /**
     * Create an empty {@link Bootstrap.Tabs#ABOVE} style TabPanel.
     */
    public TabPanel() {
        this(Bootstrap.Tabs.ABOVE);
    }

    /**
     * Create an empty TabPanel.
     * @param position tab position.
     */
    public TabPanel(Bootstrap.Tabs position) {
        setStyle(position);
        if(Bootstrap.Tabs.BELOW == position) {
            //tabs should be added after content to display it below content in this case
            super.add(tabContent);
            super.add(tabs);
        } else {
            super.add(tabs);
            super.add(tabContent);
        }

        setHandlerFunctions(getElement());
    }

    /**
     * Set tab position
     * @param position tab position.
     */
    public void setTabPosition(String position) {
        if (tabs.getParent() != null) {
            remove(tabs);
            remove(tabContent);
        }

        if (position.equalsIgnoreCase("below")) {
            //tabs should be added after content to display it below content in this case
            setStyle(Bootstrap.Tabs.BELOW);
            super.add(tabContent);
            super.add(tabs);
        } else if (position.equalsIgnoreCase("left")) {
            setStyle(Bootstrap.Tabs.LEFT);
            super.add(tabs);
            super.add(tabContent);
        } else if (position.equalsIgnoreCase("right")) {
            setStyle(Bootstrap.Tabs.RIGHT);
            super.add(tabs);
            super.add(tabContent);
        } else {
            setStyle(Bootstrap.Tabs.ABOVE);
            super.add(tabs);
            super.add(tabContent);
        }
    }

    @Override
    public void add(Widget child) {
        if (child instanceof TabPane) {
            add((TabPane) child);
            return;
        }

        if (child instanceof TabLink) {
            add((TabLink) child);
            return;
        }

        if (child instanceof DropdownTab) {
            add((DropdownTab) child);
            return;
        }

        if (GWT.isProdMode()) {
            throw new IllegalArgumentException(
                    "TabPanel can add only TabPane or TabLink or Tab or DorpdownTab. you added "
                            + child);
        }
    }

    private void add(DropdownTab dropdownTab) {
        tabs.add(dropdownTab);

        List<Tab> tabList = dropdownTab.getTabList();
        for (Tab tab : tabList) {
            tabLinkList.add(tab.asTabLink());
            TabPane tabPane = tab.getTabPane();
            tabContent.add(tabPane);
        }
    }

    private void add(TabPane child) {
        if (child.isCreateTabLink()) {
            TabLink tabLink = new TabLink(child);
            tabs.add(tabLink);
            tabLinkList.add(tabLink);
        }
        tabContent.add(child);
    }

    private void add(final TabLink child) {
        if (child.isCreateTabPane() && child.getTabPane() == null) {
            TabPane pane = new TabPane(child.getText());
            child.setTabPane(pane);
            tabContent.add(pane);
        } else if (child.getTabPane() != null) {
            tabContent.add(child.getTabPane());
        }
        tabs.add(child);
        tabLinkList.add(child);
    }

    @Override
    public void clear() {
        tabContent.clear();
        tabs.clear();
        tabLinkList.clear();
    }

    /**
     * Remove tab or tabpane.
     * <p>
     * If Tablink has TabPane,romve TabPane with TabLink. </pre> {@inheritDoc}
     */
    @Override
    public boolean remove(int index) {
        Widget widget = tabs.getWidget(index);

        if (widget instanceof TabLink) {
            TabLink link = (TabLink) widget;
            if (link.getTabPane() != null) {
                link.getTabPane().removeFromParent();
            }
            tabLinkList.remove(link);
            return tabs.remove(index);
        } else if (widget instanceof DropdownTab) {

            DropdownTab dropdownTab = (DropdownTab) widget;

            List<Tab> tabList = dropdownTab.getTabList();

            for (Tab tab : tabList) {
                tabLinkList.remove(tab.asTabLink());
                if (tab.getTabPane() != null) {
                    tab.getTabPane().removeFromParent();
                }
            }
            return tabs.remove(dropdownTab);
        } else if (widget instanceof TabPane) {

            return tabContent.remove(widget);
        }

        return super.remove(widget);
    }

    /**
     * remove TabLink or TabPane.
     * <p>
     * </p>
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Widget w) {

        if (w instanceof TabLink) {
            TabLink link = (TabLink) w;
            tabLinkList.remove(link);
            if (link.getTabPane() != null) {
                link.getTabPane().removeFromParent();
            }
            return tabs.remove(w);
        } else if (w instanceof DropdownTab) {
            DropdownTab dropdownTab = (DropdownTab) w;

            List<Tab> tabList = dropdownTab.getTabList();

            for (Tab tab : tabList) {

                tabLinkList.remove(tab.asTabLink());
                if (tab.getTabPane() != null) {
                    tab.getTabPane().removeFromParent();
                }
            }

            return tabs.remove(dropdownTab);

        } else if (w instanceof TabPane) {
            return tabContent.remove(w);
        }

        return super.remove(w);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(IsWidget child) {

        if (child instanceof Tab) {
            Tab tab = (Tab) child;

            TabLink link = tab.asTabLink();

            if (link.getTabPane() != null) {
                link.getTabPane().removeFromParent();
            }
            tabLinkList.remove(link);
            return tabs.remove(link);
        } else if (child instanceof DropdownTab) {
            DropdownTab tab = (DropdownTab) child;

            List<Tab> tabList = tab.getTabList();

            for (Tab tab2 : tabList) {
                tabLinkList.remove(tab2.asTabLink());
                if (tab2.getTabPane() != null) {
                    tabContent.remove(tab2.getTabPane());
                }
            }
            return super.remove(child);
        }

        return super.remove(child);
    }

    /**
     * Activate tab by index.
     * @param index tab index.
     */
    public void selectTab(int index) {
        tabLinkList.get(index).show();
    }

    /**
     * Get Current selected tab index.
     * <p>
     * if not found, return <code>-1.</code>
     * </p>
     * 
     * @return tab index.
     */
    public int getSelectedTab() {

        for (int i = 0; i < tabLinkList.size(); i++) {
            if (tabLinkList.get(i).isActive()) {
                return i;
            }
        }
        return -1;
    }

    private void setHandlerFunctions(final TabLink e) {
        if (isOrWasAttached()) {
            setHandlerFunctions(e.getAnchor().getElement());
            return;
        }

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                setHandlerFunctions(e.getAnchor().getElement());
            }
        });

    }

    protected void onShow(Event e, Element target, Element relatedTarget) {
        ShowEvent event = new ShowEvent(e);
        event.setTarget(findTabLink(target));
        event.setRelatedTarget(findTabLink(relatedTarget));
        fireEvent(event);
    }

    protected void onShown(Event e, Element target, Element relatedTarget) {
        ShownEvent event = new ShownEvent(e);
        event.setTarget(findTabLink(target));
        event.setRelatedTarget(findTabLink(relatedTarget));
        fireEvent(event);
    }

    public HandlerRegistration addShowHandler(ShowEvent.Handler handler) {
        return addHandler(handler, ShowEvent.TYPE);
    }

    public HandlerRegistration addShownHandler(ShownEvent.Handler handler) {
        return addHandler(handler, ShownEvent.TYPE);
    }

    private TabLink findTabLink(Element e) {
        for (TabLink tabLink : tabLinkList)
            if (tabLink.getAnchor().getElement().equals(e))
                return tabLink;

        return null;
    }

    //@formatter:off
    private native void setHandlerFunctions(Element e) /*-{
        var that = this;
        var $this = $wnd.jQuery(e);
    
        $this.off('show');
        $this.off('shown');
    
        $this.on('show', function(e) {
            that.@com.github.gwtbootstrap.client.ui.TabPanel::onShow(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/dom/client/Element;)(e, e.target, e.relatedTarget);
        });
        $this.on('shown', function(e) {
            that.@com.github.gwtbootstrap.client.ui.TabPanel::onShown(Lcom/google/gwt/user/client/Event;Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/dom/client/Element;)(e, e.target, e.relatedTarget);
        });
    }-*/;
    //@formatter:on

}
