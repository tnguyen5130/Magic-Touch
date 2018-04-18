package application;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;

public class EventHandler implements ImageManager {
	public ArrayList<Box> box = new ArrayList<>();
	private Box tempBox;
	private Integer[] stopPos = new Integer[5];
	private Canvas canvas;
	public void play() 
	{
		stopPos[0]=195;
		stopPos[1]=295;
		stopPos[2]=395;
		stopPos[3]=495;
		stopPos[4]=595;
		
		for(int i=0; i<box.size(); i++) 
		{
			tempBox = box.get(i);
			
			if(tempBox.yPos <stopPos[tempBox.getRandomInt()])
				tempBox.yPos+=1;
		}
	}
	
	@Override
	public void render() 
	{
		for(int i=0; i<box.size();i++)
		{
			tempBox = box.get(i);
			tempBox.drawBox(canvas);;
		}
	}
	
	public ArrayList<Box> getBox() {
		return box;
	}

	public void setBox(ArrayList<Box> box) {
		this.box = box;
	}

	public void addBox(Box b)    {box.add(b);}
	public void removeBox(Box b) {box.remove(b);}
}

