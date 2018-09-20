package at.javatraining.java8;

import java.util.function.Function;

public class MainApp {
	public static void main(String[] args) {
		Function<Double, Double> pow2 = number -> Math.pow(number, 2); 
		Function<Double, Double> mult2 = number -> number * 2;
		
		double result = Calculation.start(2.0)
			.evaluate(pow2.andThen(mult2.andThen(x -> x*2)).andThen(mult2))
			.evaluate(x -> x / 2)
			.getValue();
		System.out.println(result); // 64
	}
}