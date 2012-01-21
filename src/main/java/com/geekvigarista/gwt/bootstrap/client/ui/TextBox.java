package com.geekvigarista.gwt.bootstrap.client.ui;

import com.geekvigarista.gwt.bootstrap.client.ui.resources.BootstrapCssResources;

/**
 * The BootStrap TextBox.
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class TextBox extends com.google.gwt.user.client.ui.TextBox implements
		BootstrapCssResources {

	/**
	 * Disponible sizes for the BootStrapTextBox. The default size is 3.
	 * 
	 * @author Carlos Alexandro Becker
	 * @since 21/01/2012
	 */
	public enum TextBoxSize {
		_1 {
			@Override
			String getSize() {
				return span1;
			}
		},
		_2 {
			@Override
			String getSize() {
				return span2;
			}
		},
		_3 {
			@Override
			String getSize() {
				return span3;
			}
		},
		_4 {
			@Override
			String getSize() {
				return span4;
			}
		},
		_5 {
			@Override
			String getSize() {
				return span5;
			}
		},
		_6 {
			@Override
			String getSize() {
				return span6;
			}
		},
		_7 {
			@Override
			String getSize() {
				return span7;
			}
		},
		_8 {
			@Override
			String getSize() {
				return span8;
			}
		},
		_9 {
			@Override
			String getSize() {
				return span9;
			}
		},
		_10 {
			@Override
			String getSize() {
				return span10;
			}
		},
		_11 {
			@Override
			String getSize() {
				return span11;
			}
		},
		_12 {
			@Override
			String getSize() {
				return span12;
			}
		},
		_13 {
			@Override
			String getSize() {
				return span13;
			}
		},
		_14 {
			@Override
			String getSize() {
				return span14;
			}
		},
		_15 {
			@Override
			String getSize() {
				return span15;
			}
		},
		_16 {
			@Override
			String getSize() {
				return span16;
			}
		},
		_17 {
			@Override
			String getSize() {
				return span17;
			}
		},
		_18 {
			@Override
			String getSize() {
				return span18;
			}
		},
		_19 {
			@Override
			String getSize() {
				return span19;
			}
		},
		_20 {
			@Override
			String getSize() {
				return span20;
			}
		},
		_21 {
			@Override
			String getSize() {
				return span21;
			}
		},
		_22 {
			@Override
			String getSize() {
				return span22;
			}
		},
		_23 {
			@Override
			String getSize() {
				return span23;
			}
		},
		_24 {
			@Override
			String getSize() {
				return span24;
			}
		};

		abstract String getSize();
	}

	public TextBox() {
		super();
		setSize(TextBoxSize._3);
	}

	public TextBox(TextBoxSize size) {
		super();
		setSize(size);
	}

	public void setSize(TextBoxSize size) {
		setStyleName(size.getSize());
	}
}
