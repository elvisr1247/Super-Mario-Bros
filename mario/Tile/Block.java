package Tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import creature.GameObject;
import creature.PowerUp;
import gfx.Texture;
import manager.Main;

public class Block extends SolidObjects {

	
	public Block(Main m, float x, float y,int width,int height,int type) {
		super(m, x, y,width,height);
		this.type = type;
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
		if(type == 0)//brick
			g.drawImage(Texture.block[0],(int)x,(int)y,width,height, null);
		if(type == 1){//question mark
			g.drawImage(Texture.block[1],(int)x,(int)y,width,height, null);
		}
		if(type == 2)//pipe
			g.drawImage(Texture.block[2],(int)x,(int)y,width,height, null);
		if(type == 3)//empty brick
			g.drawImage(Texture.block[3],(int)x,(int)y,width,height, null);
		if(type == 4)//empty brick
			g.drawImage(Texture.block[4],(int)x,(int)y,width,height, null);
	}

	
	
}
