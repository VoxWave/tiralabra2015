package com.unknownpotato.dungeon.generator;

import java.util.Random;
import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Box;
import com.unknownpotato.dungeon.util.HashSet;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.enums.Direction;

public class DungeonGenerator implements Consumer<Level> {

	/**
	 * a generator used to carve a maze in the empty spaces between rooms in the level.
	 */
	private MazeGenerator mazeGen;
	/**
	 * a generator used to carve rooms to a level.
	 */
	private RoomGenerator roomGen;
	
	public DungeonGenerator() {
		this.roomGen = new RoomGenerator(4,20, 3, 10000000);
		this.mazeGen = new MazeGenerator(0,0);
	}
	
	/**
	 * creates a roguelike dungeon to the level given as a parameter.
	 */
	@Override
	public void accept(Level level) {
		level.apply(roomGen);
		applyMaze(level);
		createScaryDoors(level);
		while(blockDeadEnds(level));
	}
	
	private void createScaryDoors(Level level) {
		Random rand = new Random();
		for(Box room: roomGen.getRooms()) {
			int wall = rand.nextInt(4);
			if()
		}
	}
	
	/**
	 * Goes through the level, finds all the dead ends and then fills them with wall.
	 * @param level
	 */
	private boolean blockDeadEnds(Level level) {
		HashSet<Vec2> deadends = new HashSet<>();
		for(int y = 0; y<level.getHeight(); y++) {
			for(int x = 0; x<level.getWidth(); x++) {
				Vec2 curPos = new Vec2(x,y);
				if(level.getTile(curPos).getType().equals(TileType.FLOOR) && isDeadend(curPos, level)){
					deadends.add(curPos);
				}
			}
		}
		boolean deadEndWasBlocked = false;
		for(Vec2 pos :deadends) {
			level.getTile(pos).setType(TileType.WALL);
			deadEndWasBlocked = true;
		}
		return deadEndWasBlocked;
	}
	
	private boolean isDeadend(Vec2 curPos, Level level) {
		int walls = 0;
		for(Direction dir: Direction.getOrthogonal()) {
			Vec2 vec = new Vec2(curPos);
			vec.add(dir.getVec());
			
			if(level.getTile(vec).getType().equals(TileType.WALL)) walls++;
		}
		return walls >= 3;
	}

	/**
	 * creates mazes to the level with a mazegenerator.
	 * @param level
	 */
	private void applyMaze(Level level) {
		for(int y = 2; y < level.getHeight()-2; y++){
			for(int x = 2; x < level.getWidth()-2; x++) {
				Vec2 curPos = new Vec2(x,y);
				if(surroundedByWall(curPos, level)) {
					mazeGen.setStartPos(curPos);
					level.apply(mazeGen);
					return;
				}
			}
		}
	}
	
	/**
	 * checks if a tile at curPos coordinates is surrounded by walls.
	 * @param curPos
	 * @param level
	 * @return
	 */
	private boolean surroundedByWall(Vec2 curPos, Level level) {
		for(Direction dir: Direction.values()){
			if(level.getTile(new Vec2(curPos).add(dir.getVec())).getType() != TileType.WALL) return false;
		}
		return true;
	}

}
