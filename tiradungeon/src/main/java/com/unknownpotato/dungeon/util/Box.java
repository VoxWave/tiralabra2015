package com.unknownpotato.dungeon.util;

/**
 * Box is a class used for RoomGenerator. It represents a rectangle with two points.
 * @author VoxWave
 *
 */
public class Box {
	private Vec2 min;
	private Vec2 max;
	
	/**
	 * Creates a box which begins from min point and ends in the max point.
	 * <p>
	 * both of mins x and y values must be smaller than maxes corresponding value or else the collision detection (overlaps() method) will break.
	 * @param min 
	 * @param max
	 */
	public Box(Vec2 min, Vec2 max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * returns the minimum point of the box.
	 * @return
	 */
	public Vec2 getMin() {
		return this.min;
	}
	
	/**
	 * returns the maximum point of the box.
	 * @return
	 */
	public Vec2 getMax() {
		return this.max;
	}

	/**
	 * checks if this box and another box (given as a parameter) collide. 
	 * @param another
	 * @return
	 */
	public boolean overlaps(Box another) {
		if (this.getMin().getX() > another.getMax().getX()
				|| another.getMin().getX() > this.getMax().getX()) {
			if (this.getMin().getY() > another.getMax().getY()
					|| another.getMin().getY() > this.getMax().getY()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return ("("+min.getX()+", "+min.getY()+"), ("+max.getX()+", "+max.getY()+")").hashCode();
	}
	
	public boolean equals(Box comp) {
		return this.min.equals(comp.min) && this.max.equals(comp.max);
	}
	
}