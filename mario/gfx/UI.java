package gfx;
import java.awt.Color;
import java.awt.Graphics;

import manager.Main;

public class UI {
	
	int score = 200;
	public int coins = 0;
	int time = 367;
	int lives = 3;
	
	public static int commandNum = 0;
	
	Main m;
	
	public UI(Main m) {
		this.m = m;
	}


	public void render(Graphics g) {
		g.setFont(Texture.font16);
		g.setColor(Color.white);
		g.drawString("Mario", 50, 20);
		g.drawString(""+score, 50, 40);
		
		g.drawImage(Texture.block[5],200,24,20,20, null);
		g.drawString("X", 220, 40);
		g.drawString(""+coins, 240, 40);
	
		g.drawString("World", 350, 20);
		g.drawString("1-1", 360, 40);
		
		g.drawString("Time", 530, 20);
		g.drawString(""+time, 540, 40);
		
//		g.drawString("Lives", 350, 20);
//		g.drawString(""+lives, 360, 40);
		
		
	}

	

	

}
