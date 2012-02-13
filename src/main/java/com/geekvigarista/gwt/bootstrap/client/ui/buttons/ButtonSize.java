package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

public enum ButtonSize {

//	DEFAULT {
//		@Override
//		public String getSize() {
//			return "btn";
//		}
//	}, 
	LARGE {
		@Override
		public String getSize() {
			return "btn-large";
		}
	},
	SMALL {
		@Override
		public String getSize() {
			return "btn-small";
		}
	};

	public abstract String getSize();
}
