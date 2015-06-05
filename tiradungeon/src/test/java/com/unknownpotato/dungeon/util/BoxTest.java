package com.unknownpotato.dungeon.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoxTest {
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void partiallyOverlapingBoxesCollideTest() {
		Vec2 min1 = new Vec2(0,0);
		Vec2 max1 = new Vec2(min1).add(5,5);
		Box box1 = new Box(min1, max1);
		
		Vec2 min2 = new Vec2(3,3);
		Vec2 max2 = new Vec2(8,8);
		Box box2 = new Box(min2, max2);
		
		assertTrue(box1.overlaps(box2));
		assertTrue(box2.overlaps(box1));
	}
	
	@Test
	public void completelyOverlapingBoxesCollideTest() {
		Vec2 min = new Vec2(0,0);
		Vec2 max = new Vec2(min).add(5,5);
		Box box1 = new Box(min, max);
		Box box2 = new Box(min, max);
		
		assertTrue(box1.overlaps(box2));
		assertTrue(box2.overlaps(box1));
	}
	
	@Test
	public void nonOverlapingBoxesDoNotCollideTest() {
		Vec2 min1 = new Vec2(0,0);
		Vec2 max1 = new Vec2(min1).add(5,5);
		Box box1 = new Box(min1, max1);
		
		Vec2 min2 = new Vec2(10,10);
		Vec2 max2 = new Vec2(min2).add(8,8);
		Box box2 = new Box(min2, max2);
		
		assertFalse(box1.overlaps(box2));
		assertFalse(box2.overlaps(box1));
	}

}
