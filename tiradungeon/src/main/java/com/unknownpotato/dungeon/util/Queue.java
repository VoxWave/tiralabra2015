package com.unknownpotato.dungeon.util;

import com.unknownpotato.dungeon.util.enums.Direction;

/**
 * This is an imple
 * 
 * @author VoxWave
 *
 * @param <T>
 */
public class Queue<T> {
	
	class Node<T> {
		private Node next;
		private Node previous;
		private T value;
		
		
	}
	
	private T[] data;
	private Node first;
	private Node last;
	
	public Queue() {
		data = (T[])new Object[8];
		
	}

	public void enqueue(T t) {
		// TODO Auto-generated method stub
		
	}
	
	public T dequeue() {
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
