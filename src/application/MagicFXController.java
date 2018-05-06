package application;
import Traindata.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.plaf.synth.SynthSpinnerUI;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MagicFXController implements Initializable {

	public int width;
	public int height;
	private GraphicsContext gc1, gc2;
	private Image BACKGROUND;
	private WritableImage wImage;
	private File file = new File("res/white.png");
	private String musicFile = "res/Theme.mp3";
	private MediaPlayer mediaPlayer;
	private Media sound;

	private Box tempBox;
	private String value="";
	SVMTrainData mySVM=new SVMTrainData();

	private ScheduledExecutorService timer;
	
	private EventController event=new EventController();
	private int delayTimeBox;
	private double count=0;
	
	// Save image //
	@FXML
	private Canvas canvas1;
	// Background only // 
	@FXML
	private Canvas canvas2;
	@FXML
	private Slider volumeSlider;
	@FXML
	private Button setting;
	@FXML
	private AnchorPane content;
	@FXML
	private TextField textField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		width = (int) canvas1.getWidth();
		height = (int) canvas1.getHeight();
		event = new EventController();
		
		try {
			BACKGROUND = new Image(new FileInputStream("res/background.jpg"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		wImage = new WritableImage(width, height);

		gc1 = canvas1.getGraphicsContext2D();
		gc1.setStroke(Color.RED);
		gc1.setLineWidth(5);

		gc2 = canvas2.getGraphicsContext2D();

		gc2.setStroke(Color.BLACK);
		gc2.setLineWidth(15);

		gc1.setFont(Font.font("Consolas",40));

//		playSound();
//		adjustVolume();
		
		Runnable update=new Runnable() {
			@Override
			public void run() {
				update();
			}
		};
		Runnable render=new Runnable() {
			@Override
			public void run() {
				render();
			}
		};
		
		timer=Executors.newSingleThreadScheduledExecutor();
		timer.scheduleAtFixedRate(update, 0, 10, TimeUnit.MILLISECONDS);
		timer.scheduleAtFixedRate(render, 0, 10, TimeUnit.MILLISECONDS);

		delayTimeBox=(int)(Math.random()*500);
	}

	@FXML
	public void onMouseDragged(MouseEvent event) {
		gc1.lineTo(event.getX(), event.getY());
		gc1.stroke();

		gc2.lineTo(event.getX(), event.getY());
		gc2.stroke();
	}

	@FXML
	public void onMousePressed(MouseEvent event) {
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
			ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Matrix.setUpMatrix();
		Matrix.resizeMatrix();
		mySVM.createHOG(Matrix.mat3);
//		System.out.println(mySVM.predict());
		
		gc1.drawImage(BACKGROUND, 0, 0);
		gc2.clearRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
	}
	
	@FXML
	public void setValueText() {
		value=textField.getText();
		textField.setText("");
		System.out.println("action");
	}
	
	public void playSound() {
		sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	public void adjustVolume() {
		volumeSlider.setValue(mediaPlayer.getVolume() * 100);
		volumeSlider.valueProperty().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable ob) {
				mediaPlayer.setVolume(volumeSlider.getValue() / 100);
			}
		});
	}
	
	public void update() {

		event.fallBoxes();
		count++;
		if(count==delayTimeBox) {
			event.addBox(Math.random()*935, 0);
			delayTimeBox=(int)(Math.random()*500);
			count=0;
			System.out.println(event.box.size());
		}
		event.checkBoxApearence(this.value);
	}
	
	public void render() {
		gc1.drawImage(BACKGROUND, 0, 0);
		event.drawBoxes(canvas1);
	}

// 		canvas2.setOnKeyPressed(new EventHandler<KeyEvent>() {
// 			@Override
// 			public void handle(KeyEvent event) {
// 				switch(event.getCode())
// 				{
// 				case DIGIT1:
// 					eventController.remove(eventController.getOb1());
// 					System.out.println("KeyPress "+KeyCode.DIGIT1.toString());
// 					break;
// 				case DIGIT2:
// 					eventController.remove(eventController.getOb2());
// 					System.out.println("KeyPress "+KeyCode.DIGIT2.toString());
// 					break;
// 				case DIGIT3:
// 					eventController.remove(eventController.getOb3());
// 					System.out.println("KeyPress "+KeyCode.DIGIT3.toString());
// 					break;
// 				default:
// 					break;
// 				}
// 			}
// 		}
// 		);
}
