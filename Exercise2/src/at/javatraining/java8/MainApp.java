package at.javatraining.java8;

public class MainApp {
	public static void main(String[] args) {
		new Programm1()
			// concrete class
			.add(new WriteToConsoleProgrammStep("I'm the first programm step"))
			// anonymous inner class
			.add(new ProgrammStep() {
				@Override
				public void executeStep() {
					System.out.println("I'm the second programm step");
				}
			})
			// Lambda expression			
			.add(() -> System.out.println("I'm the third programm step"))
			.execute();
		
		new Programm2()
			// concrete class
			.add(new WriteToConsoleProgrammStep("I'm the first programm step"))
			// anonymous inner class
			.add(new Runnable() {
				@Override
				public void run() {
					System.out.println("I'm the second programm step");
				}
			})
			// Lambda expression			
			.add(() -> System.out.println("I'm the third programm step"))
			.execute();
	}
}