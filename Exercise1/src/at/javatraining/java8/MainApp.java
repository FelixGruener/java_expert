package at.javatraining.java8;

public class MainApp {
	public static void main(String[] args) {
		// variant 1: using concrete class for interface Operation
		Calculator calculator1 = new Calculator(new AddOperation());
		System.out.println(calculator1.calculate(1, 2));
		
		// variant 2: using anonymous inner class for interface Operation
		Calculator calculator2 = new Calculator(new Operation() {
			@Override
			public int operate(int number1, int number2) {
				return number1 + number2;
			}
		});
		System.out.println(calculator2.calculate(1, 2));

		// variant 3: using Lambda expression for interface Operation
		/***new Operation() {
		@Override
		public int operate***/
		//know types of parameters int
		//must not be same as operation , can be 
		//one line of code you can remove braces when it returns return can be removed 
		Calculator calculator3 = new Calculator((a, b) -> a + b);
		System.out.println(calculator3.calculate(1, 2));
	
	}
}