package com.unknownpotato.dungeon.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashSet<T> implements Iterable<T> {

	/**
	 * the iterator of the hashset.
	 * @author voxwave
	 *
	 */
	private class HashSetIterator implements Iterator<T> {
		private int index;
		
		private HashSetIterator() {
			
			getNextIndex();
		}

		@Override
		public boolean hasNext() {
			return index < data.length;
		}

		@Override
		public T next() {
			if(hasNext()){
				T elem = data[index];
				index++;
				getNextIndex();
				return elem;
			}
			throw new NoSuchElementException();
		}
		
		private void getNextIndex(){
			while(index < data.length && data[index] == null){
				index++;
			}
		}

	}

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
		return new HashSetIterator();
	}
	
	private int findIndex(T obj, T[] array) {
		int index = mod(obj.hashCode(), array.length);
		while(array[index] != null) {
			if(array[index].equals(obj)) {
				return index;
			}
			index = mod(index + 1, array.length);
		}
		return -index-1;
	}
	
	/**
	 * test if the HashSet contains element equal to obj.
	 * @param obj
	 * @return
	 */
	public boolean contains(T obj) {
		return findIndex(obj, data) >= 0;
	}
	
	/**
	 * Adds an object to the HashSet.
	 * <p>
	 * this method returns true if the object was added and false if the object was already in the set.
	 * @param obj
	 * @return
	 */
	public boolean add(T obj) {
		if(threshold * data.length < curSize) {
			grow();
		}
		if(add(obj, data)) {
			curSize++;
			return true;
		}
		return false;
	}
	
	private boolean add(T obj, T[] array) {
		int index = findIndex(obj, array);
		if(index >= 0) {
			return false;
		}
		array[-index - 1] = obj;
		return true;
	}

	/**
	 * increases the size of the internal array of the HashSet
	 */
	private void grow() {
		@SuppressWarnings("unchecked")
		T[] newData = (T[]) new Object[data.length*2];
		for(T obj: this) {
			add(obj, newData);
		}
		data = newData;
	}
	
	/**
	 * returns the modulo of n over m
	 * @param n
	 * @param m
	 * @return
	 */
	private int mod(int n, int m) {
		if(n < 0) {
			return n % m + m;
		}
		return n % m;
	}

}
