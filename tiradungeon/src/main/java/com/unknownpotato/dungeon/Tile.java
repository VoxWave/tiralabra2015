package com.unknownpotato.dungeon;

enum TileType {
	WALL, FLOOR, VOID
}

public class Tile {
	
	private TileType type;
	
	public TileType getType() {
		return this.type;
	}

}
