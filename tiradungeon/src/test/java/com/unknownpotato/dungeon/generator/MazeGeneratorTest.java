package com.unknownpotato.dungeon.generator;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Pair;
import com.unknownpotato.dungeon.util.Queue;
import com.unknownpotato.dungeon.util.Stack;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.enums.Direction;

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
		Set<Vec2> visited = new HashSet<Vec2>(); //muista toteuttaa setti jossain vaiheessa
		Queue<Pair<Direction,Vec2>> toBeVisited = new Queue<Pair<Direction, Vec2>>(); 
	}
}
