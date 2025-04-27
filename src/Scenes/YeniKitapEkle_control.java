package Scenes;

import Csv_Commends.CsvKomut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Kitap;
import model.Kullanici;

import java.io.IOException;

public class YeniKitapEkle_control {

    @FXML
    private Button butonYKitapEkle;

    @FXML
    private TextField kitapAdi;

    @FXML
    private TextField publisher;

    @FXML
    private TextField yayinTarihi;

    @FXML
    private TextField yazarAdi;

    @FXML
    private TextField yazarSoyadi;
    private String dosyaAdi;
    @FXML
    void kitapEklesine(ActionEvent event) {
        // Kullanıcıdan alınan bilgileri diziye aktar
        String[] kitapBilgileri = {
                kitapAdi.getText(),
                yazarAdi.getText(),
                yazarSoyadi.getText(),
                publisher.getText(),
                yayinTarihi.getText()
        };

        // Boş alan kontrolü
        for (String bilgi : kitapBilgileri) {
            if (bilgi.trim().isEmpty()) {
                showAlert(AlertType.WARNING, "Eksik Alan", "Lütfen tüm alanları doldurun.");
                return; // Fonksiyonu sonlandır
            }
        }
        try {
            dosyaAdi = "src\\"+Kullanici.mainKullanici.kutuphaneler.get(WritingArea_control.ind).dosyaAdi+".csv";
            // CSV dosyasına yeni kitap ekle
            CsvKomut.satirEkle(kitapBilgileri, dosyaAdi);
            int sira = Kullanici.mainKullanici.kutuphaneler.get(WritingArea_control.ind).kitaplar.size() + 1;
            Kullanici.mainKullanici.kutuphaneler.get(WritingArea_control.ind).kitaplar.add(new Kitap(sira,kitapBilgileri));
            // Kitap ekleme başarılı olursa kullanıcıya bilgi ver
            showAlert(AlertType.INFORMATION, "Başarılı", "Kitap başarıyla eklendi!");
            clearFields(); // Alanları temizle
        } catch (IOException e) {
            e.printStackTrace();
            // Hata durumunda kullanıcıya bilgi ver
            showAlert(AlertType.ERROR, "Hata", "Kitap eklenirken bir hata oluştu: " + e.getMessage());
        }

    }
    // Kullanıcıya alert mesajı göstermek için yardımcı fonksiyon
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Alanları temizlemek için yardımcı fonksiyon
    private void clearFields(){
        kitapAdi.clear();
        yazarAdi.clear();
        yazarSoyadi.clear();
        publisher.clear();
        yayinTarihi.clear();
    }

}
