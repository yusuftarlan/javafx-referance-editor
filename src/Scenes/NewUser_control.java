package Scenes;

import Csv_Commends.CsvKomut;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Kullanici;

import java.io.IOException;

public class NewUser_control {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button olusturbuton;

    @FXML
    private TextField girisAd;
    @FXML
    private Label uyarilabel;
    @FXML
    private PasswordField girisSifre;
    @FXML
    private Button butGoLogin;

    @FXML
    private Button butKullaniciOlustur;


    @FXML
    void GoLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    // Kullanıcıyı oluşturmak için
    void kullaniciOlustur(ActionEvent event) throws IOException {
        System.out.println("Olusturbuton");
        boolean kullaniciVar = false;
        String kullaniciAdi = girisAd.getText();
        String sifre = girisSifre.getText();
        for (int i = 0; i < Kullanici.kullaniciSayisi; i++) {
            if (kullaniciAdi.equals(Kullanici.kullanicilar.get(i).getAd())) {
                kullaniciVar = true;
                break;
            }
        }
        if (kullaniciAdi.isEmpty()){
            uyarilabel.setText("Lütfen bir kullanıcı adı seçin");
        }
        else if (sifre.isEmpty()) {
            uyarilabel.setText("Lütfen bir şifre seçin");
        }
        else if (kullaniciVar) {
            uyarilabel.setText("Bu kullanıcı adı kullanılıyor");
        }
        else{
            // Kullanici nesnesi oluşturulur ve CSV dosyasınada eklenir
            String [] kullaniciVerisi = {kullaniciAdi, sifre};
            CsvKomut.kullaniciEkle(kullaniciVerisi,"src\\kullanicilar.csv");
            Kullanici.kullanicilar.add(new Kullanici(kullaniciAdi,sifre));
            System.out.println("YENİ KULLANICI EKLENDİ");
            Alert alert = new Alert(Alert.AlertType.INFORMATION); // Bilgi kutusu oluştur
            alert.setTitle("Bilgilendirme");
            alert.setHeaderText("Hesabınız başarıyla oluşturuldu");
            alert.setContentText("Giriş sayfasına yönlendiriliyorsunuz");
            alert.showAndWait(); // Kutuyu göster ve bekle
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

}
