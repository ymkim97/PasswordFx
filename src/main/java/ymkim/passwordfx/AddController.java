package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddController {

    @FXML
    AnchorPane addPane;

    public void setOkButton() {
        //get textfield information
        Stage stage = (Stage)addPane.getScene().getWindow();
        stage.close();
    }

    public void setCancelButton() {
        Stage stage = (Stage)addPane.getScene().getWindow();
        stage.close();
    }

}
