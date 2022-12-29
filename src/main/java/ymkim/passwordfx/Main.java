package ymkim.passwordfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Font.loadFont(Class.forName("ymkim.passwordfx.Main")
                    .getResourceAsStream("font/CookieRun Black.ttf"),10);
            Font.loadFont(Class.forName("ymkim.passwordfx.Main")
                    .getResourceAsStream("font/CookieRun Regular.ttf"),10);

            Parent root = FXMLLoader.load(Objects.requireNonNull(Class.forName("ymkim.passwordfx.Main")
                    .getResource("Main.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(Class.forName("ymkim.passwordfx.Main")
                            .getResource("MainTheme.css"))
                            .toExternalForm());

            primaryStage.setTitle("PasswordFx");
            primaryStage.getIcons().add(new Image(Objects.requireNonNull(Class.forName("ymkim.passwordfx.Main")
                    .getResourceAsStream("images/icon.png"))));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}