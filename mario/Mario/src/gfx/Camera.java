package gfx;

import creature.Player;
import manager.Main;

public class Camera {
	
	private float x,y;
	
	public Camera(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(Player player) {
		x = -player.getX()+Main.width/2;
		y = -1150;
		
		//camera limits right
		if(x>-35)x =-35;
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

	
}
