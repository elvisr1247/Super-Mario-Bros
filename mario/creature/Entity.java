package creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import Tile.SolidObjects;
import manager.Main;



public class Entity extends GameObject {

	protected float speed = 3;
	protected float gravity = 0.38f;
	protected float xMove,yMove;
	protected boolean jumping,falling;
	
	protected String direction = "";
	
	
	public Entity(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		jumping = false;
		falling = true;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	protected void move() {
		x+=xMove;
		y+=yMove;	
	}
	
	protected void collision() {
		for(int i = 0;i < m.getSolidObjects().size();i++) {
			SolidObjects bl =  m.getSolidObjects().get(i);
			
			//Top collision
			if(getBoundsTop().intersects(bl.getBounds())) {
				
//				if(bl.getY()<=1310)
//					y = bl.getY()+32*50;
//				else
				y = bl.getY()+32;
				
				yMove = 0;
				
				//mushroom in question mark block
				if(bl.getType()==1) {
					System.out.println("question mark");
					if(bl.getX()== 416&&bl.getY()==1408) {//specific block has muschroom
						m.getItems().add(new PowerUp(m,bl.getX(),bl.getY()-40,32,32));
					}else {
						m.getUi().coins++;
					}
					
					bl.setType(3);
				}			
					
					System.out.println(""+bl.getX()+","+""+bl.getY());
				}
				
			
			//bottom collision
			if(getBoundsBottom().intersects(bl.getBounds())) {
				y = bl.getY()-height;
				yMove = 0;
//				System.out.println("on floor");
//				jumping = false;
				falling = false;
			}else {
				falling = true;
			}
			//right collision
			if(getBoundsRight().intersects(bl.getBounds())) {
				x = (int)bl.getX() - width;
				direction = "right";
			}
			//left collision
			if(getBoundsLeft().intersects(bl.getBounds())) {
				if(bl.getWidth()==64)//pipe size
					x = (int)bl.getX() + 65;
				else
					x = (int)bl.getX()+32;
				
				direction = "left";
			}
	
		}
	}
	
	
	public Rectangle getBoundsBottom() {
		return new Rectangle((int)x+(width/2)-(width/4),(int)y+(height/2),width/2,height/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)x+(width/2)-(width/4),(int)y,width/2,height/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int)x+width-5,(int)y+5,5,height-10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y+5,5,height-10);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,width,height);
	}
	

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

}
