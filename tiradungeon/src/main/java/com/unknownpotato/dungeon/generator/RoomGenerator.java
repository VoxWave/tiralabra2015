package com.unknownpotato.dungeon.generator;

import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.util.ArrayList;
import com.unknownpotato.dungeon.util.List;
import com.unknownpotato.dungeon.util.Vec2;

public class RoomGenerator implements Consumer<Level> {
	class Room {
		private Vec2 a;
		private Vec2 b;
		
		public Room(Vec2 a, Vec2 b){
			this.a = a;
			this.b = b;
		}
		
		public boolean Overlaps() {
			return false;
		}
	}
	
	public RoomGenerator(){
		
	}

	@Override
	public void accept(Level level) {
		List<Vec2> rooms = new ArrayList<Vec2>();
		
	}

}
