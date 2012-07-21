package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.NavPills;
import com.github.gwtbootstrap.client.ui.Scrollspy;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasId;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Subnav extends DivWidget implements HasId {

    private NavPills container = new NavPills();
    private boolean scrollspy;
    private Scrollspy spy;

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
            spy.setTarget(getId());
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
            spy.setTarget(getId());
        }

        spy.setSpyElement(spyElement);
        this.scrollspy = true;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        if (spy == null) {
            spy = new Scrollspy();
            spy.setTarget(getId());
        }

        if (scrollspy) {
            spy.configure();
        }
        // TODO make a unconfigure feature.
    }

    @Override
    public void add(Widget w) {
        container.add(w);
    }

    public Scrollspy getSpy() {
        return spy;
    }

    @Override
    public void clear() {
        container.clear();
    }
}
