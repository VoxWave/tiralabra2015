package com.unknownpotato.dungeon.util;

import java.util.Iterator;

public class HashSet<T> implements Iterable<T> {

	private T[] data;
	private final double threshold;
	private int curSize;
	
	@SuppressWarnings("unchecked")
	public HashSet() {
		this.data = (T[]) new Object[8];
		this.threshold = 0.75;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean add(T obj) {
		if(threshold * data.length < curSize) {
			grow();
		}
		int index = mod(obj.hashCode());
		while(data[index] != null) {
			if(data[index].equals(obj)){
				return false;
			}
			index = mod(index + 1);
		}
		data[index] = obj;
		return true;
	}

	private void grow() {
		// TODO Auto-generated method stub
		
	}
	
	private int mod(int n) {
		if(n < 0) {
			return n % data.length+data.length;
		}
		return n % data.length;
	}

}
