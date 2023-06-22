package creature;

import java.awt.Graphics;

import gfx.Texture;
import manager.Main;

public class Coin extends Items {

//	Texture tex = Main.getInstance();
	public Coin(Main m, float x, float y, int width, int height) {
		super(m, x, y, width, height);
		// TODO Auto-generated constructor stub
		id = 1;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Texture.block[5],(int)x,(int)y,width,height,null);
	}
	
	

}
