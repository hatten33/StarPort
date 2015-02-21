package net.aerenserve.starport;

public enum Classification {
	SCOUT(1),
	FIGHTER(1),
	
	COURIER(2),
	TRANSPORT(2),
	
	PATROL(3),
	SHUTTLE(3),
	
	YACHT(4),
	CORVETTE(4),
	
	FREIGHTER(5),
	EXPLORER(5),
	
	SCIENCE(6),

	HEAVY_CRUISER(7),
	LIGHT_CRUISER(7),

	MISSILE_CRUISER(8),
	
	LANDING_SHIP(10),
	HOSPITAL(10),
	
	CARGO_FRIGATE(11),
	ASSUALT_FRIGATE(11),
	
	DESTROYER(12),
	
	BATTLECRUISER(14),
	
	CARRIER(16),
	
	BATTLESHIP(17),
	
	DREADNOUGHT(20);
	
	public final int size;
	
	private Classification(int size) {
		this.size = size;
	}

}
