package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			AnchorPane root = loader.load();
			Scene scene = new Scene(root, EnumSprite.WIDTH.getValue(), EnumSprite.HEIGHT.getValue());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Magic Wand");
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon/icon.png")));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
