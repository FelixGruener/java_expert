package com.mycompany.java8;

import java.util.Optional;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Optional<String> name = getName("Max","Mustermann");
		if (name.isPresent()) {
			System.out.println(name.get());
		}
		
		//equilalent
		
		name.ifPresent(System.out::println);
		name.ifPresent(realName -> System.out.println(realName));
		
		System.out.println(name.orElse("<unknown>")); //default value is unknown if empty 
		
		String realName = name.orElseThrow(()->new RuntimeException(""));

	}
	
	//OptionalInt returns primitive Type 
	//Optional<Integer> returns Object of Type Int
	
	/*private static String getName(String firstName,String lastName) {
		
		if(firstName != null && lastName != null) {
			return firstName + " " + lastName;
		}
		return null;
		
	}*/

	//Better return Optional 
	private static Optional<String> getName(String firstName,String lastName) {
		
		String name = null;
		
		if(firstName != null && lastName != null) {
			name =  firstName + " " + lastName;
		}
		return Optional.ofNullable(name);
		
	}
	
	
}
