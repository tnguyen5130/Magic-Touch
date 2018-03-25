package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class MagicFXController implements Initializable{
	
	public int width;
	public int height;
	
//	private Box boxcontrol = new Box(50,50);
//	private Integer[] boxInitPos=new Integer[9];
	private SoundManager soundplayer;
	private GraphicsContext gc1,gc2;
	private Image BACKGROUND;
	private WritableImage wImage;
	private File file= new File("res/white.png");
    private String musicFile = "res/Theme.mp3";
    private MediaPlayer mediaPlayer;
    private Media sound;
    
	@FXML
	private Canvas canvas1;
	@FXML
	private Canvas canvas2;
	@FXML
	private Slider volumeSlider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		width=(int) canvas1.getWidth();
		height=(int) canvas1.getHeight();
		//canvas2=new Canvas(canvas.getWidth(),canvas.getHeight());
		wImage=new WritableImage(width,height);
		
		gc1 = canvas1.getGraphicsContext2D();
		gc1.setStroke(Color.RED);
        gc1.setLineWidth(5);
        
        gc2 = canvas2.getGraphicsContext2D();
		gc2.setStroke(Color.RED);
        gc2.setLineWidth(5);
        
//        EventHandler event = new EventHandler();
        
        try {
			BACKGROUND=new Image(new FileInputStream("res/Wizard_Castle.jpg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        gc1.drawImage(BACKGROUND, 0, 0);
        playSound();
        adjustVolume();
	}
	
	@FXML
	public void onMouseDragged(MouseEvent event) {
		gc1.lineTo(event.getX(), event.getY());
		gc1.stroke();
		
		gc2.lineTo(event.getX(), event.getY());
		gc2.stroke();
		
		System.out.println("drag");
	}
	
	@FXML
	public void onMousePressed(MouseEvent event) {
		System.out.println("press");
		
		gc1.beginPath();
		gc1.moveTo(event.getX(), event.getY());
		gc1.stroke();
		
		gc2.beginPath();
		gc2.moveTo(event.getX(), event.getY());
		gc2.stroke();
	}
	
	@FXML
	public void onMouseReleased(MouseEvent event) {
		canvas2.snapshot(null, wImage);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(wImage,null), "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("release");
		gc1.drawImage(BACKGROUND, 0, 0);
		gc2.clearRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
	}
	
	public Slider getVolumeSlider() {
		return volumeSlider;
	}
	
	/* Fix later*/
	public void playSound() 
	{
	      sound = new Media(new File(musicFile).toURI().toString());
	      mediaPlayer = new MediaPlayer(sound);
	      mediaPlayer.play();
	}
	
	public void adjustVolume() {
		volumeSlider.setValue(mediaPlayer.getVolume()*100);
		volumeSlider.valueProperty().addListener(
				new InvalidationListener() {
					@Override 
					public void invalidated(Observable ob)
					{
						mediaPlayer.setVolume(volumeSlider.getValue() / 100);
					}
				});
	}
}
