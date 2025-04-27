package model;
import Csv_Commends.CsvKomut;

import java.io.IOException;
import java.util.ArrayList;

public class Kutuphane {
    public ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();
    public String kutuphaneAdi;
    public String dosyaAdi;
    private  int sira = 1;

    // Kütüphane nesneleri CSV dosyaları kullanılırak oluşturulur.
    public Kutuphane(String kutuphaneAdi, String dosyaAdi) {
        this.kutuphaneAdi = kutuphaneAdi;
        this.dosyaAdi = dosyaAdi;
        // Dosya adına sahip csv dosyasındaki her bir satırdan kitap nesnesini oluşturur
        // ve kütüphaneye ekler.
        try {
            ArrayList<Object[]> kitapVeri = CsvKomut.veriCıkart("src\\"+dosyaAdi+".csv");
            for (int i = 1; i < kitapVeri.size(); i++) {
                this.kitapEkle(kitapVeri.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void kitapEkle(Object [] kitapVerisi) {
        this.kitaplar.add(new Kitap(kitaplar.size() + 1, (String)kitapVerisi[0], (String)kitapVerisi[1],(String) kitapVerisi[2],(String) kitapVerisi[3],(String) kitapVerisi[4]));
        sira ++;
    }

    public ArrayList<Kitap> getKitaplar() {
        return this.kitaplar;
    }
}
