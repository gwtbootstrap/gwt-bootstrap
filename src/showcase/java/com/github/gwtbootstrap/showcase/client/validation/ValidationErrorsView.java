/**
 * 
 */
package com.github.gwtbootstrap.showcase.client.validation;

import com.google.gwt.editor.client.EditorDriver;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author ivangsa
 *
 */
public interface ValidationErrorsView extends IsWidget {

	public static class LoginDetails {
		String username;
		String password;
		boolean rememberMe;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isRememberMe() {
			return rememberMe;
		}
		
		public void setRememberMe(boolean spring_security_remember_me) {
			this.rememberMe = spring_security_remember_me;
		}
		
		@Override
		public String toString() {
			return "LoginDetails [username=" + username + ", password=" + password + ", spring_security_remember_me=" + rememberMe + "]";
		}
	}
	
	public interface Delegate {
		void onLoginClick();
	}
	
	EditorDriver<LoginDetails> getEditorDriver();
}
