package application;

import java.io.IOException;
import java.util.ArrayList;

import Gameinfo.EnumSprite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EventController {
	public ArrayList<Box> box = new ArrayList<Box>();
	public Box tempBox;
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
			if(box.get(0).valueText.equals(valueText)) 
			{
				box.remove(box.get(0));
			}
			// GAME OVER
//			if(box.get(0).yPos>EnumSprite.HEIGHT.getValue())
//			{
//				try {
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("EndScene.fxml"));
//					System.out.println("gfsgf");
//				//	AnchorPane pane = loader.load();
//				
//					loader.getChildren().setAll(root);
////					root = new Scene(pane);
////					Main.changeScene(root);
//				} catch (IOException e) {
//					e.printStackTrace();
				}
			}
		
	
	
	public void fallBoxes() {
		for(Box b:box) {
			b.move();
		}
	}
}
