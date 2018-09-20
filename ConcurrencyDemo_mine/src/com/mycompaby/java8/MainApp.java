package com.mycompaby.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

	public static void main(String[] args) {
		
		/*String a = "abc";
		String b = "abc";
		String c = "ab";
		String d = "c";
		String e = c + d;
		
		if(a==b) {
			System.out.println("a/b => SAME OBJECT"); //YES
		}
		if (a==e) {
			System.out.println("a/e => SAME OBJECT"); //NO
		}*/
		
		//ArrayList is not ThreadSafe 
		//Classic for forEech Loop will use Iterator , remove and add at same moment = > Exception 
		
		//One Solution use ThreadSafe DataStructure 
		
		DataStore ds = DataStore.getInstance();
		ds.addName("Max")
			.addName("Moritz")
			.addName("Susi");
		
		//Iteration and remove at the same time , therwise no effect 
		
		//1st ruable should call getNames() and iterates over list
		Runnable reader = () -> {
			
			ds.getNames().stream().forEach(name->sleep(1000));
		};
		
		//2nd runnable should call removeNames()
		Runnable writer = () -> {
			sleep(1000);
			ds.removeName("Max");
		};
		
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(reader);
		es.execute(writer);
		
		//What happens
		
		es.shutdown();
		
	}
	
	private static void sleep(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (Exception ignored){
			
		}
	}

}