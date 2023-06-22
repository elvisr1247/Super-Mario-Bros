package manager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gfx.UI;

public class KeyManager implements KeyListener {
	
	public boolean left = false,right = false,backSpace = false,
			down = false,pause = false;

	private Main m;
	
	public KeyManager(Main main) {
		this.m = main;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_A||
				e.getKeyCode()==KeyEvent.VK_LEFT)left = true;
		if(e.getKeyCode()==KeyEvent.VK_D||
				e.getKeyCode()==KeyEvent.VK_RIGHT)right = true;
		if(e.getKeyCode()==KeyEvent.VK_S||
				e.getKeyCode()==KeyEvent.VK_DOWN)down = true;
		if(e.getKeyCode()==KeyEvent.VK_SPACE||
				e.getKeyCode()==KeyEvent.VK_UP)backSpace = true;
		
		if(m.currentState == m.startScreenState) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				UI.commandNum--;
				
				if(UI.commandNum > 2)UI.commandNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				UI.commandNum++;
				if(UI.commandNum < 0)UI.commandNum = 2;
			}
			if(UI.commandNum==0&&e.getKeyCode()==KeyEvent.VK_ENTER==true) {
				m.setCurrentState(m.getGameState());
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_P) {
			if(pause)pause = false;
			else pause = true;
		}
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_A||
				e.getKeyCode()==KeyEvent.VK_LEFT)left = false;
		if(e.getKeyCode()==KeyEvent.VK_D||
				e.getKeyCode()==KeyEvent.VK_RIGHT)right = false;
		if(e.getKeyCode()==KeyEvent.VK_S||
				e.getKeyCode()==KeyEvent.VK_DOWN)down = false;
		if(e.getKeyCode()==KeyEvent.VK_SPACE||
				e.getKeyCode()==KeyEvent.VK_UP)backSpace = false;
	}

}
