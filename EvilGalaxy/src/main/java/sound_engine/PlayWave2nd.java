package sound_engine;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayWave2nd {

	private Clip clip;

	public PlayWave2nd(String fileName) {
		// specify the sound to play
		// (assuming the sound can be played by the audio system)
		// from a wave File
		try {
			final File file = new File(fileName);
			if (file.exists()) {
				final AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				// load the sound into memory (a Clip)
				clip = AudioSystem.getClip();
				clip.open(sound);
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
			} else {
				throw new RuntimeException("Sound: file not found: " + fileName);
			}
		} catch (final MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Sound: Malformed URL: " + e);
		} catch (final UnsupportedAudioFileException e) {
			e.printStackTrace();
			throw new RuntimeException("Sound: Unsupported Audio File: " + e);
		} catch (final IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Sound: Input/Output Error: " + e);
		} catch (final LineUnavailableException e) {
			e.printStackTrace();
			throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
		}

		// play, stop, loop the sound clip
	}

	public void play() {
		clip.setFramePosition(0); // Must always rewind!
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}
}