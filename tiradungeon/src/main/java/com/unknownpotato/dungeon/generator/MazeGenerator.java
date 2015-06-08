package com.unknownpotato.dungeon.generator;

import java.util.Random;
import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Stack;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.enums.Direction;

/**
 * 
 * MazeGenerator is a Consumer that takes in a Level and carves a perfect maze to it.
 * 
 * @author VoxWave
 *
 */
public class MazeGenerator implements Consumer<Level> {
	
	/**
	 * the random generator that the generator uses.
	 */
	private Random rand;
	
	private Vec2 startPos;
	
	/**
	 * Creates a maze generator that starts its carving from the specified coordinates.
	 * @param x
	 * @param y
	 */
	public MazeGenerator(int x, int y) {
		this.rand = new Random();
		startPos = new Vec2(x,y);
	}

	public Vec2 getStartPos() {
		return startPos;
	}

	public void setStartPos(Vec2 startPos) {
		this.startPos = startPos;
	}

	/**
	 * Carves a perfect maze.
	 * @param level
	 */
	@Override
	public void accept(Level level) {
		Stack<Vec2> stack = new Stack<>();
		stack.push(startPos);
		long seed = rand.nextLong();
		int n = 0;
		while(!stack.isEmpty()){
			Vec2 cur = stack.pop();
			Tile tile = level.getTile(cur);
			if(tile.getType() == TileType.VOID || tile.getType() == TileType.FLOOR){
				continue;
			}
			
			Stack<Vec2> neighbours = getNeighbours(level, cur);
			if(neighbours == null) continue;
			
			if(n%1 == 0) seed = rand.nextLong();
			n++;
			Random r = new Random(seed);
			neighbours.scramble(r);
			while(!neighbours.isEmpty()){
				stack.push(neighbours.pop());
			}
			level.getTile(cur).setType(TileType.FLOOR);
		}
	}
	
	/**
	 * Returns all of the neighbours of the tile in coordinates of the Vec2
	 * <p>
	 * This method returns null if more than one neighbour is a floor tile
	 * because more than one floor neighbours mean that removing this tile would open a loop in the maze.
	 * 
	 * @param level
	 * @param cur
	 * @return the coordinates of the neighbours in a stack.
	 */
	protected Stack<Vec2> getNeighbours(Level level, Vec2 cur) {
		Stack<Vec2> neighbours = new Stack<>();
		int floors = 0;
		for(Direction d: Direction.getOrthogonal()){
			Vec2 vec = new Vec2(d.getVec());
			vec.add(cur);
			if(level.getTile(vec).getType() == TileType.FLOOR) floors++;
			if(floors > 1) return null;
			neighbours.push(vec);
		}
		return neighbours;
	}

}
