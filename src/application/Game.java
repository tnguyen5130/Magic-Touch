package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Game extends Application {
	final static int HEIGHT = 720;
	final static int WIDTH = 986;
	
	final static Image BACKGROUND = new Image(Game.class.getResource("gameplay/Wizard_Castle.png").toString());
	@Override
	public void start(Stage primaryStage) {
		try {
			final ImageView background = new ImageView(BACKGROUND);
			final Group root = new Group(background);
			
			Scene scene = new Scene(root,WIDTH,HEIGHT);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			final Canvas canvas = new Canvas(700,350);
			root.getChildren().add(canvas);

			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			Image earth = new Image( Game.class.getResource("Power_Snow2.png").toString());
			Image sun   = new Image( Game.class.getResource("Power_Toss2.png").toString());
			
			gc.setFill(Color.RED);
			gc.fillOval(450,200,100,100);
			
			gc.setFill(Color.WHITESMOKE);
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(2);
			Font font = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
		    gc.setFont(font);
		    gc.fillText("A", 480, 265);
		    gc.strokeText("A", 480, 265);
			
			primaryStage.setTitle("Magic Touch");
			primaryStage.setScene(scene);
			 
		
			final long startNanoTime = System.nanoTime();
			 
		    new AnimationTimer()
		    {
		        public void handle(long currentNanoTime)
		        {
		            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
		 
		            double x = 150 + 128 * Math.cos(t);
		            double y = 150 + 128 * Math.sin(t);
		 
		            // background image clears canvas
		            gc.drawImage( earth, x, y );
		            gc.drawImage( sun, 120, 120 );
		        }
		    }.start();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
