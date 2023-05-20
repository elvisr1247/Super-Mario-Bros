package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

//	private int speed;
//	private int frames;//how many animations
//	private int index = 0;//what currently on
//	private int count = 0;// what the animation needs to be on
//	
//	private BufferedImage[] images;
//	private BufferedImage currentImg = null;
	
//	public Animation(int speed,BufferedImage... args) {
//		this.speed = speed;
//		images = new BufferedImage[args.length];
//		for(int i = 0; i < args.length;i++) {
//			images[i] = args[i];
//		}
//		frames = args.length;
//	}
//	public void runAnimation() {
//		index++;
//		if(index > speed) {
//			index = 0;
//			nextFrame();
//		}
//	}
//	private void nextFrame() {
//		for(int i = 0; i < frames;i++) {//count is current frame
//			if(count == i)
//				currentImg = images[i];
//		}
//		
//		count++;
//		
//		if(count > frames)
//			count = 0;//reset animation
//	}
//	public void drawAnimation(Graphics g,int x,int y) {
//		g.drawImage(currentImg, x, y, null);
//	}
//	
//	public void drawAnimation(Graphics g,int x,int y,int scaleX,int scaleY) {
//		g.drawImage(currentImg, x, y,scaleX,scaleY, null);
//	}
	private int speed,index;
	private long lastTime,timer;
	private BufferedImage[] frames;
	
	public  Animation(int speed,BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	public void update() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(timer>speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
		
	}

	public BufferedImage getCurrentFrame() {
		return frames[index];
	
	}
	
}
