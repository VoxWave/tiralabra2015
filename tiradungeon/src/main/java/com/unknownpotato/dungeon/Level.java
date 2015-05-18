package com.unknownpotato.dungeon;

import java.util.function.Consumer;

import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Vec2;

public class Level {
	
	private Tile[][] tiles;
	private int width;
	private int height;
	
	public Level(int width, int height) {
		this.tiles = new Tile[width][height];
		this.width = width;
		this.height = height;
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
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
	
	public Tile getTile(Vec2 vec) {
		return getTile(vec.getX(), vec.getY());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				builder.append(this.tiles[x][y]);
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
}

