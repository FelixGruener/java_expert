package at.javatraining.java8;

import java.util.function.Function;

public class Calculation {
	private double value;
	
	private Calculation(double initialValue) {
		this.value = initialValue;
	}

	public static Calculation start(double initialValue) {
		return new Calculation(initialValue);
	}

	public Calculation evaluate(Function<Double, Double> function) {
		value = function.apply(value); // execute the function's method (= Lambda expression)
		return this;
	}
	
	public double getValue() {
		return value;
	}
}