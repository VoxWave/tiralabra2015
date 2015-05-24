package com.unknownpotato.dungeon;

import static org.junit.Assert.assertEquals;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.unknownpotato.dungeon.Tile.TileType;

public class LevelTest {
	
	private Level level;
	
	@Before
	public void setUp() {
		level = new Level(64,64);
	}

	
	@Test
	public void levelIsInitializedWithRockTest() {
		for(int y = 0; y < level.getHeight(); y++) {
			for(int x = 0; x < level.getWidth(); x++) {
				assertEquals("tile at "+x+","+y+" is not wall", TileType.WALL, level.getTile(x,y).getType());
			}
		}
	}
	
	@Test
	public void voidTileIsReturnedWhenOutOfBoundsTest() {
		assertEquals("-1, -1 does not return a void tile", TileType.VOID, level.getTile(-1, -1).getType());
		assertEquals("getwidth, -1", TileType.VOID, level.getTile(level.getWidth(), -1).getType());
		assertEquals("-1, getHeight does not return a void tile", TileType.VOID, level.getTile(-1, level.getHeight()).getType());
		assertEquals("getWidth, getHeight does not return a void tile", TileType.VOID, level.getTile(level.getWidth(), level.getHeight()).getType());
	}
	
}
