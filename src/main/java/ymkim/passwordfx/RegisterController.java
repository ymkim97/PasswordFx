package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterController {
    private final H2Connector h2Connector = new H2Connector();
    private boolean isDuplicate = true;

    @FXML
    AnchorPane registerPane;

    @FXML
    TextField RegisterMainNameInput;

    @FXML
    TextField RegisterMainUsernameInput;

    @FXML
    TextField RegisterMainPasswordInput;

    public void setCancelButton() {
        Stage stage = (Stage)registerPane.getScene().getWindow();
        stage.close();
    }

    public void setSignupButton() {
        boolean checkField = isFieldEmpty();

        if (!isDuplicate && !checkField) {
            updateMainUserDatabase();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Signup");
            alert.setHeaderText("Signup completed");
            alert.setContentText("Thank you for signup");
            alert.showAndWait();

            Stage stage = (Stage)registerPane.getScene().getWindow();
            stage.close();
            return;
        }

        if (!checkField) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Signup");
            alert.setHeaderText("Signup not completed");
            alert.setContentText("Please check id for duplicate");
            alert.showAndWait();
        }

    }

    public boolean isFieldEmpty() {
        boolean checkField = RegisterMainNameInput.getText().isEmpty() || RegisterMainUsernameInput.getText().isEmpty()
                || RegisterMainPasswordInput.getText().isEmpty();

        if (checkField) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Signup");
            alert.setHeaderText("Every field not completed");
            alert.setContentText("Please fill every field to complete");
            alert.showAndWait();
        }

        return checkField;
    }

    public void setCheckIdButton() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT * FROM MAINUSER WHERE MAINUSERNAME = '" + RegisterMainUsernameInput.getText() + "'";
            ResultSet resultSet = stmt.executeQuery(state);
            isDuplicate = resultSet.next();
            disableCheckId();

            con.close();
            stmt.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMainUserDatabase() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "INSERT INTO MAINUSER VALUES('" + RegisterMainUsernameInput.getText() + "','" +
                            RegisterMainNameInput.getText() + "','" + RegisterMainPasswordInput.getText() + "')";
            stmt.executeUpdate(state);

            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disableCheckId() {
        RegisterMainUsernameInput.setDisable(!isDuplicate);
        if (!isDuplicate) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Signup");
            alert.setHeaderText("Username available");
            alert.setContentText("Username is available to use");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Signup");
        alert.setHeaderText("Username already exists!");
        alert.setContentText("Please select another username");
        alert.showAndWait();
    }
}
