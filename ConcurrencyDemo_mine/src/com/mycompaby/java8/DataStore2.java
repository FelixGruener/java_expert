package com.mycompaby.java8;

import java.util.ArrayList;
import java.util.List;

/*create a new Java project "ConcurrencyDemo"
write a class DataStore (singleton!) which uses a List<String> for storing names, it provides 
the following methods: addName, removeName, getNames - returns the whole list
write a class MainApp, create an instance of DataStore and add some names to list
execute two Runnables using an ExecutorService (use at least 2 threads)
 - runnable1 should call getNames() and iterates over list (add some sleeps)
 - runnable2 should call removeName()
what happens?
DEMO
solution with CopyOnWriteList
solution with synchronized
solution with ReentrantReadWriteLock*/

public class DataStore2 {
	
	List<String> names = new ArrayList<>();
	
	
	private DataStore2() {}

	//Singleton needs private Konstruktor
	private DataStore2(List<String> names) {
		super();
		this.names = names;
	}
	
	
	private static final DataStore2 INSTANCE = new DataStore2();

	public static DataStore2 getInstance() {
		return INSTANCE;
	}
	
	
	public List<String> getNames() {
		return names;
	}


	
	public synchronized DataStore2 addName(String name) {
		System.out.println("Add Name");
		names.add(name);
		return this;
		
	}
	
	public synchronized DataStore2 removeName(String name) {
		System.out.println("Remove Name");
		names.remove(name);
		return this;
	}
	
	
	
	
	
	

}
