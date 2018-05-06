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
    public  void onMousePressed(MouseEvent event)  {
    
    	
    }
    
    @FXML
    void onMouseClick(MouseEvent event) {
    	System.out.println("pressed");
    	AnchorPane pane;
		try {
			pane = FXMLLoader.load((getClass().getResource("GamePlay.fxml")));
			rootpane.getChildren().setAll(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
