package com.mycompany.rep;

//We could also use the predefined interface Consumer<Event> here 
@FunctionalInterface
public interface Subscriber {
	
	void update(Event event);

}
