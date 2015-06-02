package com.unknownpotato.dungeon.util;

public class Box {
	private Vec2 min;
	private Vec2 b;

	public Box(Vec2 a, Vec2 b) {
		this.min = a;
		this.b = b;
	}

	public Vec2 getMin() {
		return this.min;
	}

	public Vec2 getMax() {
		return this.b;
	}

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
}