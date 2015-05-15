package com.unknownpotato.dungeon;

import java.util.function.Consumer;

public class Level {
	
	private Tile[][] tiles;
	
	public Level(int width, int height) {
		this.tiles = new Tile[width][height];
	}
	
	public Level apply(Consumer<Level> generator){
		return this;
	}

}
