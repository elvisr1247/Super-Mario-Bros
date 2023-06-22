package manager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
import gfx.Audio;
import gfx.Camera;
import gfx.ImageLoader;
import gfx.Texture;
import gfx.UI;
import state.GameState;
import state.StartUpScreen;
//super mario sounds effects
//https://themushroomkingdom.net/media/smb/wav


public class Main extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6005552797440414661L;

	private JFrame frame;
	
	public static int width = 640,height = 480;
	private String title = "Super Mario Bros.";
	
	private Thread thread;
	private boolean running = false;
	private int FPS = 60;
	
	private KeyManager keyManager;
	
	
	
	public int size = 32;
	
	
	
	int currentState;
	final int gameState = 1;
	final int startScreenState = 2;
	
	
	private StartUpScreen startup;
	protected GameState gs;
	public Audio music;
	public Audio se;
	
	//Inspiration
	/*
	 * https://www.retrogames.onl/2015/09/super-mario-bros-nes.html
	 */
	
		
	public Main() {
//		currentState = startScreenState;
		currentState = gameState;
		frame = new JFrame();
		keyManager = new KeyManager(this);
		music = new Audio();
        se = new Audio();
		startup = new StartUpScreen(this);
		gs = new GameState(this);		
		
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
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
//            	UI.fps(drawCount);
//            	System.out.print(drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
	
	public void update() {
		if(currentState == gameState) {
			gs.update();
		}else if(currentState == startScreenState) {
			startup.update();
        }
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);              
        //drawings items,blocks,and the player
        if(currentState == gameState) {//game screen
        	gs.render(g);
        }else if(currentState == startScreenState) {//start up screen
        	startup.render(g);
        }
        
        g.dispose();
    }
	
	
	public static void main(String[]argh) {
		Main m = new Main();
		m.start();
	}
	
//	public void playMusic(int i) {
//    	music.setAudio(i);
//    	music.play();
//    	music.loop();
//    }
//    
//    public void stopMusic() {
//    	music.stop();
//    }
//    
//    public void playSE(int i) {
//    	se.setAudio(i);
//    	se.play();
//    }

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameState getGs() {
		return gs;
	}

	public void setGs(GameState gs) {
		this.gs = gs;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public int getGameState() {
		return gameState;
	}

	public int getStartScreenState() {
		return startScreenState;
	}


}
