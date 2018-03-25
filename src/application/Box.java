package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Box extends Position {

	public int randomInt;
	public int delayTimeBox = 0;
	public int delayBox = getDelayTimeBox(5000);
	public Image boxpng;

	public Box(Float xPos, Float yPos) {
		super(xPos, yPos);
	}

	public void init() {
		this.randomInt = (int) (Math.random() * 1) + (int) (Math.random() * 5);
		try {
			boxpng = new Image(new FileInputStream("res/Wizard_Castle.jpg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getRandomInt() {
		return randomInt;
	}

	public int getDelayTimeBox(int maxTime) {
		return (int) (Math.random() * maxTime) + 1;
	}

	public void drawBox(Canvas canvas) {
		canvas.getGraphicsContext2D().drawImage(boxpng, this.xPos, this.yPos, boxpng.getWidth(), boxpng.getHeight());
	}
}
