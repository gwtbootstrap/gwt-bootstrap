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

import java.util.Date;


public class Person {
	
	private Integer id;

	private Integer age;

	private String userName;
	
	private Date birthDay;
	
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
	
	public Person(Integer id, String userName,Integer age, Favorite choice, Date birthDay) {
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.favorite = choice;
		this.birthDay = birthDay;
	}

	public Date getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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