package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterController {

    H2Connector h2Connector = new H2Connector();

    @FXML
    AnchorPane registerPane;

    @FXML
    TextField nameInput;

    @FXML
    TextField usernameInput;

    @FXML
    TextField passwordInput;

    public void setCancelButton() {
        Stage stage = (Stage)registerPane.getScene().getWindow();
        stage.close();
    }

    public void setSignupButton() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "INSERT INTO MAINUSER VALUES('" + usernameInput.getText() + "','" + nameInput.getText() + "','" +
                                                            passwordInput.getText() + "')";

            stmt.executeUpdate(state);


        } catch (Exception e) {
            e.printStackTrace();
        }


        Stage stage = (Stage)registerPane.getScene().getWindow();
        stage.close();
    }

    public void setCheckIdButton() {

    }
}
