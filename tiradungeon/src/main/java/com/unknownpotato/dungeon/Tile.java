package com.unknownpotato.dungeon;

import java.awt.Color;

/**
 * 
 * Tiles form the level. 
 * They are used to represent the contents of the level such as walls and floors.
 * Tiles also contain (through TileTypes) Colors and char representation to ease visualization.
 * 
 * @author VoxWave
 *
 */

public class Tile {
	
	/**
	 * 
	 * TileType is the type of a tile. It is used in Generator logic and visualization.
	 * 
	 * @author VoxWave
	 *
	 */
	public enum TileType {
		WALL(Color.DARK_GRAY, '#'), 
		FLOOR(Color.LIGHT_GRAY, ' '), 
		VOID(Color.BLACK, '~');
		
		/**
		 * the Color assigned to a TileType
		 * <p>
		 * color is used in the png exporter to color each pixel correctly.
		 */
		private final Color color;
		
		/**
		 * Returns a color assigned to the TileType.
		 * 
		 * @return Color
		 */
		public Color getColor() {
			return color;
		}
		
		/**
		 * Returns a char assigned to the TileType.
		 * 
		 * @return
		 */
		public char getC() {
			return c;
		}

		private final char c;

		TileType(Color color, char c) {
			this.color = color;
			this.c = c;
		}
	}
	
	/**
	 * type determines the type of the tile.
	 */
	private TileType type;
	
	/**
	 * Constructor for the Tile. Takes in a TileType to define what kind of a tile this is.
	 * @param type
	 */
	public Tile(TileType type) {
		this.type = type;
	}
	
	/**
	 * returns the tiletype of the tile.
	 * @return
	 */
	public TileType getType() {
		return this.type;
	}
	
	/**
	 * sets the TileType of the tile to the tiletype given as a parameter
	 * @param type
	 */
	public void setType(TileType type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		return ""+type.getC();
	}

	/**
	 * returns the color of the tile
	 * <p>
	 * the color of the tile is determined by its tiletype
	 * @return
	 */
	public Color getColor() {
		return type.getColor();
	}

}
