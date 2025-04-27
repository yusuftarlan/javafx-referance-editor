package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class WritingArea extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root2 = FXMLLoader.load(getClass().getResource("WritingArea.fxml"));
        stage.setScene(new Scene(root2));
        stage.show();
    }
}
