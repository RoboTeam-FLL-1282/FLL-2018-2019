package EV3;
import EV3Library.sound;
public abstract class Sound { // Fine!
	
	public static void playFile(String path, int volume) {
		sound.playSample(path, volume);
	}
	
	public static void playTone(int frequency, int duration, int volume) {
		sound.playTone(frequency, duration, volume);
	}
	
	public static void beep(int volume) {
		sound.beep(volume);
	}
	
}
