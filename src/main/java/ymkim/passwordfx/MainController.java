package ymkim.passwordfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class MainController {
    private final H2Connector h2Connector = new H2Connector();
    private MainUserRepository mainUserRepository = new MainUserRepository();

    @FXML
    private TextField mainUsernameInput;

    @FXML
    private PasswordField mainPasswordInput;

    @FXML
    private Button loginButton;

    public void setLoginButton() {
        Stage primaryStage = new Stage();

        if (checkPassword()) {

            closeStage();

            try {
                Parent login = FXMLLoader.load(Objects.requireNonNull(Class.forName("ymkim.passwordfx.MainController")
                        .getResource("LoggedIn.fxml")));
                Scene scene = new Scene(login);
                scene.getStylesheets().add(Objects.requireNonNull(Class.forName("ymkim.passwordfx.MainController")
                                .getResource("LoggedInTheme.css"))
                                .toExternalForm());

                primaryStage.setTitle("PasswordFx");
                primaryStage.getIcons().add(new Image(Objects.requireNonNull(Class.forName(
                        "ymkim.passwordfx.MainController").getResourceAsStream("images/icon.png"))));
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        showLoginError();
    }

    public boolean checkPassword() {
        mainUserRepository.setMainUsername(mainUsernameInput.getText());
        Connection con = h2Connector.getConnection();

        try {
            Statement stmt = con.createStatement();
            String state = "SELECT MAINUSERNAME FROM MAINUSER WHERE (MAINPASSWORD = '" +
                            mainPasswordInput.getText() + "')";
            ResultSet resultSet = stmt.executeQuery(state);

            if (resultSet.next() && resultSet.getString(1).equals(mainUsernameInput.getText())) {
                stmt.close();
                con.close();
                resultSet.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void closeStage() {
        Stage stage = (Stage)loginButton.getScene().getWindow();
        stage.close();
    }

    public void showLoginError() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Login Failed!");
        alert.setHeaderText("Invalid Username or Password");
        alert.setContentText("Please try again");
        alert.showAndWait();

    }

    public void setRegisterButton() {
        try {
            Parent add = FXMLLoader.load(Objects.requireNonNull(Class.forName("ymkim.passwordfx.LoggedController")
                    .getResource("Register.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(add));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}