package com.mycompany.rep;

public class ConsoleSubscriber implements Subscriber {
	
	private String subscriberId;

	public ConsoleSubscriber(String id) {
		super();
		this.subscriberId = id;
	}

	@Override
	public void update(Event event) {
		System.out.println(subscriberId + ":" + event);	
	}
	

}
