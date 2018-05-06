package application;
import Gameinfo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class Box extends Position implements Object{
	public Integer value=10;
	public double xPos,yPos;
	public Image boxpng;
	public double speed;
	public String valueText;
	
	public Box(double xPos, double yPos) {
		super(xPos, yPos);
		init();
	}

	private void init() {
		try {
			boxpng = new Image(new FileInputStream("res/test1.gif"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		value=(int)(Math.random()*10);
		xPos=Math.random()*985-50;
		valueText=value.toString();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.getGraphicsContext2D().drawImage(boxpng, xPos,yPos, boxpng.getWidth(), boxpng.getHeight());
		canvas.getGraphicsContext2D().fillText(valueText, xPos+35, yPos+28);
	}

	public void move() {
		yPos += 1;
	}
}
