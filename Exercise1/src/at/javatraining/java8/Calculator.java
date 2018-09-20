package at.javatraining.java8;

public class Calculator {
	private Operation operation;
	
	public Calculator(Operation operation) {
		this.operation = operation;
	}
	
	public int calculate(int number1, int number2) {
		return operation.operate(number1, number2);
	}
}