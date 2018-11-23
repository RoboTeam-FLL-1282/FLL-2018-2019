package EV3Library;
import java.io.File;

import lejos.hardware.*;
public class sound {
	
	public static void playSample(String path, int volume) {
		File file = new File(path);
		Sound.playSample(file, volume);
	}
	
	public static void playTone(int frequency, int duration, int volume) {
		Sound.playTone(frequency, duration, volume);
	}
	
	public static void beep(int volume) {
		Sound.setVolume(volume);
		Sound.beep();
	}
	
}
