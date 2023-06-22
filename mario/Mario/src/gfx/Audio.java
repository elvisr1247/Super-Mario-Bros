package gfx;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
//used for audio playing
public class Audio {
	private File file;
	private Clip clip;
	private AudioInputStream audioStream;
	private URL[] soundURL = new URL[30];
	//used for audio control
	private FloatControl fc;
	public int volumeScale = 2;
	public float volume;
	
	static String audio = "/audio/";
	
	
	public Audio() {
//		soundURL[0] = getClass().getResource(audio+"background.wav");
//		soundURL[1] = getClass().getResource(audio+"coin.wav");
//		soundURL[2] = getClass().getResource(audio+"jump.wav");
//		soundURL[3] = getClass().getResource(audio+"gameOver.wav");
//		
//		
		
	}
	
	
//	public void setAudio(int i) {
//		
//		try {
//			if(soundURL[i] !=null)
//			audioStream = AudioSystem.getAudioInputStream(soundURL[i]);
//			clip = AudioSystem.getClip();
//			clip.open(audioStream);
//			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
//			checkVolume();
//		} catch (Exception e) {
//			
//		}
//	}	
	
//	public void play() {
//		clip.start();
//	}
//	
//	public void loop() {
//		clip.loop(Clip.LOOP_CONTINUOUSLY);
//	}
//	
//	public void stop() {
//		clip.stop();
//	}
//	
//	public void checkVolume() {
//		switch(volumeScale) {
//			case 0:volume = -80f; break;
//			case 1:volume = -20; break;
//			case 2:volume = -12f; break;
//			case 3:volume = -5f; break;
//			case 4:volume = 1f; break;
//			case 5:volume = 6f; break;
//		}
//		//sets the sound
//		fc.setValue(volume);
//	}
}
