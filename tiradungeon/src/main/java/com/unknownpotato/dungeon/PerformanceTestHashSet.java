package com.unknownpotato.dungeon;

import java.util.HashSet;
import java.util.Random;

import com.unknownpotato.dungeon.util.Stack;

public class PerformanceTestHashSet {
	
	public static void main(String[] args) {
		int iterations = 250000;
		long seed = 12345;
		jvmWarmup();
		
		long time = 0;
		for(int i = 0; i < 100; i++){
			time += myHashSetAddBenchmark(iterations, seed);
		}
		System.out.println(time/100.0);
	}
	
	private static void jvmWarmup() {
		System.gc();
		for(int i = 0; i < 100; i++) {
			myHashSetAddBenchmark(i+1*100, i);
			javaHashSetAddBenchmark(i+1*100, i);
		}
		System.gc();
	}

	private static long myHashSetAddBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		com.unknownpotato.dungeon.util.HashSet<Integer> set = new com.unknownpotato.dungeon.util.HashSet<>();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			set.add(elem);
		}
		long stopTime = System.currentTimeMillis();
		long stackTime = stopTime-startTime;
		return stackTime;
	}

	private static long javaHashSetAddBenchmark(int iterations, long seed) {
		Random rand = new Random(seed);
		HashSet<Integer> set = new HashSet<>();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < iterations; i++) {
			int elem = rand.nextInt();
			set.add(elem);
		}
		long stopTime = System.currentTimeMillis();
		long stackTime = stopTime-startTime;
		return stackTime;
	}

}
