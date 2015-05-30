package com.unknownpotato.dungeon.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<Integer> stack;
	
	@Before
	public void setUp() {
		this.stack = new Stack<Integer>();
	}
	
	@Test
	public void stackIsEmptyWhenNothingIsAddedTest() {
		assertTrue(this.stack.isEmpty());
	}
	
	@Test
	public void emptyStackReturnsNullWhenPoppedTest() {
		assertEquals(null, this.stack.pop());
	}
	
	@Test
	public void stackIsNotEmptyWhenSomethingIAddedTest() {
		this.stack.push(1);
		assertFalse(this.stack.isEmpty());
	}
	
	@Test
	public void stackIsEmptyAndReturnsTheCorrectValueAfterRemovingAnItem() {
		this.stack.push(1);
		assertEquals("stack did not return what was pushed into it.", 1, (int)this.stack.pop());
		assertTrue(this.stack.isEmpty());
	}
	
	@Test
	public void stackIsEmptyAndReturnsTheCorrectValuesAfterRemovingSeveralItems() {
		this.stack.push(1);
		this.stack.push(2);
		this.stack.push(3);
		this.stack.push(4);
		this.stack.push(5);
		this.stack.push(6);
		this.stack.push(7);
		this.stack.push(8);
		this.stack.push(9);
		this.stack.push(10);
		
		assertEquals(10,(int)this.stack.pop());
		assertEquals(9,(int)this.stack.pop());
		assertEquals(8,(int)this.stack.pop());
		assertEquals(7,(int)this.stack.pop());
		assertEquals(6,(int)this.stack.pop());
		assertEquals(5,(int)this.stack.pop());
		assertEquals(4,(int)this.stack.pop());
		assertEquals(3,(int)this.stack.pop());
		assertEquals(2,(int)this.stack.pop());
		assertEquals(1,(int)this.stack.pop());
		
		assertTrue(this.stack.isEmpty());
	}

}
