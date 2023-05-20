package Tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import creature.GameObject;
import gfx.Texture;
import manager.Main;

public class Pipe extends SolidObjects {
	

	public Pipe(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Texture.block[2],(int)x,(int)y,width,height,null);
		
	}
	


}
