package Tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import creature.GameObject;
import manager.Main;

public abstract class SolidObjects extends GameObject {
	
	protected boolean teleport = false;
	public int type;

	public SolidObjects(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
