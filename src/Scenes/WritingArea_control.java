package Scenes;
import Csv_Commends.CsvKomut;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import model.Kitap;
import model.Kullanici;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WritingArea_control implements Initializable {
    @FXML
    private Button button;
    @FXML
    private Button butCikisYap;
    @FXML
    private Button butKutEkle;
    @FXML
    private Button butcomboYenile;
    @FXML
    private Button butTamamla;
    @FXML
    private Button butYeniKitEkle;

    @FXML
    private RadioButton radioAPA;

    @FXML
    private RadioButton radioMLA;

    @FXML
    private Label label;
    @FXML
    private ToggleGroup referans;

    @FXML
    private HTMLEditor yazmabölgesi;

    @FXML
    private TextArea yakalananlar;

    @FXML
    private TableView<Kitap> KitapTablosu;

    @FXML
    private TableColumn<Kitap, String> colkitapAdi;

    @FXML
    private TableColumn<Kitap, String> colyazar;

    @FXML
    private TableColumn<Kitap, Integer> colsira;

    @FXML
    private TableColumn<Kitap, String> colyayinEvi;

    @FXML
    private Label labelMainKul;
    @FXML
    public ComboBox<String> comboKutuphane;

    private Stage stage;
    private Scene scene;
    private Stage stage2;
    private Parent root;
    private Stage stage3 = null;
    private Stage stage4 = null;
    private String yakalananlar2;
    public  static  int ind;

    // Tabloda gösterilecek kitaplar bu liste içinde tutulur.
    private ObservableList<Kitap> list = FXCollections.observableArrayList();

    // Combobox içinde gösterilecek kütüphaneler bu liste içinde tutulur.
    private ObservableList<String> list2 = FXCollections.observableArrayList();
    private RadioButton secilibuton;

    // Referans yakalamada kullanılan nesneler
    private Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
    private Matcher matcher;
    ArrayList<String> foundNumbers = new ArrayList<>();
    String metin;

    @FXML
    // Kaynakça yakalama kodu
    void selam() {
        yazmabölgesi.setOnKeyPressed(event -> {
            metin = yazmabölgesi.getHtmlText();
            Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
            Matcher matcher = pattern.matcher(metin);
            foundNumbers.clear();
            while (matcher.find()) {
                // Köşeli parantez içindeki sayılar bu listeye atılır.
                foundNumbers.add(matcher.group(1));
            }
            // Çıktı alanına yaz
            yakalananlar2 = "";
            for (int i = 0; i < foundNumbers.size(); i++) {
                yakalananlar2 += (foundNumbers.get(i)+"\n"+ list.get(Integer.parseInt(foundNumbers.get(i))-1).toString()+"\n");
            }
            yakalananlar.setText(yakalananlar2);
        });
    }
    @FXML
    // ComboBox'ta seçim yaparsak tablodaki kitaplar güncellenir.
    void KitapListeYenile(ActionEvent event) {
        list.clear();
        ind = comboKutuphane.getSelectionModel().getSelectedIndex();
        list.addAll(Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar);
        KitapTablosu.setItems(list);

    }
    @FXML
    // Yeni kütüphane eklemek için stage açar
    void yeniKutEkleSayfaAc(ActionEvent event) throws IOException {

        if (stage2 == null || !stage2.isShowing()) {
            stage2 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("YeniKutuphaneEkle.fxml"));
            Scene newScene = new Scene(root);
            stage2.setScene(newScene);
            stage2.setResizable(false);
            stage2.show();
        }
        else {
            stage2.toFront();
        }
    }

    @FXML
    // Yeni kitap eklemek için sayfa açar
    void yeniKitEkleSayfaAc(ActionEvent event) throws IOException {
        System.out.println("sasasasasa");
        if (stage4 == null || !stage4.isShowing()) {
            stage4 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("YeniKitapEkle.fxml"));
            Scene newScene = new Scene(root);
            stage4.setScene(newScene);
            stage4.setResizable(false);
            stage4.show();
        } else {
            stage4.toFront();
        }
    }

    @FXML
    // Yenile tutuşna basınca combobox'taki seçenekler güncellenir
    public void comboYenile(ActionEvent event) {
        int ind = comboKutuphane.getSelectionModel().getSelectedIndex();
        System.out.println(ind);
        list2.clear();
        for (int i = 0; i <Kullanici.mainKullanici.kutuphaneler.size(); i++){
            try {
                list2.add(Kullanici.mainKullanici.kutuphaneler.get(i).kutuphaneAdi);
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("BU HATA MESAJI ÇALIŞTI");
            }
        }
        comboKutuphane.setItems(list2);
        System.out.println(list2.get(ind));
        comboKutuphane.setValue(list2.get(ind));
    }
    @FXML
    // Kütüphaneden kitap kaldırır ve tabloyu yeniler
    void kitKaldir(ActionEvent event) {
        Kitap seciliKitap = KitapTablosu.getSelectionModel().getSelectedItem();
        IntegerProperty kaldirilanSira = seciliKitap.sıraProperty();
        int sira = kaldirilanSira.intValue();
        list.remove(seciliKitap);
        ind = comboKutuphane.getSelectionModel().getSelectedIndex();
        Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar.remove(seciliKitap);
        System.out.println(Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar.size());
        Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar.remove(seciliKitap);
        for (int i = 1; i <= Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar.size(); i++) {
            Kullanici.mainKullanici.kutuphaneler.get(ind).kitaplar.get(i-1).setSira(i);
        }
        KitapTablosu.setItems(list);
    }
    @FXML
    // Referansı oluşturulmuş yazı için yeni sayfa açar
    void goToCompletedScene(ActionEvent event) throws IOException {
        secilibuton = (RadioButton) referans.getSelectedToggle();

        if (stage3 == null || !stage3.isShowing()) {
            stage3 = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Completed.fxml"));
            Parent root = loader.load();

            // Completed scene kontrolcüsünü al
            Completed_control completedControl = loader.getController();

            // Referansları sırayla Kaynakça sahnesine MLA formatında ekle
            StringBuilder kaynakca = new StringBuilder();

            Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
            Matcher matcher = pattern.matcher(metin);
            int sayi = 1;
            StringBuffer düzenliMetin = new StringBuffer();

            // Metinde köşeli parantez içindeki sayıları düzenler.
            while (matcher.find()) {
                matcher.appendReplacement(düzenliMetin, "[" + sayi + "]");
                sayi++;
            }
            matcher.appendTail(düzenliMetin);
            kaynakca.append(düzenliMetin.toString());

            // Kaynakçayı istenen şekilde düzenler.
            if (secilibuton.getText().equals("APA Ver 7")){
                System.out.println("apa verin içine girdi");
                for (int i = 0; i < foundNumbers.size(); i++) {
                int index = Integer.parseInt(foundNumbers.get(i)) - 1;
                if (index >= 0 && index < list.size()) {
                    Kitap kitap = list.get(index);
                    kaynakca.append("[").append(i + 1).append("] ")
                            .append(kitap.apaTypeFonksiyonum()).append("<br>");
                }
            }}
            else if (secilibuton.getText().equals("MLA Ver 9")){
                System.out.println("mla verin içine girdi");
                for (int i = 0; i < foundNumbers.size(); i++) {
                    int index = Integer.parseInt(foundNumbers.get(i)) - 1;
                    if (index >= 0 && index < list.size()) {
                        Kitap kitap = list.get(index);
                        kaynakca.append("[").append(i + 1).append("] ")
                                .append(kitap.mlaTypeFonksiyonum()).append("<br>");
                    }
                }
            }
            // Controller üzerinden TextArea'ya metin ekleme
            completedControl.setKaynakcaText(kaynakca.toString());

            Scene newScene = new Scene(root);
            stage3.setScene(newScene);
            stage3.setResizable(false);
            stage3.show();
        } else {
            stage3.toFront();
        }
    }

    @FXML
    // Login sayfasına yönlendirir.
    void CikisYap(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    // WRİTİNG AREA AÇILIRKEN İLK ÇALIŞAN FONKSİYON
    public void initialize(URL url, ResourceBundle resourceBundle){

        // Kitap tablosunu yüklenir
        for (int i = 0; i < Kullanici.mainKullanici.kutuphaneler.get(0).kitaplar.size(); i++) {
                list.add(Kullanici.mainKullanici.kutuphaneler.get(0).kitaplar.get(i));
        }
        colsira.setCellValueFactory(cellData -> cellData.getValue().sıraProperty().asObject());
        colkitapAdi.setCellValueFactory(new PropertyValueFactory<>("KitapAdi"));
        colyazar.setCellValueFactory(new PropertyValueFactory<>("Yazarİsmi"));
        colyayinEvi.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        KitapTablosu.setItems(list);
        labelMainKul.setText("Kullanıcı: "+Kullanici.mainKullanici.getAd());

        // Kütüphane seçme kutusu yüklenir
        for (int i = 0; i <Kullanici.mainKullanici.kutuphaneler.size(); i++) {
           list2.add(Kullanici.mainKullanici.kutuphaneler.get(i).kutuphaneAdi);
        }
        comboKutuphane.setItems(list2);
        comboKutuphane.setValue(list2.get(0));
    }
}
