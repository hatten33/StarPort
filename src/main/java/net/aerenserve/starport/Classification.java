package net.aerenserve.starport;

public enum Classification {
	/* Personal */
	SCOUT(1),
	FIGHTER(1),
	
	COURIER(2),
	TRANSPORT(2),
	
	/* Limited */
	PATROL(3),
	SHUTTLE(3),
	
	/* Medium */ 
	YACHT(4),
	CORVETTE(4),
	
	FREIGHTER(5),
	EXPLORER(5),
	
	/* Special */
	SCIENCE(6),

	/* Cruiser */
	HEAVY_CRUISER(7),
	LIGHT_CRUISER(7),

	MISSILE_CRUISER(8),
	
	/* Large */
	LANDING_SHIP(10),
	HOSPITAL(10),
	
	/* Frigate */
	CARGO_FRIGATE(11),
	ASSUALT_FRIGATE(11),
	
	/* Liner */
	DESTROYER(12),
	
	BATTLECRUISER(14),
	
	/* Capital */ 
	CARRIER(16),
	
	BATTLESHIP(17),
	
	DREADNOUGHT(20);
	
	public final int size;
	
	private Classification(int size) {
		this.size = size;
	}

}
