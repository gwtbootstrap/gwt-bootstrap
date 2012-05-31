package com.github.gwtbootstrap.showcase.client.forms;


public class Person {
	
	private Integer id;

	private Integer age;

	private String userName;
	
	private Favorite favorite = Favorite.NONE;
	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getAge() {
		return age;
	}

	
	public void setAge(Integer age) {
		this.age = age;
	}

	
	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public Favorite getFavorite() {
		return favorite;
	}

	
	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

	public Person() {
		
	}
	
	public Person(Integer id, String userName,Integer age, Favorite choice) {
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.favorite = choice;
	}
	
	public enum Favorite implements HasDisplayLabel {
		NONE("none"),
		JAVE("Java"),
		PYTHON("Python"),
		C("C"),
		CSHARTP("C#");

		private final String displayLabel;

		private Favorite(String displayLabel) {
			this.displayLabel = displayLabel;
		}
		
		@Override
		public String getDisplayLabel() {
			return displayLabel;
		}
	}


}