package com.mycompany.rep;

import java.util.UUID;

public class Event {
	
	private UUID uuid;
	private EventType eventType;
	private String description;
	
	
	public Event(UUID uuid, EventType eventType, String description) {
		super();
		this.uuid = uuid;
		this.eventType = eventType;
		this.description = description;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Event [eventType=" + eventType + ", description=" + description + "]";
	}

}
