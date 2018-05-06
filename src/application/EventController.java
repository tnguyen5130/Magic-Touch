package application;

import java.util.ArrayList;

import Gameinfo.EnumSprite;
import javafx.scene.canvas.Canvas;

public class EventController {
	public ArrayList<Box> box = new ArrayList<Box>();
	public Box tempBox;
	
	public void addBox(double x,double y) {
		box.add(new Box(x,y));
	}
	
	public void drawBoxes(Canvas canvas) {
		for(Box b:box) {
			b.draw(canvas);
		}
	}
	
	public void checkBoxApearence(int value) {
		if(box.size()>0) {
			if(box.get(0).value==value || box.get(0).yPos>EnumSprite.HEIGHT.getValue()) {
				box.remove(box.get(0));
			}
		}
	}
	
	public void fallBoxes() {
		for(Box b:box) {
			b.move();
		}
	}
}
