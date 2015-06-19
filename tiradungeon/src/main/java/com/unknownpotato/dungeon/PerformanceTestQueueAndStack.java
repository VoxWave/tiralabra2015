package com.unknownpotato.dungeon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import com.unknownpotato.dungeon.util.Queue;
import com.unknownpotato.dungeon.util.Stack;

public class PerformanceTestQueueAndStack {

	private static void jvmWarmup() {
		System.gc();
		for(int i = 0; i < 100; i++) {
			dequePushBenchmark(i+1*100, i);
			stackPushBenchmark(i+1*100, i);
		}
		System.gc();
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		long seed = rand.nextLong();
		int iterations = 2000000; //muutan tätä riviä ja otan ohjelman tulostaman ajan talteen ja piirrän niistä graaffin.
		
		jvmWarmup();
		
		long time = 0;
		for(int i = 0; i < 100; i++){
			time += dequePopBenchmark(iterations, seed);
		}
		System.out.println(time/100.0);
//		System.out.println(dequePushBenchmark(iterations, seed));

		

		
		
	}

	private static long dequePushBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		Deque<Integer> deque = new ArrayDeque<>();
		long startTimedq = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			deque.push(elem);
		}
		long stopTimedq = System.currentTimeMillis();
		long dequeTime = stopTimedq - startTimedq;
		return dequeTime;
	}

	private static long stackPushBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		Stack<Integer> stack = new Stack<>();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			stack.push(elem);
		}
		long stopTime = System.currentTimeMillis();
		long stackTime = stopTime-startTime;
		return stackTime;
	}
	
	private static long stackPopBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			stack.push(elem);
		}
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			stack.pop();
		}
		long stopTime = System.currentTimeMillis();
		long stackTime = stopTime-startTime;
		return stackTime;
	}
	
	private static long dequePopBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			deque.push(elem);
		}
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			deque.pop();
		}
		long stopTime = System.currentTimeMillis();
		long stackTime = stopTime-startTime;
		return stackTime;
	}

}
