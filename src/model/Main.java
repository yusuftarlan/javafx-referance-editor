package model;
import Csv_Commends.CsvKomut;
import Scenes.WritingArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Kitap;
import model.Kullanici;
import model.Kutuphane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static model.Kullanici.kullanicilar;


// Programı başlatan sınıf budur
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args) throws  IOException {
        String line;
        // kullanicilar.csv dosyasındaki veriler ile kullanıcı nesneleri oluşturulur.
        try (BufferedReader br = new BufferedReader(new FileReader("src\\kullanicilar.csv"));) {
            line = br.readLine();
            String[] data = new String[5];
            while (line != null) {
                if (line.startsWith("\uFEFF")) {
                    line = line.substring(1);
                    data = line.split(",");
                    kullanicilar.add(new Kullanici(data[0], data[1]));
                    System.out.println(data[0] + data[1]);
                    line = br.readLine();
                }
                else{
                    data = line.split(",");
                    kullanicilar.add(new Kullanici(data[0], data[1]));
                    System.out.println(data[0] + data[1]);
                    line = br.readLine();
                }

            }
            System.out.println("kullanicilar oluşturuldu");


        }
        launch(args);
    }

}

