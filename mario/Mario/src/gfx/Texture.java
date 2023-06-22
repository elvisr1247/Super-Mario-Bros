package gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

//loads all the textures
public class Texture { 
	
	public static BufferedImage[] block = new BufferedImage[7];
	public static BufferedImage[] player = new BufferedImage[10];
	
	
	public static BufferedImage[] playerRunRight = new BufferedImage[3];
	public static BufferedImage[] playerRunLeft = new BufferedImage[3];
	
	public static BufferedImage[] goombaWalk = new BufferedImage[2];
	public static BufferedImage jumpRight,jumpLeft,idleRight,idleLeft;

	public static Font font16,font24;
	
	public static BufferedImage startupBackground,mushroom;
	
	public static String img = "/img/";
	
	public static BufferedImage muschroom;
	
		
	public static void init() {
		
		//fonts
		font24 = FontLoader.loadFont("/font/mario-font.ttf",24);
		font16 = FontLoader.loadFont("/font/mario-font.ttf",16);
		
		
		SpriteSheet bs = new SpriteSheet(ImageLoader.loadImage(img+"sprite.png"));
		SpriteSheet ps = new SpriteSheet(ImageLoader.loadImage(img+"mario-forms.png"));
		SpriteSheet blo = new SpriteSheet(ImageLoader.loadImage(img+"background.png"));
		
		
		block[0] = bs.crop(3, 0, 45, 45);//brick
		block[1] = bs.crop(48, 3, 50, 45);//question mark
		block[2] = bs.crop(96, 0, 95, 100);//pipe
		block[3] = bs.crop(0, 48, 48, 48);//empty block
		block[4] = blo.crop(0, 624, 45, 45);//brick floor
		block[5] = bs.crop(0,195, 45, 45);//coin floor
		
		
		mushroom = bs.crop(48, 48*4, 48, 48);
		
		//Player animation idle
		idleRight = ps.crop(50,48,50,48);//idle anim right
		idleLeft = ps.crop(0,48,50,48);//idle anim left
		
		//jump
		jumpRight = ps.crop(50, 0, 50, 48);//jump right
		jumpLeft = ps.crop(0, 0, 50, 48);//jump left
		
		//run
		playerRunRight[0] = ps.crop(50, 48+48, 50, 48);//walk 1 right
		playerRunRight[1] = ps.crop(50, 48+48+48, 50, 48);//walk 2 right
		playerRunRight[2] = ps.crop(50, 48+48+48+48, 50, 48);//walk 3 right
		
		
		playerRunLeft[0] = ps.crop(0, 48+48, 50, 48);//walk 1 left
		playerRunLeft[1] = ps.crop(0, 48+48+48, 50, 48);//walk 2 left
		playerRunLeft[2] = ps.crop(0, 48+48+48+48, 50, 48);//walk 3 left

		goombaWalk[0] = bs.crop(48, 48*3, 48, 48);//goomba
		goombaWalk[1] = bs.crop(48*4, 48*3, 48, 48);//goomba
		
		muschroom = bs.crop(48, 48*4, 48, 48);
		
	}
}
