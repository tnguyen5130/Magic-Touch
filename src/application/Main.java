package application;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	private static Stage primStage;

	public static void changeScene(Scene newScene) {
		primStage.setScene(newScene);
	}

	@Override
	public void start(Stage primaryStage) {

		try {
			primStage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, EnumSprite.WIDTH.getValue(), EnumSprite.HEIGHT.getValue());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(false);
			primaryStage.setTitle("Magic Wand");
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon/icon.png")));
			primaryStage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent t) {
					Platform.exit();
					System.exit(0);
				}
			});
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		launch(args);
	}
}
