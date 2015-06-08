package com.unknownpotato.dungeon;

import com.unknownpotato.dungeon.generator.DungeonGenerator;
import com.unknownpotato.dungeon.generator.MazeGenerator;
import com.unknownpotato.dungeon.generator.RoomGenerator;
import com.unknownpotato.dungeon.util.PNGExporter;

public class App 
{
    public static void main( String[] args ) {
    	//luodaan labyrintti png
    	Level level = new Level(64,64);
    	MazeGenerator gen = new MazeGenerator(24,24);
    	System.out.println("moi");
        System.out.println(level.apply(gen).toString());
        PNGExporter exporter = new PNGExporter();
        exporter.export(level, "maze");
        
        //luodaan huone png
        level = new Level(64,64);
        RoomGenerator gen2 = new RoomGenerator(4,20, 3, 10000000);
        System.out.println(level.apply(gen2).toString());
        exporter.export(level, "rooms");
        
        //luodaan luolasto png
        level = new Level(64,64);
        DungeonGenerator gen3 = new DungeonGenerator();
        System.out.println(level.apply(gen3).toString());
        exporter.export(level, "dungeon");
    }
}
