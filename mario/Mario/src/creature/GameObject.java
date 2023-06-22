package creature;
import java.awt.Graphics;
import java.awt.Rectangle;

import Tile.Block;
import manager.Main;

public abstract class GameObject {

	protected Main m;
	protected float x,y;
	protected int width,height;
		
	public GameObject(Main m,float x,float y,int width,int height) {
		this.m = m;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public Main getM() {
		return m;
	}

	public void setM(Main m) {
		this.m = m;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
