package net.aerenserve.starport.engine.location;


public class LocationCoordinate extends Coordinate {

	public LocationCoordinate(double x, double y, double z) {
		super(x, y, z);
	}
	
	public double addX(double toAdd) {
		return setX(getX() + toAdd);
	}
	
	public double setX(double x) {
		this.x = x;
		return getX();
	}
	
	public double addY(double toAdd) {
		return setY(getY() + toAdd);
	}
	
	public double setY(double y) {
		this.y = y;
		return getY();
	}
	
	public double addZ(double toAdd) {
		return setZ(getZ() + toAdd);
	}
	
	public double setZ(double z) {
		this.z = z;
		return getZ();
	}
}
