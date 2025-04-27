package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewUser extends Application {


    @Override
    public void start(Stage stageLogin) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
        stageLogin.setScene(new Scene(root));
        stageLogin.show();
    }
}
