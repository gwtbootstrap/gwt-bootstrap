/**
 * 
 */
package com.github.gwtbootstrap.showcase.client.validation;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.metadata.ConstraintDescriptor;

import com.github.gwtbootstrap.showcase.client.validation.ValidationErrorsView.LoginDetails;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.editor.client.EditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.validation.client.impl.PathImpl;

/**
 * Showcase for <code>ErrorEditor</code>s validation decoration of <code>TextBox</code>es.
 * 
 * @author ivangsa
 *
 */
public class ValidationErrorsActivity extends AbstractActivity implements ValidationErrorsView.Delegate {

	private ValidationErrorsView view;


	/**
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = new ValidationErrorsViewImpl(this);
		panel.setWidget(view);
	}

	@Override
	public void onLoginClick() {
		EditorDriver<LoginDetails> editorDriver = view.getEditorDriver();
		LoginDetails login = editorDriver.flush();
		Set<ConstraintViolation<LoginDetails>> violations = validate(login);
 		/* This will decorate widgets implementing HasEditorErrors with validation messages */
		editorDriver.setConstraintViolations((Set)violations);
	}

	private Set<ConstraintViolation<LoginDetails>> validate(LoginDetails login){
		Set<ConstraintViolation<LoginDetails>> violations = new HashSet<ConstraintViolation<LoginDetails>>();
		if(login.getUsername() == null || "".equals(login.getUsername().trim())) {
			violations.add(buildNotNullConstraintViolation(login, "username"));		
		}
		if(login.getPassword() == null || "".equals(login.getPassword().trim())) {
			violations.add(buildNotNullConstraintViolation(login, "password"));		
		}
		return violations;
	}
	
	
	/*
	 * 	Building a Validation Constraints by hand
	 *  Nothing really interesting here..
	 */
	private ConstraintViolation<LoginDetails> buildNotNullConstraintViolation(final LoginDetails bean, final String path) {

		return new ConstraintViolation<LoginDetails>() {
			@Override
			public String getMessage() {
				return "may not be null";
			}
			@Override
			public String getMessageTemplate() {
				return null;
			}
			@Override
			public LoginDetails getRootBean() {
				return bean;
			}
			@Override
			public Class<LoginDetails> getRootBeanClass() {
				return LoginDetails.class;
			}
			@Override
			public Object getLeafBean() {
				return bean;
			}

			@Override
			public Path getPropertyPath() {
				return new PathImpl().append(path);
			}

			@Override
			public Object getInvalidValue() {
				return null;
			}

			@Override
			public ConstraintDescriptor<?> getConstraintDescriptor() {
				return new ConstraintDescriptor<NotNull>() {
					private NotNull annotation = new NotNull(){
	                    public Class<? extends Annotation> annotationType() {  return NotNull.class; }
	                    public Class[] groups() { return new Class[] {};}
	                    public String message() { return "{javax.validation.constraints.NotNull.message}";}
	                    public Class[] payload() { return new Class[] {};}
	                };
					@Override
					public NotNull getAnnotation() {
						return annotation;
					}

					@Override
					public Set<Class<?>> getGroups() {
						return new HashSet(Arrays.asList(new Class[]{javax.validation.groups.Default.class}));
					}

					@Override
					public Set<Class<? extends Payload>> getPayload() {
						return new HashSet(Arrays.asList(new Class[] {}));
					}

					@Override
					public List<Class<? extends ConstraintValidator<NotNull, ?>>> getConstraintValidatorClasses() {
						return null;
					}

					@Override
					public Map<String, Object> getAttributes() {
						Map<String, Object> attributes = new HashMap<String, Object>();
						attributes.put("message", "{javax.validation.constraints.NotNull.message}");
						attributes.put("payload", new java.lang.Class[] {});
						attributes.put("groups", new java.lang.Class[] {javax.validation.groups.Default.class});
						return attributes;
					}

					@Override
					public Set<ConstraintDescriptor<?>> getComposingConstraints() {
						return null;
					}

					@Override
					public boolean isReportAsSingleViolation() {
						return false;
					}
					
				};
			}
		};
	}

}
