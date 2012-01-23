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
		gen("span", 24);
		gen("offset", 12);
		gen("btn");
		gen("primary");
		gen("success");
		gen("info");
		gen("danger");
		gen("error");
		gen("warning");
		gen("tabs");
		gen("pills");
		gen("breadcrumb");
		gen("divider");
		gen("pagination");
		gen("prev");
		gen("next");
		gen("disabled");
		gen("active");
		gen("alert-message");
		gen("block-message");
		gen("large");
		gen("small");
		gen("container");
		gen("container-fluid");
		gen("sidebar");
		gen("content");
		gen("row");
		gen("fade");
		gen("in");
		gen("out");
		System.out.println(sb.toString());
	}

	private void gen(String classe) {
		sb.append(cons).append(classe.replaceAll("-", "_")).append(" = ")
				.append("\"").append(classe).append("\";\n\n");
	}

	private void gen(String classe, int max) {
		int i = 1;
		while (i <= max) {
			sb.append(cons).append(classe).append(i).append(" = ").append("\"")
					.append(classe).append(i).append("\";\n\n");
			i++;
		}
	}

	public static void main(String[] args) {
		new GenerateCssResources().generate();
	}
}
