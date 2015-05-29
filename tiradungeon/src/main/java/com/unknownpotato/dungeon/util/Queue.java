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
	/**
	 * Nodes are used as a building block for the Queue.
	 * 
	 * @author VoxWave
	 *
	 * @param <T>
	 */
	class Node<T> {
		private Node next;
		private Node previous;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public Node getNext() {
			return next;
		}
		
		public Node getPrev() {
			return previous;
		}
		
		public T getValue() {
			return value;
		}
		
		public void setNext(Node node) {
			next = node;
		}
		
		public void setPrev(Node node) {
			previous = node;
		}
		
		public void setValue(T data) {
			value = data;
		}
	}
	
	private Node first;
	private Node last;
	
	public Queue() {
		
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
