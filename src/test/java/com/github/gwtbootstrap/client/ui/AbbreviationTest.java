package com.github.gwtbootstrap.client.ui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.gwtbootstrap.client.ui.resources.Bootstrap;
import com.octo.gwt.test.GwtTest;


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
