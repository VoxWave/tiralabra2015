package com.unknownpotato.dungeon.util.enums;

import com.unknownpotato.dungeon.util.Vec2;

public enum Direction {
	UP(0,1), DOWN(0,-1), LEFT(-1,0), RIGHT(1,0), NONE(0,0), UR(1,1), DR(1,-1), DL(-1,-1), UL(-1,1);
	
	private final Vec2 vec;
	private static final Direction[] DIAGONAL = {UR, DR, DL, UL};
	private static final Direction[] ORTHOGONAL = {UP, DOWN, LEFT, RIGHT};

	Direction(int x, int y) {
		this.vec = new Vec2(x,y);
	}

	public Vec2 getVec() {
		return vec;
	}
	
	public Vec2 getOppositeVec() {
		return new Vec2(-vec.getX(), -vec.getY());
	}

	public static Direction[] getOrthogonal() {
		return ORTHOGONAL;
	}
	
	public static Direction[] getDiagonal() {
		return DIAGONAL;
		
	}
}
