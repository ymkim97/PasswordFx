package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoggedController implements Initializable {
    private final static MainUserRepository mainUserRepository = MainController.getMainUserRepository();
    private final String mainUser = mainUserRepository.getMainUsername();
    private final H2Connector h2Connector = new H2Connector();
    private final List<String> website;

    @FXML
    private ListView<String> selectList;

    @FXML
    private AnchorPane loggedPane;

    public LoggedController() {
        website = new ArrayList<>();
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT NAME FROM INFORMATION WHERE MAIN_USER = '" + mainUser + "'";
            ResultSet resultSet = stmt.executeQuery(state);
            while(resultSet.next()) {
                website.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        selectList.getItems().addAll(website);
    }

    public void setLogoutButton() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage)loggedPane.getScene().getWindow();
            stage.close();
        }

    }

    public void setAddButton() {
        try {
            Parent add = FXMLLoader.load(Objects.requireNonNull(Class.forName("ymkim.passwordfx.LoggedController")
                    .getResource("AddPopup.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Add");
            stage.setScene(new Scene(add));
            stage.showAndWait();
            selectList.getItems().add(getLatestInput());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getLatestInput() {
        String latest = "";
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT NAME FROM INFORMATION WHERE MAIN_USER = '" + mainUser + "'";
            ResultSet resultSet = stmt.executeQuery(state);
            resultSet.last();
            latest = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latest;
    }

}
