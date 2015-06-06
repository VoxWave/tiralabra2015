package com.unknownpotato.dungeon;

import com.unknownpotato.dungeon.generator.MazeGenerator;
import com.unknownpotato.dungeon.generator.RoomGenerator;
import com.unknownpotato.dungeon.util.PNGExporter;

public class App 
{
    public static void main( String[] args ) {
    	Level level = new Level(64,64);
    	MazeGenerator gen = new MazeGenerator(24,24);
    	System.out.println("moi");
        System.out.println(level.apply(gen).toString());
        PNGExporter exporter = new PNGExporter();
        exporter.export(level, "maze");
        
        level = new Level(500,500);
        RoomGenerator gen2 = new RoomGenerator(2,50,100000);
        System.out.println(level.apply(gen2).toString());
        exporter.export(level, "rooms");
    }
}
