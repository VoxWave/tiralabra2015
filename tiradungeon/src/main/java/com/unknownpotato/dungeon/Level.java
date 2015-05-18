package com.unknownpotato.dungeon;

import java.util.function.Consumer;

public class Level {
	
	private Tile[][] tiles;
	private int width;
	private int height;
	
	public Level(int width, int height) {
		this.tiles = new Tile[width][height];
		for(int x = 0; x<width; x++) {
			for(int y = 0; x<height; y++) {
				this.tiles[x][y] = new Tile(TileType.WALL);
			}
		}
	}
	
	public Level apply(Consumer<Level> generator){
		generator.accept(this);
		return this;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Tile getTile(int x, int y) {
		try {
		    return this.tiles[x][y];
		}catch(IndexOutOfBoundsException e){
		    return new Tile(TileType.VOID);
		}

	}
	
}
