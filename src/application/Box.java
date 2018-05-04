package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Box extends Position implements Object{

	// fall 8 times
	public int yBox;
	
	public int delayTimeBox = 0;
	public int delayBox = getDelayTimeBox(5000);
	
	public Image boxpng;
	
	public Box(Double xPos, Double yPos) {
		super(xPos, yPos);
		randomNumber();
	}

	private void init() {
		try {
			boxpng = new Image(new FileInputStream("res/droplet.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public double randomX() {
		return Math.random() * 900 + 50;
	}
	
	public int randomNumber() {
		return (int) (Math.random() * 1) + (int) (Math.random() * 5);
	}
	
	public int getDelayTimeBox(int maxTime) {
		return (int) (Math.random() * maxTime) + 1;
	}
	
	@Override
	public void draw(Canvas canvas) {
		init();
		canvas.getGraphicsContext2D().drawImage(boxpng, Math.random() * 900 + 50, 50.00, boxpng.getWidth(), boxpng.getHeight());
	}

	public void checkFall() {
		// TODO Auto-generated method stub
		if(yBox < EnumSprite.HEIGHT.getValue())
			yBox += 1;
	}
}
