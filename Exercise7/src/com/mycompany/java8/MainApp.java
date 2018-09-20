package com.mycompany.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class MainApp {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>(1000);
		
		for (int i = 0; i < 1000; i++) {
			numbers.add(ThreadLocalRandom.current().nextInt(0, 101));
		}
		
		
		
		numbers.removeIf(number -> number%2==0 && number > 50);
		
		//another one 
		Predicate<Integer> isEven = number -> number%2 == 0;
		Predicate<Integer> isLargerThan50 = number -> number >  50;
		
		numbers.removeIf(isEven.and(isLargerThan50));
		
		
		//numbers.forEach(System.out::println);
		
		//stream Version 
		
		ThreadLocalRandom.current().ints(1000, 0, 101) //creates Stream
				.filter(number -> !(number%2==0 && number > 50)) //intermediate Operations
				.forEach(System.out::println); //return result and terminate Stream
		
		

	}

}
