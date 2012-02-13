package com.geekvigarista.gwt.bootstrap.client.ui.buttons;

public enum ButtonType {

	DEFAULT {
		@Override
		public String getType() {
			return "btn";
		}
	},
	DANGER {
		@Override
		public String getType() {
			return "btn-danger";
		}
	},
	INFO {
		@Override
		public String getType() {
			return "btn-info";
		}
	},
	SUCCESS {
		@Override
		public String getType() {
			return "btn-success";
		}
	},
	PRIMARY {
		@Override
		public String getType() {
			return "btn-primary";
		}
	},
	WARNING {
		@Override
		public String getType() {
			return "btn-warning";
		}
	};

	public abstract String getType();
}
