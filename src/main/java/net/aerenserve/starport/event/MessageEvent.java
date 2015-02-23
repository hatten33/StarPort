package net.aerenserve.starport.event;

public class MessageEvent implements Event {

	private final String message;
	
	public MessageEvent(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
