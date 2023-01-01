package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    AnchorPane registerPane;

    public void setCancelButton() {
        Stage stage = (Stage)registerPane.getScene().getWindow();
        stage.close();
    }

    public void setSignupButton() {
        //signup method

        Stage stage = (Stage)registerPane.getScene().getWindow();
        stage.close();
    }

    public void setCheckIdButton() {

    }
}
