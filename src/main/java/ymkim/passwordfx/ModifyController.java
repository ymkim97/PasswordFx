package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ModifyController {

    @FXML
    AnchorPane modifyPane;

    public void setOkButton() {

        Stage stage = (Stage)modifyPane.getScene().getWindow();
        stage.close();
    }

    public void setCancelButton() {
        Stage stage = (Stage)modifyPane.getScene().getWindow();
        stage.close();
    }
}
