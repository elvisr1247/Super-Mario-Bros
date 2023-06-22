package gfx;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

import manager.Main;

public class UI {
	
	int score = 200;
	public int coins = 0;
	int time = 400;
	int lives = 2;
	double timer;
	public static int commandNum = 0;
	
	Main m;
	
	
	public UI(Main m) {
		this.m = m;
	}
	
	public void update() {
		//game timer
		if(timer>=1&&time!=0) {
			time-=1;
			timer = 0;
		}else {
			timer+=0.02;
		}
		
		

	}

	public void render(Graphics g) {
		
		//time runs out game over
		if(time==0) {
			time = 0;
			if(lives !=0) {
				g.setColor(Color.black);
				g.fillRect(0, 0,Main.width, Main.height);
				g.setColor(Color.white);
				g.setFont(Texture.font16);
				g.drawString("Times up",(int)(Main.width/2.5),(int)(Main.height/2.1));
				lives -=1;
			}else {
				g.setColor(Color.black);
				g.fillRect(0, 0,Main.width, Main.height);
				g.setColor(Color.white);
				g.setFont(Texture.font16);
				g.drawString("Game Over",(int)(Main.width/2.5),(int)(Main.height/2.1));
			}
			
		}
		
		
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
		
		if(m.getKeyManager().pause)pauseScreen(g);
		
		
		
	}


	private void pauseScreen(Graphics g) {
		Color c = new Color(0,0,0,90);
		g.setColor(c);
		g.fillRect(0, 0,Main.width, Main.height);
		g.setColor(Color.red);
		g.drawString("Pause",(int)(Main.width/2.5),(int)(Main.height/2.1));
		
	}

	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}


	

	

}
