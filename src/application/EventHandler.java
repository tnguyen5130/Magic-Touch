package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

public class EventHandler {
	private ArrayList<Box> box = new ArrayList<Box>();
	private ArrayList<ArrayList<String>> j = new ArrayList<ArrayList<String>>();
	private ArrayList<String> c = new ArrayList<String>(24);
	public Box tempBox;
	public void update() {
		final long startNanoTime = System.nanoTime();
		 
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
	    		for(int i=0; i<box.size(); i++)
	    		{
	    			tempBox = box.get(i);
	    		}
	        }
	    }.start();
	}
	
	public void render(Canvas canvas) {
		
	}
	public void remove(Box b) {box.remove(b);}
	
	public void add() {
		c.add("A");
		c.add("B");
		c.add("C");
		c.add("D");
		c.add("E");
		c.add("F");
		c.add("G");
		c.add("H");
		c.add("I");
		c.add("J");
		c.add("K");
		c.add("L");
		c.add("M");
		c.add("N");
		c.add("O");
		c.add("P");
		c.add("Q");
		c.add("R");
		c.add("S");
		c.add("T");
		c.add("U");
		c.add("V");
		c.add("W");
		c.add("X");
		c.add("Y");
		c.add("Z");
		j.add(c);
	}
	
	public void checkGame() {
		add();
		for (int i = 0 ; i< c.size() ; i++)
		{
			if(c.contains("A"))
				{
					remove(tempBox);
				}
		}
	}
}
