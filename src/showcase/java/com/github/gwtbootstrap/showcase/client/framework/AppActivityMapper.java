package com.github.gwtbootstrap.showcase.client.framework;

import com.github.gwtbootstrap.showcase.client.ClientFactory;
import com.github.gwtbootstrap.showcase.client.gwt.GWTActivity;
import com.github.gwtbootstrap.showcase.client.overview.OverviewActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    private IShowcaseActivity old;

    public AppActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {

        if (!(place instanceof HasMenuPlace)) {
            return old;
        }

        HasMenuPlace p = (HasMenuPlace) place;

        return createActivity(p);
    }

    private IShowcaseActivity createActivity(HasMenuPlace p) {

        IShowcaseActivity activity = null;

        switch (p.getMenu()) {
        case OVERVIEW:
            clientFactory.getSubnav().setVisible(false);
            activity = new OverviewActivity();
            break;
        case LAYOUT:
            clientFactory.getSubnav().setVisible(true);

            activity = clientFactory.getLayoutActivity();
            break;
        case BASE:
            clientFactory.getSubnav().setVisible(true);

            activity = clientFactory.getBaseActivity();
            break;

        case COMPONENT:
            clientFactory.getSubnav().setVisible(true);

            activity = clientFactory.getComponentActivity();
            break;
            
        case GWT:
            clientFactory.getSubnav().setVisible(false);
            activity = GWT.create(GWTActivity.Proxy.class);
            break;
        default:

            if (old != null) {
                return old;
            } else {
                clientFactory.getSubnav().setVisible(false);
                activity = new OverviewActivity();
            }

        }

        activity.setClientFactory(clientFactory);
        activity.setPlace(p);

        old = activity;

        return activity;

    }

}
