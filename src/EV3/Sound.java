package EV3;
import EV3Library.sound;
public abstract class Sound {
	
	/**
	 * Plays a music file.
	 * @param path
	 * @param volume
	 */
	public static void playFile(String path, int volume) {
		sound.playSample(path, volume);
	}
	
	/**
	 * @param frequency
	 * @param duration
	 * @param volume
	 */
	public static void playTone(int frequency, int duration, int volume) {
		sound.playTone(frequency, duration, volume);
	}
	
	/**
	 * Sounds a short beep. Good for debugging.
	 * @param volume
	 */
	public static void beep(int volume) {
		sound.beep(volume);
	}
	
}
