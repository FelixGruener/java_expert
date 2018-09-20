package at.javatraining.java8;

// class implements both interfaces so that we can use for Programm1 and Programm2
public class WriteToConsoleProgrammStep implements ProgrammStep, Runnable {
	private String info;

	public WriteToConsoleProgrammStep(String info) {
		this.info = info;
	}

	@Override
	public void executeStep() {
		System.out.println(info);
	}
	
	@Override
	public void run() {
		executeStep();
	}
}