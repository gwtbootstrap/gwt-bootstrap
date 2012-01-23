package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class GenerateCssResources {
	private String cons = "public static final String ";
	private StringBuilder sb = new StringBuilder();

	public void generate() {
		gen("span", 24).gen("offset", 12).gen("btn").gen("primary");
		gen("success").gen("info").gen("danger").gen("error").gen("warning");
		gen("tabs").gen("pills").gen("breadcrumb");
		gen("divider").gen("pagination").gen("prev");
		gen("next").gen("disabled").gen("active");
		gen("alert-message").gen("block-message").gen("large").gen("small");
		gen("container").gen("container-fluid").gen("sidebar");
		gen("content").gen("row").gen("fade").gen("in");
		gen("out").gen("modal").gen("modal-header").gen("modal-footer");
		gen("modal-body").gen("notice").gen("label").gen("important");
		gen("actions").gen("twipsy");
		System.out.println(sb.toString());
	}

	private GenerateCssResources gen(String classe) {
		sb.append(cons).append(classe.replaceAll("-", "_")).append(" = ")
				.append("\"").append(classe).append("\";\n\n");
		return this;
	}

	private GenerateCssResources gen(String classe, int max) {
		int i = 1;
		while (i <= max) {
			sb.append(cons).append(classe).append(i).append(" = ").append("\"")
					.append(classe).append(i).append("\";\n\n");
			i++;
		}
		return this;
	}

	public static void main(String[] args) {
		new GenerateCssResources().generate();
	}
}
