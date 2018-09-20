package com.javatraining.java8;
/*** pass  a function as parameter ***/
public class MainApp {

	public static void main(String[] args) {
		
		Filter filter= new MaximumFilter();
		
		printFilteredValue(filter,1,2); //average => 1.5 , maximum = > 2 
		
	}
	
	private static void printFilteredValue(Filter filter,double...numbers) {
		System.out.println(filter.applyFilter(numbers));
	}

}