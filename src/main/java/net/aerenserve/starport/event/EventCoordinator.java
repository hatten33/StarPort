package net.aerenserve.starport.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.aerenserve.starport.event.listener.EventHandler;
import net.aerenserve.starport.event.listener.Listener;

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
			for(Method m : l.getClass().getDeclaredMethods()) {
				if(m.isAnnotationPresent(EventHandler.class)) {
					if(m.getParameterTypes().length == 1) {
						if(m.getParameterTypes()[0].isAssignableFrom(event.getClass())) {
							try {
								m.invoke(l, event);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return event;
	}
}
