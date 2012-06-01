package com.github.gwtbootstrap.showcase.client.forms;

import java.util.Arrays;
import java.util.Comparator;

import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.ControlGroup;
import com.github.gwtbootstrap.client.ui.Form.SubmitEvent;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Pagination;
import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.ValueListBox;
import com.github.gwtbootstrap.client.ui.constants.ControlGroupType;
import com.github.gwtbootstrap.showcase.client.forms.Person.Favorite;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.editor.client.adapters.SimpleEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
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
	@Editor.Ignore
	TextBox age;

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
	CellTable<Person> exampleTable = new CellTable<Person>(5);

	@UiField
	SubmitButton saveButton;

	@UiField
	Pagination pagination;

	SimplePager pager = new SimplePager();

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
				return o1.getAge().compareTo(o2.getAge());
			}
		});

		exampleTable.addColumnSortHandler(ageColHandler);

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
				rebuildPager();
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
			userNameHelpInline.setText("user name shoul be input");
			hasError = true;
		}

		if (age.getValue() != null) {
			try {
				person.setAge(Integer.parseInt(age.getValue()));
			} catch (NumberFormatException nfe) {
				ageControlGroup.setType(ControlGroupType.ERROR);
				ageHelpInline.setText("Age should be numeric.");
				hasError = true;
			}
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

		rebuildPager();
		
	}

	private void rebuildPager() {
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

		for (int i = 0; i < 5; i++) {

			Person p = new Person();

			p.setAge(i + exampleTable.getRowCount());
			p.setUserName("userName" + exampleTable.getRowCount());
			addPerson(p);
		}

	}

	public void setPerson(Person person) {
		driver.edit(person);

		if (person.getAge() != null) {
			age.setValue(person.getAge().toString());
		} else {
			age.setValue("");
		}

		ageControlGroup.setType(ControlGroupType.NONE);
		ageHelpInline.setText("");

		userNameControlGroup.setType(ControlGroupType.NONE);
		userNameHelpInline.setText("");
	}

}
