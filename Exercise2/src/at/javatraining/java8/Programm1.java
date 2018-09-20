package at.javatraining.java8;

import java.util.ArrayList;
import java.util.List;

public class Programm1 {
	private List<ProgrammStep> steps = new ArrayList<>();
	
	public Programm1 add(ProgrammStep step) {
		steps.add(step);
		return this;
	}
	
	public void execute() {
		steps.forEach(step -> step.executeStep());
		// "reset" the list - optional!
		steps.clear();
	}
}