package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModifyController {
    private final static MainUserRepository mainUserRepository = MainController.getMainUserRepository();
    private final H2Connector h2Connector = new H2Connector();
    private final int modifyInfoNumber = mainUserRepository.getModifyInfoNumber();

    @FXML
    AnchorPane modifyPane;

    @FXML
    TextField modifyNameField;

    @FXML
    TextField modifyUrlField;

    @FXML
    TextField modifyIdInputField;

    @FXML
    TextField modifyPasswordInputField;

    public void setInputField() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT * FROM INFORMATION WHERE INFONUMBER = " + modifyInfoNumber;
            ResultSet resultSet = stmt.executeQuery(state);
            if (resultSet.next()) {
                modifyNameField.setText(resultSet.getString(3));
                modifyUrlField.setText(resultSet.getString(4));
                modifyIdInputField.setText(resultSet.getString(5));
                modifyPasswordInputField.setText(resultSet.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOkButton() {

        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "UPDATE INFORMATION SET NAME = '" + modifyNameField.getText() + "', URL = '"
                            + modifyUrlField.getText() + "',USERID = '" + modifyIdInputField.getText()
                            + "', USERPASSWORD = '" + modifyPasswordInputField.getText()
                            + "' " + "WHERE INFONUMBER = " + modifyInfoNumber;
            stmt.executeUpdate(state);
            mainUserRepository.setModifiedName(modifyNameField.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage)modifyPane.getScene().getWindow();
        stage.close();
    }

    public void setCancelButton() {
        Stage stage = (Stage)modifyPane.getScene().getWindow();
        stage.close();
    }
}
