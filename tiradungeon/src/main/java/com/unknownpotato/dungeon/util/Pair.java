package com.unknownpotato.dungeon.util;

public class Pair<T1,T2> {
	private T1 right;
	private T2 left;

	public Pair(T1 right, T2 left) {
		this.right = right;
		this.left = left;
	}
	
	public T1 getRight() {
		return right;
	}
	
	public T2 getLeft() {
		return left;
	}
}
