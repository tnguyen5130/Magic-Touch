package application;

import java.io.IOException;
import java.util.ArrayList;

import Gameinfo.EnumSprite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EventController {
	public ArrayList<Box> box = new ArrayList<Box>();
	public Box tempBox;
	@FXML 
	private Pane root;
	
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
			if(box.get(0).valueText.equals(valueText) || box.get(0).yPos>EnumSprite.HEIGHT.getValue()) 
			{
				box.remove(box.get(0));
			}
//			// GAME OVER
//			if(box.get(0).yPos>EnumSprite.HEIGHT.getValue())
//			{
//				AnchorPane pane;
//				try {
//					pane = FXMLLoader.load((getClass().getResource("EndScene.fxml")));
//					root.getChildren().setAll(pane);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	public void fallBoxes() {
		for(Box b:box) {
			b.move();
		}
	}
}
