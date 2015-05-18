package com.unknownpotato.dungeon.generator;

import java.util.Random;
import java.util.function.Consumer;

import com.unknownpotato.dungeon.Level;
import com.unknownpotato.dungeon.Tile;
import com.unknownpotato.dungeon.Tile.TileType;
import com.unknownpotato.dungeon.util.Stack;
import com.unknownpotato.dungeon.util.Vec2;
import com.unknownpotato.dungeon.util.enums.Direction;

public class MazeGenerator implements Consumer<Level> {
	private Random rand;
	private int x;
	private int y;
	
	public MazeGenerator(int x, int y) {
		this.rand = new Random();
		this.x = x;
		this.y = y;
	}

	@Override
	public void accept(Level level) {
		Stack<Vec2> stack = new Stack<>();
		stack.push(new Vec2(x,y));
		long seed = rand.nextLong();
		int n = 0;
		dfs:while(!stack.isEmpty()){
			Vec2 cur = stack.pop();
			Tile tile = level.getTile(cur);
			if(tile.getType() == TileType.VOID || tile.getType() == TileType.FLOOR){
				continue;
			}
			Stack<Vec2> neighbours = new Stack<>();
			int floors = 0;
			for(Direction d: Direction.values()){
				Vec2 vec = new Vec2(d.getVec());
				vec.add(cur);
				if(level.getTile(vec).getType() == TileType.FLOOR) floors++;
				if(floors > 1) continue dfs;
				neighbours.push(vec);
			}
			
			if(n%1 == 0) seed = rand.nextLong();
			n++;
			Random r = new Random(seed);
			neighbours.scramble(r);
			while(!neighbours.isEmpty()){
				stack.push(neighbours.pop());
			}
			level.getTile(cur).setType(TileType.FLOOR);
		}
	}

}
