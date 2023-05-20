package manager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Tile.Block;
import Tile.Pipe;
import Tile.SolidObjects;
import creature.Coin;
import creature.Entity;
import creature.Items;
import creature.Player;
import creature.PowerUp;
import gfx.Camera;
import gfx.ImageLoader;
import gfx.Texture;
import gfx.UI;
import state.StartUpScreen;


public class Main extends JPanel implements Runnable {
	
	private JFrame frame;
	
	public static int width = 640,height = 480;
	private String title = "Mario Bros.";
	
	private Thread thread;
	private boolean running = false;
	private int FPS = 60;
	
	private KeyManager keyManager;
	private Player player;
	private UI ui;
	
	int size = 32;
	
	CopyOnWriteArrayList<SolidObjects> solidObjects
	= new CopyOnWriteArrayList<SolidObjects>();
	
	CopyOnWriteArrayList<Entity> entities
	= new CopyOnWriteArrayList<Entity>();
	
	CopyOnWriteArrayList<Items> items
	= new CopyOnWriteArrayList<Items>();
	
	private Camera cam;
	
	BufferedImage bg = null;
	
	int currentState;
	int gameState = 1;
	int startScreenState = 2;
	
	
	StartUpScreen startup;
	
		
	public Main() {
		frame = new JFrame();
		keyManager = new KeyManager(this);
		entities.add(player = new Player(this,150,1540,size,size));
		ui = new UI(this);
		cam = new Camera(0,0);
		
		startup = new StartUpScreen(this);
		
		currentState = startScreenState;
		
//		items.add(new Coin(this,200,1450,size,size));
		
		LoadImageLevel(ImageLoader.loadImage("/map.png"));
//		LoadImageLevel(ImageLoader.loadImage("/beta.png"));
		bg = ImageLoader.loadImage("/background.png");
		
		frame.add(this);
		
		
		this.addKeyListener(keyManager);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		frame.addKeyListener(keyManager);
		frame.setFocusable(true);
		Texture.init();
		
		frame.setTitle(title);
		frame.setSize(width,height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		
		running = false;
		try {
			thread.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {

        double drawInterval = 1000000000/FPS;//1000000000 means one second
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(thread !=null){
            currentTime = System.nanoTime();//checks current time
            delta +=(currentTime - lastTime)/drawInterval;//adds pasttime
            timer += (currentTime - lastTime);//gets fps
            lastTime = currentTime;

            if(delta >=1) {//when delta reaches paint if updates and repaint
                //UPDATE: update information such as character positions
                update();
                //DRAW:draw the screen with the updated info
                repaint();

                delta--;
                drawCount++;
            }
            //gets fps
            if(timer >=1000000000){
//            	ui.fps(drawCount);
//            	System.out.print(drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
	
	public void update() {
		if(currentState == gameState) {
		cam.update(player);
		for(int i = 0;i<entities.size();i++) {
			Entity e = entities.get(i);
			e.update();
		}
		
		for(int i = 0;i<items.size();i++) {
			Items e = items.get(i);
			e.update();
		}
		
		
		 for(int i = 0;i<solidObjects.size();i++) {
	        	SolidObjects ct = solidObjects.get(i);
	        	ct.update();;
	        }
		}else if(currentState == startScreenState) {
			startup.update();
        }
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);              
        if(currentState == gameState) {
        	g.translate((int)cam.getX(),(int)cam.getY());  
            g.drawImage(bg,0,1150,9000,450,null);//background
            for(int i = 0;i<entities.size();i++) {
    			Entity e = entities.get(i);
    			e.render(g);
    		}
            
            for(int i = 0;i<items.size();i++) {
    			Items e = items.get(i);
    			e.render(g);
    		}
            
            
            for(int i = 0;i<solidObjects.size();i++) {
            	SolidObjects ct = solidObjects.get(i);
            	ct.render(g);
            }
            
            
            g.translate((int)-cam.getX(),(int)-cam.getY());
            
            ui.render(g);
        }else if(currentState == startScreenState) {
        	startup.render(g);
        }
        
        g.dispose();
    }
	
	
	private void LoadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
				
		for(int x =0;x<w;x++) {
			for(int y=0;y<h;y++) {
				int pixel = image.getRGB(x, y);
				//current pixel color
				int red =(pixel>>16)&0xff;
				int green =(pixel>>8)&0xff;
				int blue = (pixel)&0xff;
				
				// if player is on black pixel/block do this
				if(red == 255 && green == 255 & blue == 255) {
					solidObjects.add(new Block(this,x*size,y*size,size,size,4));
				}
				if(red == 0 && green == 120 & blue == 72) {//brick rgb
					solidObjects.add(new Block(this,x*size,y*size,size,size,0));
				}
				if(red == 255 && green == 0 & blue == 0) {//question mark rgb
					solidObjects.add(new Block(this,x*size,y*size,size,size,1));
//					items.add(new Coin(this,x*size,y*size,size,size));

				}
				if(red == 255 && green == 255 & blue == 0) {//pipe rgb
					solidObjects.add(new Pipe(this,x*size,y*size,size*2,size*2+2));
				}
				if(red == 0  && green == 162 & blue == 232) {
					items.add(new Coin(this,x*size,y*size,size,size));
//					solidObjects.add(new Pipe(this,x*size,y*size,size*2,size*2+2));
				}
				if(red == 0 && green == 0 & blue == 255) {//player location blue color
					player.setX(x*size);
					player.setY(y*size);
				}
				
			}
		}
	}

	public static void main(String[]argh) {
		Main m = new Main();
		m.start();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public Player getPlayer() {
		return player;
	}	

	public UI getUi() {
		return ui;
	}

	public CopyOnWriteArrayList<SolidObjects> getSolidObjects() {
		return solidObjects;
	}

	public void setSolidObjects(CopyOnWriteArrayList<SolidObjects> solidObjects) {
		this.solidObjects = solidObjects;
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(CopyOnWriteArrayList<Entity> entities) {
		this.entities = entities;
	}

	public CopyOnWriteArrayList<Items> getItems() {
		return items;
	}

	public void setItems(CopyOnWriteArrayList<Items> items) {
		this.items = items;
	}

}
