package Scenes;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Kullanici;
import model.Kutuphane;
import model.Main;

import java.io.IOException;
import java.util.Objects;

public class Login_control {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Stage stage2 = null;

    @FXML
    private Button butYeniKullanici;

    @FXML
    private Label hataLabel;

    @FXML
    private TextField girisAd;

    @FXML
    private Button girisbuton;

    @FXML
    private PasswordField girisSifre;

    @FXML
    // Giriş yapmak için bu fonksiyon çalıştırılır
    void gir(ActionEvent event) throws IOException {
        String kullaniciAdi = girisAd.getText();
        String sifre = girisSifre.getText();

        if (kullaniciAdi.equals("")) {
            hataLabel.setText("Lütfen kullanıcı adınızı girin");
        } else if (sifre.equals("")) {
            hataLabel.setText("Lütfen şifrenizi girin girin");
        } else {
            boolean kullaniciVar = false;
            boolean sifreDogru = false;
                for (int i = 0; i < Kullanici.kullaniciSayisi; i++) {
                    System.out.println(Kullanici.kullanicilar.get(i).getAd());
                    if (kullaniciAdi.equals(Kullanici.kullanicilar.get(i).getAd())){
                        kullaniciVar = true;
                        if (sifre.equals(Kullanici.kullanicilar.get(i).getSifre())) {
                            Kullanici.mainKullanici = Kullanici.kullanicilar.get(i);
                            Kullanici.mainKullanici.kutuphaneEkle(new Kutuphane("Varsayılan","kitaplar"));
                            sifreDogru = true;
                        }
                    }
                    if (!kullaniciVar) {
                        hataLabel.setText("Geçersiz kullanıcı");
                    }
                    if (kullaniciVar && !sifreDogru) {
                        hataLabel.setText("Şifrenizi hatalı girdiniz");
                    }
                    if (kullaniciVar && sifreDogru) {
                        root = FXMLLoader.load(getClass().getResource("WritingArea.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        break;
                    }
                }

        }
    }

    @FXML
    // Yeni kullanıcı oluşturma sayfasını açmak için
    void yeniKullaniciSahneAc(ActionEvent event) throws IOException {
        // Yeni sahneyi yükle
        System.out.println(stage2 == null);
        if (stage2 == null || !stage2.isShowing()) {
            stage2 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("NewUser.fxml"));
            Scene newScene = new Scene(root);
            stage2.setScene(newScene);
            stage2.setResizable(false);
            stage2.show();
        }
        else {
            stage2.toFront();
        }





        // Sahne bilgilerini al
        // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();



    }
}
