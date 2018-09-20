package com.mycompany.java8;

import java.util.Arrays;

public class CalculatorExtendedImpl implements Calculator{

	@Override
	public int sum(int... numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("numbers must not be null");
			
		}
		return Arrays.stream(numbers).sum();
	}

}
