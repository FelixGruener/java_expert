package com.mycompany.java8;

import java.util.ArrayList;
import java.util.List;

public class Programm {
	
	private List<myInterface> mine = new ArrayList<>();
	
	//we add something , when we call it (lambda expression implements the interface)
	public Programm add(myInterface my) {
		mine.add(my);
		return this;
	}


	public void execute() {
		
		mine.forEach(my -> my.executeStep());
		mine = new ArrayList<>();
		
	}
	

}
