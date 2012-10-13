package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.HasStyle;
import com.github.gwtbootstrap.client.ui.base.HasType;
import com.github.gwtbootstrap.client.ui.base.IsResponsive;
import com.github.gwtbootstrap.client.ui.base.ResponsiveHelper;
import com.github.gwtbootstrap.client.ui.base.Style;
import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.Device;
import com.github.gwtbootstrap.client.ui.constants.ImageType;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;

/**
 * The Image class for Bootstrap style
 * @since 2.1.1.0
 * @author ohashi keisuke
 */
public class Image extends com.google.gwt.user.client.ui.Image implements
        IsResponsive, HasStyle, HasType<ImageType> {

    /**
     * Creates an empty image.
     */
    public Image() {
        super();
        setStyleName("");
    }
    
    /**
     * Creates an image whose size and content are defined by an ImageResource.
     * 
     * @param resource the ImageResource to be displayed
     */
    public Image(ImageResource resource) {
      super(resource);
      setStyleName("");
    }
    
    /**
     * Creates a clipped image with a specified URL and visibility rectangle. The
     * visibility rectangle is declared relative to the the rectangle which
     * encompasses the entire image, which has an upper-left vertex of (0,0). The
     * load event will be fired immediately after the object has been constructed
     * (i.e. potentially before the image has been loaded in the browser). Since
     * the width and height are specified explicitly by the user, this behavior
     * will not cause problems with retrieving the width and height of a clipped
     * image in a load event handler.
     * 
     * @param url the URL of the image to be displayed
     * @param left the horizontal co-ordinate of the upper-left vertex of the
     *          visibility rectangle
     * @param top the vertical co-ordinate of the upper-left vertex of the
     *          visibility rectangle
     * @param width the width of the visibility rectangle
     * @param height the height of the visibility rectangle
     */
    public Image(SafeUri url, int left, int top, int width, int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    /**
     * Creates an image with a specified URL. The load event will be fired once
     * the image at the given URL has been retrieved by the browser.
     * 
     * @param url the URL of the image to be displayed
     */
    public Image(SafeUri url) {
        super(url);
        setStyleName("");
    }

    /**
     * Creates a clipped image with a specified URL and visibility rectangle. The
     * visibility rectangle is declared relative to the the rectangle which
     * encompasses the entire image, which has an upper-left vertex of (0,0). The
     * load event will be fired immediately after the object has been constructed
     * (i.e. potentially before the image has been loaded in the browser). Since
     * the width and height are specified explicitly by the user, this behavior
     * will not cause problems with retrieving the width and height of a clipped
     * image in a load event handler.
     * 
     * @param url the URL of the image to be displayed
     * @param left the horizontal co-ordinate of the upper-left vertex of the
     *          visibility rectangle
     * @param top the vertical co-ordinate of the upper-left vertex of the
     *          visibility rectangle
     * @param width the width of the visibility rectangle
     * @param height the height of the visibility rectangle
     */
    public Image(String url, int left, int top, int width, int height) {
        super(url, left, top, width, height);
        setStyleName("");
    }

    /**
     * Creates an image with a specified URL. The load event will be fired once
     * the image at the given URL has been retrieved by the browser.
     * 
     * @param url the URL of the image to be displayed
     */
    public Image(String url) {
        super(url);
        setStyleName("");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setShowOn(Device device) {
        ResponsiveHelper.setShowOn(this, device);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHideOn(Device device) {
        ResponsiveHelper.setHideOn(this, device);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setType(ImageType style) {
        StyleHelper.changeStyle(this, style, ImageType.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStyle(Style style) {
        StyleHelper.setStyle(this, style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addStyle(Style style) {
        StyleHelper.setStyle(this, style);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeStyle(Style style) {
        StyleHelper.setStyle(this, style);
    }

}
