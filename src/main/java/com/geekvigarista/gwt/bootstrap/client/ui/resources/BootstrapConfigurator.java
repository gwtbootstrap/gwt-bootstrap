package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootstrapConfigurator {

	private static final String bootstrap_version = "1.4.0";

	// FIXME colocar os arquivos dentro do projeto.
	private static final String bootstrap_baseuri = "http://twitter.github.com/bootstrap/";

	private static final String bootstrap_uri = bootstrap_baseuri
			+ bootstrap_version;

	private static final String[] bootstrap_plugins = new String[] { "alerts",
			"modal", "dropdown", "scrollspy", "buttons", "tabs", "twipsy",
			"popover" };

	/**
	 * ResourceTypes disponible for loadExternalResources.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 22/01/2012
	 */
	interface ResourceType {
		public static final String CSS = "css";
		public static final String JS = "js";
	}

	/**
	 * Export the loadExternarResources Function to window element.
	 */
	private static native void exportLoadExternalResourse() /*-{
		$wnd.loadExternalResource = function(filename, filetype) {
			if (filetype == "js") {
				var fileref = document.createElement('script');
				fileref.setAttribute("type", "text/javascript");
				fileref.setAttribute("src", filename);
			} else if (filetype == "css") {
				var fileref = document.createElement("link");
				fileref.setAttribute("rel", "stylesheet");
				fileref.setAttribute("type", "text/css");
				fileref.setAttribute("href", filename);
			}
			if (typeof fileref != "undefined") {
				$doc.getElementsByTagName("head")[0].appendChild(fileref);
			}
		}
	}-*/;

	/**
	 * Load a external Resource (JS or CSS)
	 * 
	 * @see ResourceType
	 * @param filename
	 * @param filetype
	 */
	private static native void loadExternalResource(String filename,
			String filetype) /*-{
		$wnd.loadExternalResource(filename, filetype);
	}-*/;

	/**
	 * return de documents head element.
	 * 
	 * @return
	 */
	private static native com.google.gwt.user.client.Element getHeadElement() /*-{
		return $doc.head;
	}-*/;

	/**
	 * Import the required styles and JSs to the head of modules HTML.
	 */
	public static void configure() {
		exportLoadExternalResourse();

		loadExternalResource(bootstrap_uri + "/bootstrap.min.css",
				ResourceType.CSS);
		loadExternalResource("http://code.jquery.com/jquery-1.7.1.min.js",
				ResourceType.JS);

		for (String plugin : bootstrap_plugins) {
			loadExternalResource(
					bootstrap_uri + "/bootstrap-" + plugin + ".js",
					ResourceType.JS);
		}
	}
}
