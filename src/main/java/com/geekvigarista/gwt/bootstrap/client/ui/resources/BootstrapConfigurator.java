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

	private static native com.google.gwt.user.client.Element getHeadElement() /*-{
		return $doc.head;
	}-*/;

	/**
	 * Import the required styles and JSs to the head of modules HTML.
	 */
	public static void configure() {
		StringBuilder sb = new StringBuilder();
		sb.append(getHeadElement().getInnerHTML()).append("\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + bootstrap_uri
				+ "/bootstrap.min.css\">");

		for (String plugin : bootstrap_plugins) {
			sb.append("<script src=\"").append(bootstrap_uri)
					.append("/bootstrap-").append(plugin).append(".js\"")
					.append("></script>");
		}

		getHeadElement().setInnerHTML(sb.toString());
	}
}
