package com.mycompany.java8;

public class Person {

	private String name;
	
	private String email;

	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;
		//sonts kannst du es nicht verketten
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Person setEmail(String email) {
		this.email = email;
		//sonts kannst du es nicht verketten
		return this;
	}
	
	
}
