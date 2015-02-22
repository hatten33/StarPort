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
	
	public synchronized CancellableEvent fireEvent(CancellableEvent event) {
		for(Listener l : this.listeners) {
			for(Method m : l.getClass().getMethods()) {
				if(m.isAnnotationPresent(Listener.EventHandler.class)) {
					if(m.getParameterTypes().length == 1) {
						if(m.getParameterTypes()[0].getClass().isAssignableFrom(event.getClass())) {
							try {
								m.invoke(l, event);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
						} else System.out.println("PARAMATER[0] NOT EQUAL TO EVENT CLASS");
					} else System.out.println("PARAMATER TYPES LENGTH TOO LONG!");
				}
			}
		}
		return event;
	}
}
