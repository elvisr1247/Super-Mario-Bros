package state;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import Tile.Block;
import Tile.Pipe;
import Tile.SolidObjects;
import creature.Coin;
import creature.Entity;
import creature.Goomba;
import creature.Items;
import creature.Player;
import gfx.Camera;
import gfx.ImageLoader;
import gfx.Texture;
import gfx.UI;
import manager.Main;

public class GameState {
	
	
	
	private Camera cam;
	private UI ui;
	private Main m;
	private BufferedImage bg = null;
	private Player player;
	
	private Goomba goomba;
	
	
	
	int size = 32;
		
	private CopyOnWriteArrayList<SolidObjects> solidObjects
		= new CopyOnWriteArrayList<SolidObjects>();

	private CopyOnWriteArrayList<Entity> entities
		= new CopyOnWriteArrayList<Entity>();

	private CopyOnWriteArrayList<Items> items
		= new CopyOnWriteArrayList<Items>();
	
	public GameState(Main m) {
		this.m = m;
		entities.add(player = new Player(m,150,1540,size,size));
		entities.add(goomba = new Goomba(m,170,1520,size,size));
		cam = new Camera(0,0);
		ui = new UI(m);
		LoadImageLevel(ImageLoader.loadImage(Texture.img+"map.png"));
		bg = ImageLoader.loadImage(Texture.img+"background.png");
		
		
		
		
//		if(m.getCurrentState() == m.getGameState()) {
//			m.playMusic(0);
//		}
		
	}
	
	
	public void update() {
		cam.update(player);
		//pauses the game
		if(!m.getKeyManager().pause) {
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
		        	ct.update();
		        }
			 ui.update();
		}		 
		
	}
	

	public void render(Graphics g) {
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
	}

	
	//used to draw the map
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
						solidObjects.add(new Block(m,x*size,y*size,size,size,4));
					}
					if(red == 0 && green == 120 & blue == 72) {//brick rgb
						solidObjects.add(new Block(m,x*size,y*size,size,size,0));
					}
					if(red == 255 && green == 0 & blue == 0) {//question mark rgb
						solidObjects.add(new Block(m,x*size,y*size,size,size,1));
//						items.add(new Coin(this,x*size,y*size,size,size));

					}
					if(red == 255 && green == 255 & blue == 0) {//pipe rgb
						solidObjects.add(new Pipe(m,x*size,y*size,size*2,size*2+2));
					}
					if(red == 0  && green == 162 & blue == 232) {
						items.add(new Coin(m,x*size,y*size,size,size));
//						solidObjects.add(new Pipe(this,x*size,y*size,size*2,size*2+2));
					}
					if(red == 0 && green == 0 & blue == 255) {//player location blue color
						player.setX(x*size);
						player.setY(y*size);
					}
					
				}
			}
		}

	public UI getUi() {
		return ui;
	}
		
	public Player getPlayer() {
		return player;
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

