package net.aerenserve.starport.engine.location;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Coordinate {
	
	protected double x;
	protected double y;
	protected double z;
	
	public Coordinate(double x, double y, double z) {
		this.x = round(x);
		this.y = round(y);
		this.z = round(z);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double getDistance(Coordinate co) {
		return Math.sqrt(Math.pow((this.x - co.x), 2) + Math.pow((this.y - co.y), 2) + Math.pow((z - co.z), 2));
	}
	
	@Override
	public String toString() {
		return x + "," + y + "," + z;
	}
	
	public static double round(double value) {
		return new BigDecimal(value).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}
	
	public double[] toArray() {
		double[] ret = {x,y,z};
		return ret;
	}
}
	
