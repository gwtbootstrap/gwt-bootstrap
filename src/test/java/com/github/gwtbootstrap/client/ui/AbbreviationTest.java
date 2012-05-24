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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.octo.gwt.test.GwtTest;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * This is {@link Abbreviation}Test.
 * @author ohashi keisuke
 */
public class AbbreviationTest extends GwtTest {

	@Override
	public String getModuleName() {
		return "com.github.gwtbootstrap.Bootstrap";
	}

	/**
	 * test for Constractor {@link Abbreviation#Abbreviation(String, String)}
	 */
	@Test
	public void testAbbreviation() {
		
		//given
		String text = "text";
		String title = "title";
		
		//actual
		Abbreviation abbreviation = new Abbreviation(text, title);
		
		//assert
		assertNotNull(abbreviation);

		assertEquals("tag should be addr","abbr", abbreviation.getElement().getTagName());
		
		assertEquals("text should be args",text , abbreviation.getText());
		
		assertEquals("title should be args" ,title, abbreviation.getTitle());
	}

	/**
	 * test for Constractor {@link Abbreviation#Abbreviation(String)}
	 */
	@Test
	public void testAbbreviationString() {
		//given
		String title = "title";
		
		//actual
		Abbreviation abbreviation = new Abbreviation(title);
		
		//assert
		assertNotNull(abbreviation);

		assertEquals("tag should be addr","abbr", abbreviation.getElement().getTagName());
		
		assertEquals("text should be empty (not null)","" , abbreviation.getText());
		
		assertEquals("title should be args" ,title, abbreviation.getTitle());
	}

	/**
	 * test for {@link Abbreviation#setInitalism(boolean)}method
	 */
	@Test
	public void testSetInitalism() {
		//given
		String title = "title";
		Abbreviation abbreviation = new Abbreviation(title);
		
		//actual
		abbreviation.setInitalism(true);
		
		String styleName = abbreviation.getStyleName();
		
		//assert
		assertNotNull(styleName);
		
		assertTrue("if set true,add stylename",styleName.contains(Bootstrap.initialism));
		
		//actual 2
		abbreviation.setInitalism(false);
		
		styleName = abbreviation.getStyleName();
		
		//assert
		assertNotNull(styleName);
		assertFalse("if set false,remove stylename",styleName.contains(Bootstrap.initialism));
		
		
	}


}
