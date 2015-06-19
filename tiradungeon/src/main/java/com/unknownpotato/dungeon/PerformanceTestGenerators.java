package com.unknownpotato.dungeon;

import com.unknownpotato.dungeon.generator.DungeonGenerator;
import com.unknownpotato.dungeon.generator.MazeGenerator;
import com.unknownpotato.dungeon.generator.RoomGenerator;
import com.unknownpotato.dungeon.util.PNGExporter;

public class PerformanceTestGenerators {
	
	public static void main( String[] args ) {
		RoomGenerator gen2 = new RoomGenerator(4,20, 3, 10000000);
		MazeGenerator gen = new MazeGenerator(24,24);
		DungeonGenerator gen3 = new DungeonGenerator();
		
		int x = 60;
    	Level level = new Level(x,x);
    	
    	long startTime = System.currentTimeMillis();
    	level.apply(gen2);
    	long stopTime = System.currentTimeMillis();
    	System.out.println(stopTime - startTime);
//    	System.out.println(level);
    }

}
