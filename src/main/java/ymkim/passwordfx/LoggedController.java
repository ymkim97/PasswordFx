package ymkim.passwordfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class LoggedController implements Initializable {
    private final static MainUserRepository mainUserRepository = MainController.getMainUserRepository();
    private final String mainUser = mainUserRepository.getMainUsername();
    private final H2Connector h2Connector = new H2Connector();
    private final List<String> website;
    private int currentInfoNumber;
    private String currentInfoName;

    @FXML
    private ListView<String> selectList;

    @FXML
    private TextArea outputArea;

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
        selectList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentInfoName = selectList.getSelectionModel().getSelectedItem();
                getCurrentInfoNumber();
                List<String> information = getEachInformation();
                outputArea.clear();
                outputArea.setText("Name: " + information.get(0) + "\n\nURL: " + information.get(1) + "\n\nID: " +
                                    information.get(2) + "\n\nPassword: " + information.get(3));
            }
        });
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

            if (!mainUserRepository.getLatestInfo().equals("")) {
                selectList.getItems().add(getLatestInput());
                mainUserRepository.setLatestInfo("");
            }
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

    public List<String> getEachInformation() {
        List<String> information = new ArrayList<>();
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT NAME, URL, USERID, USERPASSWORD FROM INFORMATION WHERE NAME = '" +
                            currentInfoName + "'";
            ResultSet resultSet = stmt.executeQuery(state);
            resultSet.next();
            for (int i = 1; i <= 4; i++) {
                information.add(resultSet.getString(i));
            }
            return information;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return information;
    }

    public void getCurrentInfoNumber() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "SELECT INFONUMBER FROM INFORMATION WHERE NAME = '" + currentInfoName + "'";
            ResultSet resultSet = stmt.executeQuery(state);
            resultSet.next();
            currentInfoNumber = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRemoveButton() {
        try {
            Connection con = h2Connector.getConnection();
            Statement stmt = con.createStatement();
            String state = "DELETE FROM INFORMATION WHERE INFONUMBER = '" + currentInfoNumber + "'";
            stmt.executeUpdate(state);
            website.remove(currentInfoName);
            selectList.getItems().remove(currentInfoName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
