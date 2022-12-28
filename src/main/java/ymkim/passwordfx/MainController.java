package ymkim.passwordfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private PasswordField mainPasswordInput;

    @FXML
    private Button loginButton;

    public void login(ActionEvent event) throws Exception {

        if (checkPassword()) {

            closeStage();

            Stage primaryStage = new Stage();
            try {
                Parent root = FXMLLoader.load(Class.forName("ymkim.passwordfx.MainController").getResource("LoggedIn.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(Class.forName("ymkim.passwordfx.MainController").getResource("LoggedInTheme.css")
                        .toExternalForm());

                primaryStage.setTitle("PasswordFx");
                primaryStage.getIcons().add(new Image(Class.forName("ymkim.passwordfx.MainController")
                        .getResourceAsStream("images/icon.png")));
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        //로그인 에러창

    }

    public boolean checkPassword() {
        return mainPasswordInput.getText().equals("aaa");
    }

    public void closeStage(){
        Stage stage = (Stage)loginButton.getScene().getWindow();
        Platform.runLater(() -> {
            stage.close();
        });
    }

}