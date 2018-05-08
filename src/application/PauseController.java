package application;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PauseController   {
	public boolean checkbutton = false;
    @FXML
    private Pane rootpane;
    
    @FXML
    private ImageView resume;

    @FXML
    private ImageView retry;

    @FXML
    private ImageView exit;

    @FXML
    void onMouseClick1(MouseEvent event) {
    	MagicFXController.testing1 = 0 ;
    	//MagicFXController.testing2 = 1 ;
    	checkbutton= true;
    	System.out.println(MagicFXController.testing2);
    }

    @FXML
    void onMouseClick2(MouseEvent event) {

    }

    @FXML
    void onMouseClick3(MouseEvent event) {
    	System.exit(0);
    }

}
