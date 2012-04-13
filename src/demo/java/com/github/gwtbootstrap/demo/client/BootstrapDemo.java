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
package com.github.gwtbootstrap.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * @author Carlos Alexandro Becker
 * @since 21/01/2012
 */
public class BootstrapDemo implements EntryPoint {

	public void onModuleLoad() {

//		FluidContainer container = new FluidContainer();
//
//		Column sidebar = new Column(2);
//		sidebar.add(new Button("Default"));
//        sidebar.add(new Button("Danger", new Button.OPTION[]{Button.OPTION.DANGER}));
//        sidebar.add(new Button("Large Info", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.INFO}));
//        sidebar.add(new Button("Small success", new Button.OPTION[]{Button.OPTION.SMALL, Button.OPTION.SUCCESS}));
//        sidebar.add(new Button("Large Primary", new Button.OPTION[]{Button.OPTION.LARGE, Button.OPTION.PRIMARY}, new Icon(Icon.Type.OK_SIGN, Icon.COLOR.WHITE)));

//		container.add(sidebar);
//
//		Column content = new Column(10);
//
//		FluidRow grid = new FluidRow();
//		Column gi1 = new Column(10);
//		gi1.add(new Heading("Welcome to GWT-Bootstrap", 1));
//		gi1.add(new Heading("2.0.0-SNAPSHOT", 6));
//		gi1.add(new Label("Grid 10"));
//		grid.add(gi1);
//		Row grid1 = new Row();
//		Column gi21 = new Column(12, 3);
//		Button disabledBtn =
//				new Button("Button inside a grid inside a grid and disabled",
//						IconType.CHECK);
//		disabledBtn.setEnabled(false);
//		gi21.add(disabledBtn);
//		grid1.add(gi21);
//		gi1.add(grid1);
//		content.add(grid);
//		grid1.add(new Column(2, new Strong("I'm a Strong semantic text!")));
//		grid1.add(new Column(2, new Emphasis("I'm a em semantic text!")));
//		grid1.add(new Column(2, new Abbreviation("abbr",
//				"abbre means abbreviation, noob!!")));
//		grid1.add(new Column(4, new Blockquote(
//				"The best Bootstrap port for GWT in the whole world!",
//				"Carlos (me)", true)));
//
//		FluidRow grid2 = new FluidRow();
//		content.add(grid2);
//
////        grid2.add(new Column(3, new UnorderedList(new ListItem(new Label("OI")), new ListItem(new Button("Bottao numa fodendo lista", new OPTION[]{Button.OPTION.INVERSE, Button.OPTION.MINI}, new Icon(Icon.Type.SHOPPING_CART, Icon.COLOR.WHITE))))));
//
//		ButtonToolbar toolbar = new ButtonToolbar();
//		toolbar.add(new ButtonGroup(new Button("1"), new Button("2"),
//				new Button("3"), new Button("4")));
//		toolbar.add(new ButtonGroup(new Button("5", IconType.STAR)));
//		toolbar.add(new ButtonGroup(new Button("6"), new Button("7"),
//				new Button("8")));
//
//		grid2.add(toolbar);
//
//		container.add(content);

//		RootPanel.get().add(container);
//		try {
//			container.add(new BootstrapUiBinderDemo());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		RootPanel.get().add(new BootstrapUiBinderDemo());
	}
}
