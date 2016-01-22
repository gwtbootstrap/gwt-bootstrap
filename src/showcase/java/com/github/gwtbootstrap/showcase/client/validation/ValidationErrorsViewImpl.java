/**
 * 
 */
package com.github.gwtbootstrap.showcase.client.validation;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.PasswordTextBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDriver;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author ivangsa
 *
 */
public class ValidationErrorsViewImpl extends Composite implements ValidationErrorsView, Editor<ValidationErrorsView.LoginDetails> {

	interface Binder extends UiBinder<Widget, ValidationErrorsViewImpl> {}
	private static Binder uiBinder = GWT.create(Binder.class);
	
	interface Driver extends SimpleBeanEditorDriver<ValidationErrorsView.LoginDetails, ValidationErrorsViewImpl> { }	
	private final Driver driver = GWT.create(Driver.class);

	private final Delegate delegate;
	
	@UiField TextBox username;
	@UiField PasswordTextBox password;
	
	
	@UiField Button loginButton;
	
	/**
	 * 
	 */
	public ValidationErrorsViewImpl(Delegate delegate) {
		super();
		this.delegate = delegate;
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new LoginDetails());
	}
	
	@UiHandler("loginButton")
	void onLoginClick(ClickEvent event) {
		delegate.onLoginClick();
	}

	@Override
	public EditorDriver<ValidationErrorsView.LoginDetails> getEditorDriver() {
		return driver;
	}
}

