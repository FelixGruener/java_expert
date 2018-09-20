package com.mycompany.rep;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
	
	private List<Subscriber> subscribers = new ArrayList<>();
	
	
	//we are using the chaining pattern here, so you can call ..subscribe(X).subscribe(Y)...
	//register expects subscriber and subscriber is FunctionalInterface = > you can use Lambda
	public EventProcessor register(Subscriber subscriber) {
		subscribers.add(subscriber);
		return this;
		
	}
	
	public EventProcessor unregister(Subscriber subscriber) {
		subscribers.remove(subscriber);
		return this;
		
	}
	
	public EventProcessor publish(Event event) {
		subscribers.forEach(subscriber -> subscriber.update(event));
		return this;
	}
	
	
	
	
}
