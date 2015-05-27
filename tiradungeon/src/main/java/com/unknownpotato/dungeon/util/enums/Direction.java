package com.unknownpotato.dungeon.util.enums;

import com.unknownpotato.dungeon.util.Vec2;

public enum Direction {
	UP(0,1), DOWN(0,-1), LEFT(-1,0), RIGHT(1,0), NONE(0,0);
	
	private final Vec2 vec;

	Direction(int x, int y) {
		this.vec = new Vec2(x,y);
	}

	public Vec2 getVec() {
		return vec;
	}
	
	public Vec2 getOppositeVec() {
		return new Vec2(-vec.getX(), -vec.getY());
	}
}
