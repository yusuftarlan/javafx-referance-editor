package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Login extends Application {

    @Override
    public void start(Stage stageLogin) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stageLogin.setScene(new Scene(root));
        stageLogin.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
