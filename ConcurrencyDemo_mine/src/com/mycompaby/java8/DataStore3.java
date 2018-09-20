package com.mycompaby.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

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

public class DataStore3 {
	
	List<String> names = new ArrayList<>();
	
	//n reader but no writer at same time 
	//1 writer but no reader at same time 
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	private DataStore3() {}

	//Singleton needs private Konstruktor
	private DataStore3(List<String> names) {
		super();
		this.names = names;
	}
	
	
	private static final DataStore3 INSTANCE = new DataStore3();

	public static DataStore3 getInstance() {
		return INSTANCE;
	}
	
	
	public List<String> getNames() {
		return names;
	}


	//WRITE
	public  DataStore3 addName(String name) {
		System.out.println("Add Name");
		rwLock.writeLock().lock();
		names.add(name);
		rwLock.writeLock().unlock();
		return this;
		
	}
	
	//the problem is that also READ accesses (could be executed conurrently
	//Are synchronized 
	public DataStore3 removeName(String name) {
		System.out.println("Remove Name");
		names.remove(name);
		return this;
	}
	
	
	
	public void printNames() {
		System.out.println("prinTNAmes");
		rwLock.readLock().lock();
		names.forEach(name->{
			System.out.println("  " + name);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		rwLock.readLock().unlock();
	}
	public void processNames(Consumer<String> action) {
		System.out.println("prinTNAmes");
		rwLock.readLock().lock();
		names.forEach(name->{
			action.accept(name);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		rwLock.readLock().unlock();
	}
	
	
	
	

}
