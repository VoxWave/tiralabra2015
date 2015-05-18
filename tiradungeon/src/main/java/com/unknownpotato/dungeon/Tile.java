package com.unknownpotato.dungeon;

import java.awt.Color;

public class Tile {
	public enum TileType {
		WALL(Color.DARK_GRAY, '#'), FLOOR(Color.LIGHT_GRAY, ' '), VOID(Color.BLACK, '~');
		
		private final Color color;
		public Color getColor() {
			return color;
		}

		public char getC() {
			return c;
		}

		private final char c;

		TileType(Color color, char c) {
			this.color = color;
			this.c = c;
		}
	}
	
	private TileType type;
	
	public Tile(TileType type) {
		this.type = type;
	}
	
	public TileType getType() {
		return this.type;
	}
	
	public void setType(TileType type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		return ""+type.getC();
	}

	public Color getColor() {
		return type.getColor();
	}

}
