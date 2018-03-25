package application;

import java.io.File;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {
    private String musicFile = "res/Theme.mp3";
    private MediaPlayer mediaPlayer;
    private Media sound;
    private MagicFXController controller;

	public void playSound() 
	{
	      sound = new Media(new File(musicFile).toURI().toString());
	      mediaPlayer = new MediaPlayer(sound);
	      mediaPlayer.play();
	}
	
	public void adjustVolume() {
		controller.getVolumeSlider().setValue(mediaPlayer.getVolume()*100);
		controller.getVolumeSlider().valueProperty().addListener(
				new InvalidationListener() {
					@Override 
					public void invalidated(Observable ob)
					{
						mediaPlayer.setVolume(controller.getVolumeSlider()
										                .getValue() / 100);
					}
				});
	}
}
