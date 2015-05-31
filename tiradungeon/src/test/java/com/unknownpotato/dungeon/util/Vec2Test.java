package com.unknownpotato.dungeon.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Vec2Test {
	private Vec2 origo;
	private Vec2 vec;
	
	@Before
	public void setUp() {
		this.origo = new Vec2();
		this.vec = new Vec2(0, 1);
	}
	
	@Test
	public void anOrigoVectorIsCreatedWhenNoParametersGivenTest() {
		assertEquals(0, this.origo.getX());
		assertEquals(0, this.origo.getY());
	}
	
	@Test
	public void copyingAVectorWorksTest() {
		Vec2 vecCopy = new Vec2(this.vec);
		assertNotSame("vec and vecCopy are the same",vec,vecCopy);
		assertEquals(this.vec, vecCopy);
		assertEquals(vec.hashCode(), vecCopy.hashCode());
	}
	
	@Test
	public void addingPositiveNumbersToAVectorWorksTest() {
		this.vec.add(1,1);
		assertEquals(1, this.vec.getX());
		assertEquals(2, this.vec.getY());
	}
	
	@Test
	public void addingNegativeNumbersToAVectorWorksTest() {
		this.vec.add(-1, -1);
		assertEquals(-1, this.vec.getX());
		assertEquals(0, this.vec.getY());
	}
	
	@Test
	public void addingZeroesDoesNotTheVectorTest() {
		this.vec.add(0, 0);
		assertEquals(0, this.vec.getX());
		assertEquals(1, this.vec.getY());
		this.vec.add(this.origo);
	}
	
}
