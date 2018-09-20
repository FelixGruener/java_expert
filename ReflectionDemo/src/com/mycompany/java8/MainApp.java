package com.mycompany.java8;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MainApp {

	//argument : simple - use CalculatorSimpleImpl --class <className>
	//argument : extended - use CalculatorExtendedImpl
	public static void main(String[] args) throws Exception {
		
		String className = CalculatorSimpleImpl.class.getName();
		
		if (args.length == 1) {
			
			className = args[0];
			
		}
		
		
		
		Calculator calculator = (Calculator) Class.forName(className).newInstance();
		
		System.out.println(calculator.sum(1,2));
		
		System.out.println("class name: " + calculator.getClass().getName());
		
		
		//print name of all methods of calculator object to console
		Method[] methods = calculator.getClass().getDeclaredMethods();
		Arrays.stream(methods)
			.forEach(method->System.out.println(method.getName()));
		
		//TestClass testClass = (TestClass) obj;
		
		//testClass.testMethod();
		
		
		
		
	}

}