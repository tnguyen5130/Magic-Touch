package application;
import Gameinfo.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class Wizard extends Position implements Object{
	public Integer value=10;
	public double xPos,yPos;
	public Image wizardpng;
	public double speed;
	public String valueText;
	
	public Wizard(double xPos, double yPos) {
		super(xPos, yPos);
		init();
	}

	private void init() {
		try {
			wizardpng = new Image(new FileInputStream("res/wizard.gif"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		value=(int)(Math.random()*10);
	//xPos=Math.random()*985-50;
		xPos=800;
		yPos=535;
		valueText=value.toString();
	}
	
	@Override
	public void draw(Canvas canvas) {
		canvas.getGraphicsContext2D().drawImage(wizardpng, xPos,yPos, wizardpng.getWidth(), wizardpng.getHeight());
		//canvas.getGraphicsContext2D().fillText(valueText, xPos+35, yPos+28);
	}

	public void moveRight() {
		xPos += 1;
	}
	public void moveLeft() {
		xPos -= 1;
	}
}

