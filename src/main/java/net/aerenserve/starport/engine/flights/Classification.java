package net.aerenserve.starport.engine.flights;

public enum Classification {
	/* Personal */
	SCOUT(1, 0.40),
	FIGHTER(1, 0.40),
	
	COURIER(2, 0.40),
	TRANSPORT(2, 0.40),
	
	/* Limited */
	PATROL(3, 0.40),
	SHUTTLE(3, 0.40),
	
	/* Medium */ 
	YACHT(4, 0.40),
	CORVETTE(4, 0.40),
	
	FREIGHTER(5, 0.40),
	EXPLORER(5, 0.40),
	
	/* Special */
	SCIENCE(6, 0.05),

	/* Cruiser */
	HEAVY_CRUISER(7, 0.17),
	LIGHT_CRUISER(7, 0.17),

	MISSILE_CRUISER(8, 0.17),
	
	/* Large */
	LANDING_SHIP(10, 0.05),
	HOSPITAL(10, 0.05),
	
	/* Frigate */
	CARGO_FRIGATE(11, 0.10),
	ASSUALT_FRIGATE(11, 0.10),
	
	/* Liner */ 
	DESTROYER(12, 0.10),
	
	BATTLECRUISER(14, 0.10),
	
	/* Capital */ //3%
	CARRIER(16, 0.03),
	
	BATTLESHIP(17, 0.03),
	
	DREADNOUGHT(20, 0.03);
	
	public final int size;
	public final double rarity;
	
	private Classification(int size, double rarity) {
		this.size = size;
		this.rarity = rarity;
	}

}
