package com.unknownpotato.dungeon.util;

/**
 * Box is a class used for RoomGenerator. It represents a rectangle with two
 * points.
 * 
 * @author VoxWave
 *
 */
public class Box {
	private final Vec2 min;
	private final Vec2 max;

	/**
	 * Creates a box which begins from min point and ends in the max point.
	 * <p>
	 * both of mins x and y values must be smaller than maxes corresponding
	 * value or else the collision detection (overlaps() method) will break.
	 * 
	 * @param min
	 * @param max
	 */
	public Box(Vec2 min, Vec2 max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * returns the minimum point of the box.
	 * 
	 * @return
	 */
	public Vec2 getMin() {
		return this.min;
	}

	/**
	 * returns the maximum point of the box.
	 * 
	 * @return
	 */
	public Vec2 getMax() {
		return this.max;
	}

	/**
	 * checks if this box and another box (given as a parameter) collide.
	 * 
	 * @param another
	 * @return
	 */
	public boolean overlaps(Box another) {
		Vec2 thisMin = this.getMin();
		Vec2 thisMax = this.getMax();
		Vec2 thatMin = another.getMin();
		Vec2 thatMax = another.getMax();

		if (thisMin.getX() > thatMax.getX() || thatMin.getX() > thisMax.getX()) {
			return false;
		}

		if (thisMin.getY() > thatMax.getY() || thatMin.getY() > thisMax.getY()) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		return true;
	}

}