package creature;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import gfx.Animation;
import gfx.Audio;
import gfx.Texture;
import manager.Main;

public class Player extends Entity {
	
	
// jump mechanic variables
	private int jumpforce;
	int fallingSpeed;
	int floorHeight = 0;
	
	//animation
	private Animation rightRun,leftRun;
	private String direction = "right";
	 
	 
	public Player(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
			
		 	int animationSpeed = 0;
	        if(xMove !=0) animationSpeed = 20;
	        else animationSpeed = 100;
	        rightRun = new Animation(animationSpeed,Texture.playerRunRight);
	        leftRun = new Animation(animationSpeed,Texture.playerRunLeft);
	        
	}

	@Override
	public void update() {	
		
		getInput();
		
//	    if(falling)yMove = yMove + gravity;
	        		
		if(xMove!=0) {//only animate when moving
			rightRun.update();
			leftRun.update();
		}
		
		
		
		move();
		collision();
		powerupCollision();	
	}

	@Override
	public void render(Graphics g) {
		if(xMove==0&&direction.equals("right")&&!jumping)g.drawImage(Texture.idleRight,(int)x,(int)y, width, height,null);
		else if(xMove==0&&direction.equals("left")&&!jumping)g.drawImage(Texture.idleLeft,(int)x,(int)y, width, height,null);
		else if(jumping&&direction.equals("right"))g.drawImage(Texture.jumpRight,(int)x,(int)y, width, height,null);
		else if(jumping&&direction.equals("left"))g.drawImage(Texture.jumpLeft,(int)x,(int)y, width, height,null);
		else g.drawImage(getCurrentAnimationFrame(),(int)x,(int)y, width, height,null);

	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;	
		
		fallingSpeed = 1;//jump falling speed
		
		//player movement
		if(m.getKeyManager().left) { 
			direction = "left";
			xMove-=speed;
		}else if(m.getKeyManager().right) {
			direction = "right";
			xMove+=speed;	
		}
		// jump code
		if(m.getKeyManager().backSpace&&y>=1500) {
			jumpforce = 17;
			
			
		}
		
		y -= jumpforce;
		jumpforce-=fallingSpeed;
		if(y>=1504)y = 1504;//so the player doesn't fall threw the floor
		
		
//		System.out.println(y);

	}
	
	private Image getCurrentAnimationFrame() {
		if(direction.equals("right"))return rightRun.getCurrentFrame();
		else if(direction.equals("left"))return leftRun.getCurrentFrame();		
		return null;
	}

	//collides with coins
	private void powerupCollision() {
		for(int i = 0;i<m.getGs().getItems().size();i++) {
			Items p = m.getGs().getItems().get(i);
			if(p.getBounds().intersects(getBoundsRight())||
					p.getBounds().intersects(getBoundsLeft())||
					p.getBounds().intersects(getBoundsTop())||
					p.getBounds().intersects(getBoundsBottom())) {
				
				
				if(p.getId()==1) {
					m.getGs().getUi().coins++;
//					m.playSE(1);//plays coin audio
				}
				
				m.getGs().getItems().remove(p);
				
				
			}
		}
		
	}

	
	

}
