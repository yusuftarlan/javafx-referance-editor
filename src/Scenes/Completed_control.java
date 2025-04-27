package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.IOException;


public class Completed_control {


    @FXML
    private Label Kaynakca_label;

    @FXML
    private HTMLEditor referencesArea;

    public void setKaynakcaText(String text) {
        if (referencesArea != null) {
            referencesArea.setHtmlText(text);
        } else {
            System.err.println("referencesArea is null!");
        }
    }



}