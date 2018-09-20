package at.javatraining.java8;

import java.util.ArrayList;
import java.util.List;

public class Programm2 {
	private List<Runnable> steps = new ArrayList<>();
	
	public Programm2 add(Runnable step) {
		steps.add(step);
		return this;
	}
	
	public void execute() {
		steps.forEach(step -> step.run());
		// "reset" the list - optional!
		steps.clear();
	}
}