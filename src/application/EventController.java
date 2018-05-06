package application;

import java.util.ArrayList;

public class EventController{
	
	class Object {
		int s;
		Box b;
		
		public int getS() {return s;}

		public void setS(int s) {this.s = s;}
		
		public Object(Box b,int s)
		{
			this.s = s;
			this.b = b;
		}
	}
	private ArrayList<Box> box = new ArrayList<Box>();
	public Box tempBox;
	private Object ob1 = new Object(tempBox,1);
	private Object ob2 = new Object(tempBox,2);
	private Object ob3 = new Object(tempBox,3);
	
	public EventController() {
		
	}
	
	public void remove(Object o) {box.remove(o);}
	
	public void checkGame() {
		
	}

	public Object getOb1() {
		return ob1;
	}

	public Object getOb2() {
		return ob2;
	}

	public Object getOb3() {
		return ob3;
	}

//	@Override
//	public void handle(KeyEvent event) {
//		switch(event.getCode())
//		{
//		case DIGIT1:
//			remove(ob1);
//			System.out.println("KeyPress "+KeyCode.DIGIT1.toString());
//			break;
//		case DIGIT2:
//			remove(ob2);
//			System.out.println("KeyPress "+KeyCode.DIGIT2.toString());
//			break;
//		case DIGIT3:
//			remove(ob3);
//			System.out.println("KeyPress "+KeyCode.DIGIT3.toString());
//			break;
//		default:
//			break;
//		}
//	}
}
