package com.unknownpotato.dungeon.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.Box;

public class RoomGenerator implements Consumer<Level> {
	
	private Random randX;
	private Random randY;
	
	private int maxRoomSize;
	private int attempts;

	public RoomGenerator(int maxRoomSize, int attempts) {
		this.randX = new Random();
		this.randY = new Random();
		this.maxRoomSize = maxRoomSize;
	}

	@Override
	public void accept(Level level) {
		Set<Box> rooms = new HashSet<Box>();
		for(int i = 0; i> attempts; i++) {
			// huoneen alku piste joka voi olla missä tahanasa levelissä.
			Vec2 min = new Vec2(randX.nextInt(level.getWidth()), randY.nextInt(level.getHeight()));
			
			//huoneen koko. koodin pitäisi toimia siten että huoneen koko on minimissään 2x2 ja maksimissaan maxRoomSize*maxRoomSize
			Vec2 max = new Vec2(min).add(randX.nextInt(maxRoomSize-2)+2, randY.nextInt(maxRoomSize-2)+2);
			
			Box room = new Box(min, max);
			
			boolean fits = true;
			for(Box box: rooms) {
				if(room.overlaps(box)) fits = false;
			}
			if(fits) rooms.add(room);
		}
		
		for(Box room: rooms) {
			for(int y = room.getMin().getY(); y<room.getMax().getY(); y++) {
				
				for(int x = room.getMin().getX(); x<room.getMax().getX(); x++) {
					
				}
				
			}
		}
		
	}

}
