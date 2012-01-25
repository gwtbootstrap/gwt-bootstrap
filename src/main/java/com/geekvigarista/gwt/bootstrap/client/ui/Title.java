package com.geekvigarista.gwt.bootstrap.client.ui;

/**
 * Interface with all Tipography Title Componentes (h1..h6).
 * @author Carlos Alexandro Becker
 * @since 24/01/2012
 */
public interface Title {

	/**
	 * H1 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H1 extends TypographyBase {
		public H1(String text) {
			super(text, TypographyType.H1);
		}
	}

	/**
	 * H2 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H2 extends TypographyBase {
		public H2(String text) {
			super(text, TypographyType.H2);
		}
	}

	/**
	 * H3 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H3 extends TypographyBase {
		public H3(String text) {
			super(text, TypographyType.H3);
		}
	}

	/**
	 * H4 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H4 extends TypographyBase {
		public H4(String text) {
			super(text, TypographyType.H4);
		}
	}

	/**
	 * H5 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H5 extends TypographyBase {
		public H5(String text) {
			super(text, TypographyType.H5);
		}
	}

	/**
	 * H6 title type.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 24/01/2012
	 */
	public class H6 extends TypographyBase {
		public H6(String text) {
			super(text, TypographyType.H6);
		}
	}

}
