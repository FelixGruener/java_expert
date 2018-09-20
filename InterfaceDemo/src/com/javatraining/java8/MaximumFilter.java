package com.javatraining.java8;

public class MaximumFilter implements Filter {

	@Override
	public double applyFilter(double... numbers) {
		//NUll Pointer numbers = null and Division by Zero numbers.length = 0
		if (numbers==null || numbers.length ==0) {
			throw new IllegalArgumentException("numbers is null or empty");
		}
		
		double maximum= Double.MIN_VALUE;
		for(double number:numbers) {
			maximum=Math.max(maximum, number);
		}
		return maximum;
	}

}
