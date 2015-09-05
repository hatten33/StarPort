package net.aerenserve.starport.engine.architecture;

public class Dock {
	
	public enum DockSize {
		PERSONAL(1, 2),
		LIMITED(3, 3),
		MEDIUM(4, 5),
		SPECIAL(6, 6),
		CRUISER(7, 9),
		LARGE(10, 10),
		FRIGATE(11, 11),
		LINER(12, 15),
		CAPITAL(16, 25);
		
		public final int minSize;
		public final int maxSize;
		
		private DockSize(int minSize, int maxSize) {
			this.minSize = minSize;
			this.maxSize = maxSize;
		}
	}
	
	public final DockSize size;

	public Dock(DockSize size) {
		this.size = size;
	}
	
}
