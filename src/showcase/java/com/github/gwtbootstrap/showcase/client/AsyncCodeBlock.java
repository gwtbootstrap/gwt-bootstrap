package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.ProgressBar;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;


public class AsyncCodeBlock extends Composite {

	SimplePanel codePanel = new SimplePanel();

	public AsyncCodeBlock() {
		initWidget(codePanel);
	}
	
	public void setUrl(String url) {
		ProgressBar progressBar = new ProgressBar(ProgressBar.Style.ANIMATED);
		progressBar.setPercent(100);
		codePanel.setWidget(progressBar);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		builder.setCallback(new RequestCallback() {
			
			@Override
			public void onResponseReceived(Request request, Response response) {
				
				String text = response.getText();
				
				
				
			}
			
			@Override
			public void onError(Request request, Throwable exception) {
				
			}
		});
	}

}
