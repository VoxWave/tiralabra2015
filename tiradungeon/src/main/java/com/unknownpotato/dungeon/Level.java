package com.unknownpotato.dungeon;

import java.util.function.Consumer;

import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Vec2;

/**
 * 
 * Level is a 2 dimensional grid filled with tiles used to represent a roguelike level.
 * 
 * @author VoxWave
 *
 */

public class Level {
	
	private Tile[][] tiles;
	private int width;
	private int height;
	
	/**
	 * Creates a level and fills it with walls.
	 * 
	 * @param width The width of the level.
	 * @param height The height of the level.
	 */
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
	
	/**
	 * Applies a generator on the level and then returns the level itself.
	 * <p>
	 * Generators are Consumers that modify level in some way such as carving a maze.
	 * The method returns the level to allow chaining of this method.
	 * 
	 * @param generator
	 * @return
	 */
	public Level apply(Consumer<Level> generator){
		generator.accept(this);
		return this;
	}
	
	/**
	 * Returns the width of the level.
	 * @return
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Returns the height of the level.
	 * @return
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * returns a tile from the level
	 * <p>
	 * This method returns a void tile if the given coordinates are out of bounds.
	 * 
	 * @param x
	 * @param y
	 * @return Tile
	 */
	public Tile getTile(int x, int y) {
		try {
		    return this.tiles[x][y];
		}catch(IndexOutOfBoundsException e){
		    return new Tile(TileType.VOID);
		}

	}
	
	/**
	 * returns a tile from the level
	 * <p>
	 * This method returns a void tile if the given coordinates are out of bounds.
	 * @param vec
	 * @return Tile
	 */
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

