package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.UnorderedList;
import com.github.gwtbootstrap.client.ui.constants.Constants;

/**
 * The thumbnails widget.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:Thumbnails>
 *  <b:Thumbnail>
 *      <b:Image resource="{res.logo}/>
 *      <b:Heading>Thumbnail Label</b:Heading>
 *      <b:Paragraph>Thumbnail caption</b:Paragraph>
 *      <b:Paragraph><b:Button>Good!</b:Button><b:Button>Bad...</b:Button>
 *  </b:Thumbnail>
 *  <b:ThumbnailLink href="#top">
 *      <b:Image resource="{res.logo}/>
 *      <b:widget>
 *      <g:FlowPanel>
 *        <b:Heading>Thumbnail Label</b:Heading>
 *        <b:Paragraph>Thumbnail caption</b:Paragraph>
 *        <b:Paragraph><b:Button>Good!</b:Button><b:Button>Bad...</b:Button>
 *      </g:FlowPanel>
 *      </b:widget>
 *  </b:ThumbnailLink>
 * </b:Thumbnails>
 * }
 * </pre>
 * </p>
 * 
 * @since 2.2.1.0
 * @author ohashi keisuke
 * @see Thumbnail
 * @see ThumbnailLink
 * @see <a href="http://getbootstrap.com/2.3.2/components.html#thumbnails">Bootstrap Documentation</a>
 */
public class Thumbnails extends UnorderedList {

    /**
     * Create an empty widget
     */
    public Thumbnails() {
        super();
        setStyleName(Constants.THUMBNAILS);
    }
}
