package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.base.HasSize;
import com.github.gwtbootstrap.client.ui.base.ListItem;
import com.github.gwtbootstrap.client.ui.base.SizeHelper;
import com.github.gwtbootstrap.client.ui.constants.Constants;
import com.google.gwt.user.client.ui.Widget;

/**
 * The Thumbnail container
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see Thumbnails
 * @see ThumbnailLink
 * @see <a href="http://getbootstrap.com/2.3.2/components.html#thumbnails">Twitter Bootstrap Documentation</a>
 */
public class Thumbnail extends ListItem implements HasSize {

    DivWidget thumbnail = new DivWidget();
    
    /**
     * Create an empty widget.
     */
    public Thumbnail() {
        super();
        thumbnail.setStyleName(Constants.THUMBNAIL);
        super.add(thumbnail);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Widget w) {
        thumbnail.add(w);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Widget w) {
        return thumbnail.remove(w);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        thumbnail.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSize(int size) {
        SizeHelper.setSize(this, size);
    }
}
