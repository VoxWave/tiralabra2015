package com.unknownpotato.dungeon.generator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.unknownpotato.dungeon.Level;

public class RoomGeneratorTest {

	private Level level;
	
	@Before
	public void setUp() throws Exception {
		this.level = new Level(64, 64);
	}

}
