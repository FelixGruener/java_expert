package com.mycompany.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Extractor {
	
	public static void extractAndPrint(Function<Person, ?> function, Person person) {
		System.out.println(function.apply(person));
	}
	
	public static Person set(BiFunction<Person, String, Person> consumer, Person person, String value) {
		return consumer.apply(person,value);
	}

}
