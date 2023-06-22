package creature;

import java.awt.Graphics;
import java.awt.Image;

import gfx.Animation;
import gfx.Texture;
import manager.Main;

public class Goomba extends Entity {
	
	Animation walk;

	public Goomba(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		
		int animationSpeed = 0;
        if(xMove !=0)
		animationSpeed = 10;
        else animationSpeed = 100;
        
        walk = new Animation(animationSpeed,Texture.goombaWalk);
        
	}
	
	public void update() {
			xMove = 0;
			yMove = 0;
			
//			xMove++;
			
//			for(int i = 0; i < m.getGs().getEntities().size();i++) {
//				if()
//			}
		
			move();
			collision();
			
	}
	
	public void render(Graphics g) {
		g.drawImage(walk.getCurrentFrame(),(int)x,(int)y,width,height,null);
//		g.drawImage(Texture.goombaWalk[0],(int)x,(int)y,width,height,null);
//		g.drawImage(Texture.goombaWalk[1],(int)x+50,(int)y,width,height,null);
	}
	
	
}
