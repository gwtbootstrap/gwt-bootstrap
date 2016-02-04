/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.gwtbootstrap.showcase.client;

import com.github.gwtbootstrap.client.ui.CodeBlock;
import com.github.gwtbootstrap.client.ui.ProgressBar;
import com.github.gwtbootstrap.client.ui.base.ProgressBarBase;

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
		ProgressBar progressBar = new ProgressBar(ProgressBarBase.Style.ANIMATED);
		progressBar.setPercent(100);
		codePanel.setWidget(progressBar);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		builder.setCallback(new RequestCallback() {
			
			@Override
			public void onResponseReceived(Request request, Response response) {
				
				String text = response.getText();
				
				CodeBlock block = new CodeBlock(text);
				
				block.setLinenums(true);
				
				codePanel.setWidget(block);
			}
			
			@Override
			public void onError(Request request, Throwable exception) {
				// Do nothing
			}
		});
	}

}
