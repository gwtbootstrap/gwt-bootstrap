package com.geekvigarista.gwt.bootstrap.client.ui.resources;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class GenerateSpansOffsetsStrings {
	private String cons = "public static final String ";
	private StringBuilder sb = new StringBuilder();

	public void generate() {
		genTag("span", 24);
		genTag("offset", 12);
		genTag("btn");
		genTag("primary");
		genTag("success");
		genTag("info");
		genTag("danger");
		genTag("tabs");
		genTag("pills");
		genTag("breadcrumb");
		genTag("divider");
		genTag("pagination");
		genTag("prev");
		genTag("next");
		genTag("disabled");
		genTag("active");
		genTag("alert-message");
		genTag("block-message");
		genTag("large");
		genTag("small");
		genTag("container");
		genTag("container-fluid");
		genTag("sidebar");
		genTag("content");
		genTag("row");
		genTag("fade");
		genTag("in");
		genTag("out");
		System.out.println(sb.toString());
	}

	private void genTag(String classe) {
		sb.append(cons).append(classe.replaceAll("-", "_")).append(" = ")
				.append("\"").append(classe).append("\";\n\n");
	}

	private void genTag(String classe, int max) {
		int i = 1;
		while (i <= max) {
			sb.append(cons).append(classe).append(i).append(" = ").append("\"")
					.append(classe).append(i).append("\";\n\n");
			i++;
		}
	}

	public static void main(String[] args) {
		new GenerateSpansOffsetsStrings().generate();
	}
}
