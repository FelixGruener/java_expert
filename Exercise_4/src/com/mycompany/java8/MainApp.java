package com.mycompany.java8;

import java.util.function.Function;

public class MainApp {

	public static void main(String[] args) {
		
		Function<Double, Double> pow2 = number -> Math.pow(number,2);
		Function<Double, Double> mult2 = number -> number*2;
		
		double result = Calculation.start(2.0).evaluate(
				pow2.andThen( //4
						mult2.andThen(pow2) //8 = > 64
						).andThen(mult2)); //128
		
		System.out.println(result);
				

	}

}
