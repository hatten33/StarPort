package net.aerenserve.starport.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventCoordinator {
	
	private List<Listener> listeners;
	
	public EventCoordinator() {
		this.listeners = new ArrayList<Listener>();
	}
	
	public synchronized void addListener(Listener listener) {
		this.listeners.add(listener);
	}
	
	public synchronized void removeListener(Listener listener) {
		this.listeners.remove(listener);
	}
	
	public synchronized Event fireEvent(Event event) {
		for(Listener l : this.listeners) {
			for(Method m : l.getClass().getMethods()) {
				if(m.isAnnotationPresent(Listener.EventHandler.class)) {
					try {
						m.invoke(l, event);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return event;
	}
}
