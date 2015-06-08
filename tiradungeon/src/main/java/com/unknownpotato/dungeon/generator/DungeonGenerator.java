package com.unknownpotato.dungeon.generator;

import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.enums.Direction;

public class DungeonGenerator implements Consumer<Level> {

	private MazeGenerator mazeGen;
	private RoomGenerator roomGen;
	
	public DungeonGenerator() {
		this.roomGen = new RoomGenerator(4,20, 3, 10000000);
		this.mazeGen = new MazeGenerator(0,0);
	}
	
	@Override
	public void accept(Level level) {
		level.apply(roomGen);
		applyMaze(level);
		createScaryDoors(level);
	}
	private void createScaryDoors(Level level) {
		
	}
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
	private boolean surroundedByWall(Vec2 curPos, Level level) {
		for(Direction dir: Direction.values()){
			if(level.getTile(new Vec2(curPos).add(dir.getVec())).getType() != TileType.WALL) return false;
		}
		return true;
	}

}
