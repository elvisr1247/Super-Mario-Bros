package creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.ImageLoader;
import gfx.Texture;
import manager.Main;

public class PowerUp extends Items{
	
	int xMove,yMove;
	

	public PowerUp(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
//		speed = 1;
	}

	@Override
	public void update() {
		xMove = 0;
		yMove = 0;
		
//		x++;
//		//gravity
//		if(falling) {
//			yMove +=gravity;
//		}
		//wall collision detection
//		if(direction.equals("")) x+=speed;
//		else if(direction.equals("right"))x-=speed;
//		else if(direction.equals("left"))x+=speed;
		
		move();
	}


	private void move() {
		x+=xMove;
		y+=yMove;
		
	}

	@Override
	public void render(Graphics g) {
//		g.drawImage(ImageLoader.loadImage(Texture.img+"select-icon.png"),(int)x,(int)y,width,height,null);
		g.drawImage(Texture.muschroom,(int)x,(int)y,width,height,null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}

}
