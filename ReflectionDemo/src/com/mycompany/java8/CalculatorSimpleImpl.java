package com.mycompany.java8;

import java.util.Arrays;

public class CalculatorSimpleImpl implements Calculator{

	@Override
	public int sum(int... numbers) {
		if (numbers == null || numbers.length !=2) {
			throw new IllegalArgumentException("numbers must not be null");
			
		}
		return numbers[0] + numbers[1];
	}

}
