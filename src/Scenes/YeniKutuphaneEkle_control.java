package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Kullanici;
import model.Kutuphane;

import javax.imageio.IIOParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class YeniKutuphaneEkle_control {
    @FXML
    private Button butKutEkle;
    @FXML
    private Label labelKutEkleHata;


    @FXML
    private TextField textFKutAdi;

    @FXML
    private TextField textFKutDosAdi;

    @FXML
    // Yeni kütüphane eklemek için bu kod çalışır.
    void kutEkle(ActionEvent event) throws IOException {
        String kutuphaneDosAdi = textFKutDosAdi.getText();
        String kutuphaneAdi = textFKutAdi.getText();
        if (kutuphaneAdi.equals("")){
            labelKutEkleHata.setText("Lütfen kütüphane adı girin");
        } else if (kutuphaneDosAdi.equals("")) {
            labelKutEkleHata.setText("Lütfen kütüphane dosya adı girin");
        }
        else {
            String dosyaYolu = "src\\" + kutuphaneDosAdi +".csv";
            if(Files.exists(Path.of(dosyaYolu))){
                Kullanici.mainKullanici.kutuphaneEkle(new Kutuphane(kutuphaneAdi,kutuphaneDosAdi));
                Alert alert = new Alert(Alert.AlertType.INFORMATION); // Bilgi kutusu oluştur
                alert.setTitle("Bilgilendirme");
                alert.setHeaderText("Kütüphane başarıyla oluşturuldu");
                alert.setContentText("Yazma editörü sayfasına yönlendiriliyorsunuz");
                alert.showAndWait();


                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            else{
                labelKutEkleHata.setText("Geçersiz bir dosya girdiniz");
            }

        }

    }

}
