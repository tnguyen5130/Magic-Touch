package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuController {

    @FXML
    private Pane rootpane;
    @FXML
    private Button button;
    @FXML
    void onMouseClick(MouseEvent event) {
    	AnchorPane pane;
		try {
			pane = FXMLLoader.load((getClass().getResource("MagicFX.fxml")));
			rootpane.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
