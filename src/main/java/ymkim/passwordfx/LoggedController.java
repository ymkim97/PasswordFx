package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoggedController {

    @FXML
    private AnchorPane loggedPane;

    public void setLogoutButton() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) loggedPane.getScene().getWindow();
            stage.close();
        }

    }

}
