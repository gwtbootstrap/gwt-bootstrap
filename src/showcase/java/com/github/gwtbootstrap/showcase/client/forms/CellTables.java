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
package com.github.gwtbootstrap.showcase.client.forms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.DataGrid;
import com.github.gwtbootstrap.client.ui.Form;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Pagination;
import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.github.gwtbootstrap.client.ui.Tab;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.github.gwtbootstrap.datepicker.client.ui.DateBox;
import com.github.gwtbootstrap.showcase.client.forms.Person.Favorite;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.client.adapters.SimpleEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.RangeChangeEvent;

public class CellTables extends Composite implements Editor<Person> {

	SimpleEditor<Integer> id = SimpleEditor.of();

	@UiField
	TextBox userName;

	@UiField
	IntegerBox age;

	@UiField
	ControlGroup ageControlGroup;

	@UiField
	@Editor.Ignore
	HelpInline ageHelpInline;

	@UiField
	ControlGroup userNameControlGroup;

	@UiField
	@Editor.Ignore
	HelpInline userNameHelpInline;

	@UiField(provided = true)
	ValueListBox<Person.Favorite> favorite;

	@UiField(provided = true)
	CellTable<Person> exampleTable = new CellTable<Person>(5, GWT.<CellTable.SelectableResources>create(CellTable.SelectableResources.class));

    @UiField(provided = true)
    DataGrid<Person> exampleDataGrid = new DataGrid<Person>(20, GWT.<DataGrid.SelectableResources>create(DataGrid.SelectableResources.class));

	@UiField
	SubmitButton saveButton;
	
	@UiField
	DateBox birthDay;

	@UiField
	Pagination pagination;

    @UiField
    Pagination dataGridPagination;
	
	@UiField
	Form submitExampleForm;
	
	@UiField
	Tab dataGridTab;

	SimplePager pager = new SimplePager();
    SimplePager dataGridPager = new SimplePager();

	ListDataProvider<Person> dataProvider = new ListDataProvider<Person>();

	private static CellTablesUiBinder uiBinder = GWT.create(CellTablesUiBinder.class);

	interface CellTablesUiBinder extends UiBinder<Widget, CellTables> {
	}

	interface Driver extends SimpleBeanEditorDriver<Person, CellTables> {
	}

	Driver driver = GWT.create(Driver.class);

	public CellTables() {

		favorite = new ValueListBox<Person.Favorite>(new DisplayLabelRenderer<Person.Favorite>());

		initWidget(uiBinder.createAndBindUi(this));
		
		driver.initialize(this);

		setPerson(new Person());

		favorite.setAcceptableValues(Arrays.asList(Favorite.values()));

		initTable(exampleTable, pager, pagination);
        initTable(exampleDataGrid, dataGridPager, dataGridPagination);
	}

    private void initTable(AbstractCellTable<Person> exampleTable,final SimplePager pager,final Pagination pagination) {
        exampleTable.setEmptyTableWidget(new Label("Please add data."));

		TextColumn<Person> idCol = new TextColumn<Person>() {

			@Override
			public String getValue(Person object) {
				return String.valueOf(object.getId());
			}
		};

		idCol.setSortable(true);

		exampleTable.addColumn(idCol, "#");

		ListHandler<Person> idColHandler = new ListHandler<Person>(dataProvider.getList());

		idColHandler.setComparator(idCol, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});

		exampleTable.addColumnSortHandler(idColHandler);

		exampleTable.getColumnSortList().push(idCol);

		TextColumn<Person> userNameCol = new TextColumn<Person>() {

			@Override
			public String getValue(Person object) {
				return object.getUserName();
			}
		};
		userNameCol.setSortable(true);
		exampleTable.addColumn(userNameCol, "User Name");

		ListHandler<Person> userNameColHandler = new ListHandler<Person>(dataProvider.getList());

