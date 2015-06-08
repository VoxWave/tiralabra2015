package com.unknownpotato.dungeon.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class HashSetTest {
	
	private HashSet<String> set;
	private String txt;

	@Before
	public void setUp() {
		this.set = new HashSet<>();
		this.txt = "Bacon ipsum dolor amet shoulder salami tri-tip ham hock meatloaf.";
	}

	@Test
	public void doesNotContainNonAddedElementTest() {
		assertFalse(set.contains(txt));
	}
	
	@Test
	public void doesContainAddedElementTest() {
		assertTrue(set.add(txt));
		assertTrue(set.contains(txt));
	}
	
	@Test
	public void addingOverEightElementsWorks() {
		for(int i = 0; i<10; i++){
			assertTrue(set.add(""+i));
		}
		for(int i = 0; i<10; i++) {
			assertTrue(set.contains(""+i));
		}
	}

}
