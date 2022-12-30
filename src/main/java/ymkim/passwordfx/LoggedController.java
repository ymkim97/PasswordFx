package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

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

    public void setAddButton() throws Exception {
        try {
            Parent add = FXMLLoader.load(Objects.requireNonNull(Class.forName("ymkim.passwordfx.LoggedController")
                    .getResource("AddPopup.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Add");
            stage.setScene(new Scene(add));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