		userNameColHandler.setComparator(userNameCol, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getUserName().compareTo(o2.getUserName());
			}
		});

		exampleTable.addColumnSortHandler(userNameColHandler);

		TextColumn<Person> ageCol = new TextColumn<Person>() {

			@Override
			public String getValue(Person object) {
				return object.getAge() != null
												? String.valueOf(object.getAge())
												: "";
			}
		};
		ageCol.setSortable(true);
		exampleTable.addColumn(ageCol, "Age");
		
		ListHandler<Person> ageColHandler = new ListHandler<Person>(dataProvider.getList());

		ageColHandler.setComparator(ageCol, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o2.getAge() == null) {
					return 1;
				}
				
				if(o1.getAge() == null) {
					return -1;
				}
				return o1.getAge().compareTo(o2.getAge());
			}
		});

		exampleTable.addColumnSortHandler(ageColHandler);

		TextColumn<Person> birthDayCol = new TextColumn<Person>() {
			
			@Override
			public String getValue(Person object) {
				if(object.getBirthDay() != null) {
					return DateTimeFormat.getFormat("dd/MM/yyyy").format(object.getBirthDay());
				} else {
					return "";
				}
			}
		};
		
		exampleTable.addColumn(birthDayCol, "Birth Day");
		
		birthDayCol.setSortable(true);
		
		
		
		ListHandler<Person> birthDayColHandler = new ListHandler<Person>(dataProvider.getList());
		birthDayColHandler.setComparator(birthDayCol, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o2.getBirthDay() == null) {
					return 1;
				}
				
				if(o1.getBirthDay() == null) {
					return -1;
				}
				
				return o1.getBirthDay().compareTo(o2.getBirthDay());
			}
		});
		
		exampleTable.addColumnSortHandler(birthDayColHandler);
		
		TextColumn<Person> favoriteCol = new TextColumn<Person>() {

			@Override
			public String getValue(Person object) {
				return object.getFavorite().getDisplayLabel();
			}
		};

		favoriteCol.setSortable(true);
		exampleTable.addColumn(favoriteCol, "Favorite");

		ListHandler<Person> favoriteColHandler = new ListHandler<Person>(dataProvider.getList());

		favoriteColHandler.setComparator(favoriteCol, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getFavorite().compareTo(o2.getFavorite());
			}
		});

		exampleTable.addColumnSortHandler(favoriteColHandler);
		
		exampleTable.addRangeChangeHandler(new RangeChangeEvent.Handler() {
			
			@Override
			public void onRangeChange(RangeChangeEvent event) {
				rebuildPager(pagination, pager);
			}
		});

		pager.setDisplay(exampleTable);

		pagination.clear();

		dataProvider.addDataDisplay(exampleTable);
    }

	@UiHandler("age")
	public void onAgeUpdate(KeyPressEvent event) {

		if (event.getCharCode() < '0' || event.getCharCode() > '9') {
			ageControlGroup.setType(ControlGroupType.ERROR);
			ageHelpInline.setText("Age should be numeric.");

			event.preventDefault();
		} else {
			ageControlGroup.setType(ControlGroupType.NONE);
			ageHelpInline.setText("");

		}

	}

	@UiHandler("submitExampleForm")
	public void onSubmitForm(SubmitEvent e) {

		Person person = driver.flush();

		boolean hasError = false;

		if (person.getUserName() == null || person.getUserName().isEmpty()) {

			userNameControlGroup.setType(ControlGroupType.ERROR);
			userNameHelpInline.setText("UserName should be input");
			hasError = true;
		}

		if (person.getAge() == null) {
			ageControlGroup.setType(ControlGroupType.ERROR);
			ageHelpInline.setText("Age should be numeric.");
			hasError = true;
		}

		if (hasError) {
			e.cancel();
			return;
		}

		addPerson(person);

		setPerson(new Person());
		e.cancel();
	}
	
	

	private void addPerson(Person person) {
		if (person.getId() == null) {
			person.setId(dataProvider.getList().size() + 1);
			dataProvider.getList().add(person);
		}

		dataProvider.flush();

		rebuildPager(pagination, pager);
        rebuildPager(dataGridPagination, dataGridPager);
		
	}

	private void rebuildPager(final Pagination pagination,final SimplePager pager) {
		pagination.clear();

		if (pager.getPageCount() == 0) {
			return;
		}

		NavLink prev = new NavLink("<");

		prev.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.log(String.valueOf("prev"));
				pager.previousPage();
			}
		});

		prev.setDisabled(!pager.hasPreviousPage());

		pagination.add(prev);

		int before = 2;
		int after = 2;
		
		while (!pager.hasPreviousPages(before) && before > 0) {
			before--;
			if(pager.hasNextPages(after + 1)) {
				after++;
			}
		}


		while (!pager.hasNextPages(after) && after > 0) {
			after--;
			if(pager.hasPreviousPages(before+1)) {
				before++;
			}
		}

		for (int i = pager.getPage() - before; i <= pager.getPage() + after; i++) {

			final int index = i + 1;

			NavLink page = new NavLink(String.valueOf(index));

			page.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					pager.setPage(index - 1);
				}
			});

			if (i == pager.getPage()) {
				page.setActive(true);
			}

			pagination.add(page);
		}

		NavLink next = new NavLink(">");

		next.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.log(String.valueOf("next"));
				pager.nextPage();
			}
		});

		next.setDisabled(!pager.hasNextPage());

		pagination.add(next);
	}
	
	@UiHandler("add5Entity")
	public void onClickAdd5Entity(ClickEvent e) {
	    
	    Date date = new Date();
	    
		for (int i = 0; i < 5; i++) {

			Person p = new Person();
			p.setAge(exampleTable.getRowCount());
			p.setFavorite(Favorite.values()[Random.nextInt(Favorite.values().length)]);
			p.setUserName("userName" + exampleTable.getRowCount());
			p.setBirthDay(date);
			addPerson(p);
			date.setTime(date.getTime() + 24 * 60 * 60 * (exampleTable.getRowCount() + 1) * 1000);
		}

	}

	public void setPerson(Person person) {
		driver.edit(person);

		ageControlGroup.setType(ControlGroupType.NONE);
		ageHelpInline.setText("");

		userNameControlGroup.setType(ControlGroupType.NONE);
		userNameHelpInline.setText("");
	}
	
	@UiHandler("cancelButton")
	public void onCancelClick(ClickEvent e) {
		submitExampleForm.reset();

	}
	
	@UiHandler("dataGridTab")
	public void onClickDataGridTab(ClickEvent e) {
	    exampleDataGrid.onResize();
	}
	
}
