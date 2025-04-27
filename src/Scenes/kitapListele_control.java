package Scenes;

import Csv_Commends.CsvKomut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class kitapListele_control {

    @FXML
    private ListView<String> kitapListesi;

    private final String dosyaAdi = "src/resources/kitaplar.csv"; // CSV dosyasının yolu

    @FXML
    public void initialize() {
        try {
            ArrayList<Object[]> kitapVeri = CsvKomut.veriCıkart(dosyaAdi);
            ObservableList<String> kitapGoruntuleri = FXCollections.observableArrayList();

            for (Object[] kitap : kitapVeri) {
                kitapGoruntuleri.add(String.join(" - ", (CharSequence[]) kitap));
            }

            kitapListesi.setItems(kitapGoruntuleri);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Kitaplar listelenirken bir hata oluştu.");
        }
    }
}