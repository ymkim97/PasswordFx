package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddController {
    private final static MainUserRepository mainUserRepository = MainController.getMainUserRepository();
    private final String MainUser = mainUserRepository.getMainUsername();
    private final H2Connector h2Connector = new H2Connector();

    @FXML
    AnchorPane addPane;

    @FXML
    TextField nameInputField;

    @FXML
    TextField urlInputField;

    @FXML
    TextField idInputField;

    @FXML
    TextField passwordInputField;

    public void setOkButton() {

        if (!checkEmptyField()) {
            try {
                Connection con = h2Connector.getConnection();
                Statement stmt = con.createStatement();
                String state = "";
                stmt.executeUpdate(state);


            }catch (Exception e) {
                e.printStackTrace();
            }

            Stage stage = (Stage)addPane.getScene().getWindow();
            stage.close();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Add Information");
        alert.setHeaderText("Every field not completed");
        alert.setContentText("Please fill every field to complete");
        alert.showAndWait();

    }

    public void setCancelButton() {
        Stage stage = (Stage)addPane.getScene().getWindow();
        stage.close();
    }

    public boolean checkEmptyField() {
        return nameInputField.getText().isEmpty() || urlInputField.getText().isEmpty()
                || idInputField.getText().isEmpty() || passwordInputField.getText().isEmpty();
    }
}
