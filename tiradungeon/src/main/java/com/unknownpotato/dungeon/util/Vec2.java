package com.unknownpotato.dungeon.util;

public class Vec2 {

	private int x;
	private int y;

	public Vec2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vec2(Vec2 vec) {
		this(vec.x, vec.y);
	}

	public Vec2() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Vec2 add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vec2 add(Vec2 cur) {
		return add(cur.x, cur.y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Vec2 other = (Vec2) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}



}
