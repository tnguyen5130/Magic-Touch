package application;
import Gameinfo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Box extends Position implements Object{
	public int value=1;
	public double xPos,yPos;
	public Image boxpng;
	public double speed;
	
	public Box(double xPos, double yPos) {
		super(xPos, yPos);
		init();
	}

	private void init() {
		try {
			boxpng = new Image(new FileInputStream("res/droplet.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		value=(int)Math.random()*10;
		xPos=Math.random()*985-50;
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.getGraphicsContext2D().drawImage(boxpng, xPos,yPos, boxpng.getWidth(), boxpng.getHeight());
	}

	public void move() {
		yPos += 1;
	}
}
