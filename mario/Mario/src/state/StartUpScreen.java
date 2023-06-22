package state;

import java.awt.Color;
import java.awt.Graphics;

import gfx.ImageLoader;
import gfx.Texture;
import gfx.UI;
import manager.Main;

public class StartUpScreen {
	
	Main m;
	
	public StartUpScreen(Main m){
		this.m = m;
	}

	public void update() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, m.width, m.height);
		g.drawImage(ImageLoader.loadImage(Texture.img+"SuperMarioLogo.png"), 170,50,300,200, null);
		
		
		g.setColor(Color.white);
		g.setFont(Texture.font24);
		g.drawString("Start Game", 200, 290);
		g.drawString("Help", 250, 320);
		g.drawString("About", 240, 350);
		
//		UI.commandNum = 2;
		
		if(UI.commandNum == 0) {
//			g.drawString(">", 170, 290);
			g.drawImage(Texture.mushroom,160,265,30,30, null);
		}
		if(UI.commandNum == 1) {
//			g.drawString(">", 170, 320);
			g.drawImage(Texture.mushroom,160,295,30,30, null);

		}
		if(UI.commandNum == 2) {
//			g.drawString(">", 170, 350);
			g.drawImage(Texture.mushroom,160,325,30,30, null);
		}
//		g.drawRect("", 0, 0, 0);
		
		
	}
}
