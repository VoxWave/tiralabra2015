package com.unknownpotato.dungeon.generator;

import java.util.Random;
import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.Box;
import com.unknownpotato.dungeon.util.HashSet;

public class RoomGenerator implements Consumer<Level> {
	
	private Random randX;
	private Random randY;
	
	private int maxRoomSize;
	private int minRoomSize;
	private int roomDistance;
	private int attempts;

	public RoomGenerator(int minRoomSize, int maxRoomSize, int roomDistance, int attempts) {
		this.randX = new Random();
		this.randY = new Random();
		this.minRoomSize = minRoomSize;
		this.maxRoomSize = maxRoomSize;
		this.roomDistance = roomDistance;
		this.attempts = attempts;
	}

	@Override
	public void accept(Level level) {
		HashSet<Box> rooms = new HashSet<>();
		for(int i = 0; i < attempts; i++) {
			Box room = generateBox(level);
			
			boolean fits = !checkCollision(rooms, room);
			if(fits) rooms.add(room);
		}
		
		carve(level, rooms);
	}

	private boolean checkCollision(HashSet<Box> rooms, Box room) {
		for(Box box: rooms) {
			if(room.overlaps(box)) {
				return true;
			}
		}
		return false;
	}

	private Box generateBox(Level level) {
		Vec2 min = new Vec2(randX.nextInt(level.getWidth()), randY.nextInt(level.getHeight()));
		
		Vec2 max = new Vec2(min).add(randX.nextInt(maxRoomSize-minRoomSize)+minRoomSize, randY.nextInt(maxRoomSize-minRoomSize)+minRoomSize);
		max.add(roomDistance, roomDistance);
		
		Box room = new Box(min, max);
		return room;
	}

	private void carve(Level level, HashSet<Box> rooms) {
		for(Box room: rooms) {
			for(int y = room.getMin().getY(); y<=room.getMax().getY()-roomDistance; y++) {
				for(int x = room.getMin().getX(); x<=room.getMax().getX()-roomDistance; x++) {
					level.getTile(x, y).setType(TileType.FLOOR);
				}	
			}
		}
	}

}
