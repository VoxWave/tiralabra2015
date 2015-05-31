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
		private Node<T> next;
		private Node<T> previous;
		private T value;
		
		public Node(T value) {
			this.value = value;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public Node<T> getPrev() {
			return previous;
		}
		
		public T getValue() {
			return value;
		}
		
		public void setNext(Node<T> node) {
			next = node;
		}
		
		public void setPrev(Node<T> node) {
			previous = node;
		}
		
		public void setValue(T data) {
			value = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public Queue() {
		
	}

	public void enqueue(T t) {
		if(this.first == null){
			this.first = new Node<T>(t);
			return;
		}
		Node<T> prevFirst = this.first;
		this.first = new Node<T>(t);
		
		prevFirst.setPrev(this.first);
		this.first.setNext(prevFirst);
		
		if(this.last == null) {
			this.last = this.first.getNext();
		}
	}
	
	public T dequeue() {
		if(this.last == null && this.first == null) {
			return null;
		} else if (this.last == null) {
			T toBeReturned = this.first.getValue();
			this.first = null;
			return toBeReturned;
		}
		Node<T> toBeReturned = this.last;
		this.last = this.last.getPrev();
		this.last.setNext(null);
		if(this.first == this.last) this.last = null;
		return toBeReturned.getValue();
	}

	public boolean isEmpty() {
		return this.first == null && this.last == null;
	}

}
