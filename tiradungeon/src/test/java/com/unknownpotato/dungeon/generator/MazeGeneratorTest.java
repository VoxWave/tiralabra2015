package com.unknownpotato.dungeon.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Stack;
import com.unknownpotato.dungeon.util.Vec2;

public class MazeGeneratorTest {
	private Level level;
	
	@Before
	public void setUp() {
		level = new Level(64,64);
	}
	
	@Test
	public void doesNotDoAnythingToTheLevelIfOutOfBounds(){
		MazeGenerator gen = new MazeGenerator(-1,-1);
		level.apply(gen);
		for(int y = 0; y < level.getHeight(); y++) {
			for(int x = 0; x < level.getWidth(); x++) {
				assertEquals("tile at "+x+","+y+" is not wall", TileType.WALL, level.getTile(x,y).getType());
			}
		}
	}
	
	@Test
	public void generatorGeneratesAPerfectMaze(){
		MazeGenerator gen = new MazeGenerator(0,0);
		level.apply(gen);
		Stack<Vec2> visited;
	}
}
