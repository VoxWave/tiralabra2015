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
		return (x + ", " + y).hashCode();
	}

	public boolean equals(Vec2 comp) {
		return this.x == comp.x && this.y == comp.y;
	}

}
