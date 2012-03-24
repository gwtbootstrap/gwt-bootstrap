package com.github.gwtbootstrap.client.ui.resources;

/**
 * Adapt resources(CSS , JS) for user needs.
 * 
 * <pre>
 * If you need adapt resources,you implement this interface,
 * and add replace-with tag to your module xml.
 * 
 * [Adapt Example]
 * 1. Make Your Resources Interface (that's extends {@link Resources}).
 * <code>
 * 	public MyResources extends Resources {
 * 		@Source("mycss/custom-bootstrap.min.css")
 * 		TextResource bootstrap_css();
 * 	}
 * </code>
 * 
 * 2. Make Your ResourceAdapter.
 * <code>
 * 	public MyResourceAdapter implments ResourceAdapter {
 * 		public Resources getResources() {
 * 			return GWT.create(MyResources.class);
 * 		}
 * 	}
 * </code>
 * 3. Add replace-with tag to your module xml.
 * 
 * <code>
 * &lt;inherits name='com.github.gwtbootstrap.Bootstrap' /&gt;
 * &lt;replace-with class='userpackage.MyResourceAdapter&gt;
 * 	&lt;when-type-is class="com.github.gwtbootstrap.client.ui.resources.ResourceAdapter"&gt;
 * &lt;/replace-with&gt;
 * </code>
 * 
 * 
 * </p>
 * @author soundTricker
 * @since 24/03/2012
 * @see Resources
 * @see ResourceAdapterImpl
 */
public interface ResourceAdapter {

	/**
	 * Get Resources
	 * 
	 * @return Resources
	 */
	Resources getResources();

}
