package creature;



import java.awt.Rectangle;

import manager.Main;

public abstract class Items extends GameObject {
	
	int id;

	public Items(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
