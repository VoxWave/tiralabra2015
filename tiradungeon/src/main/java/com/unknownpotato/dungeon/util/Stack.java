package com.unknownpotato.dungeon.util;

import java.util.Arrays;
import java.util.Random;

public class Stack<T> {
	protected T[] data;
	private int top;
	
	public Stack() {
		data = (T[])new Object[8];
		top = 0;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void push(T obj){
		if(top == data.length) {
			grow();
		}
		data[top] = obj;
		top++;
	}
	
	public T pop() {
		if(isEmpty()){
			return null;
		}
		top--;
		T t = data[top];
		data[top] = null;
		return t;
	}
	
	public void scramble(Random rand) {
		for(int i = top;i>1;i--){
			int num = rand.nextInt(i);
			T t = data[i-1];
			data[i-1] = data[num];
			data[num] = t;
		}
	}
	
	protected void grow(){
		T[] n = (T[])new Object[data.length*2];
		for(int i = 0; i<data.length; i++) {
			n[i] = data[i];
		}
		data = n;
	}
}
