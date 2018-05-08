package application;

import java.util.ArrayList;

import Gameinfo.EnumSprite;
import javafx.scene.canvas.Canvas;

public class EventController {
	public ArrayList<Box> box = new ArrayList<Box>();
	public Box tempBox;
	public ArrayList<Wizard> wizard = new ArrayList<Wizard>();
	public Wizard tempWizard;
	public int score;
	
	public void addBox(double x,double y) {
		box.add(new Box(x,y));
	}
	
	public void drawBoxes(Canvas canvas) {
		for(Box b:box) {
			b.draw(canvas);
		}
	}
	
	public void checkBoxApearence(String valueText) {
		if(box.size()>0) {
			if(box.get(0).valueText.equals(valueText) ) 
			{
				box.remove(box.get(0));
				score++;
			}
			
		}
	}
	
	public void fallBoxes() {
		for(Box b:box) {
			b.move();
		}
	}
	public void stopBoxes() {
		for(Box b:box) {
			b.stop();
		}
	}
	
	public void addWizard(double x,double y) {
		wizard.add(new Wizard(x,y));
	}
	
	public void drawWizardes(Canvas canvas) {
		for(Wizard w:wizard) {
			w.drawupdate(canvas);
		}
	}
	
//	public void checkWizardApearence(String valueText) {
//		if(wizard.size()>0) {
//			if(wizard.get(0).valueText.equals(valueText) || wizard.get(0).yPos>EnumSprite.HEIGHT.getValue()) 
//			{
//				wizard.remove(wizard.get(0));
//			}
//		}
//	}
	
	public void move() {
		for(Wizard w:wizard) {
			if(w.xPos<500.0)
			w.moveLeft();
			else 
				w.moveRight();
		}
	}
	
	public int getScore() {
			return score;
	}
}
