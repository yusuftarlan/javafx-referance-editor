package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Kitap extends Referans{
    public String kitapAdi,mlaTipDonus,apaTipDonus;
    private String yazarAdi,yazarSoyadi, yazarİsmi;
    private String publisher,yayinTarihi;
    IntegerProperty  sira;

    public Kitap(int sira, String kitapAdi, String yazarAdi, String yazarSoyadi, String publisher, String yayinTarihi) {
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.yazarİsmi= yazarAdi + " " + yazarSoyadi;
        this.yazarSoyadi=yazarSoyadi;
        this.publisher=publisher;
        this.yayinTarihi=yayinTarihi;
        this.sira= new SimpleIntegerProperty(sira);
    }
    public Kitap(int sira, Object [] kitapVerisi){
        this.kitapAdi = (String)kitapVerisi[0];
        this.yazarAdi = (String)kitapVerisi[1];
        this.yazarSoyadi=(String) kitapVerisi[2];
        this.yazarİsmi= yazarAdi + " " + yazarSoyadi;
        this.publisher= (String)kitapVerisi[3];
        this.yayinTarihi= (String)kitapVerisi[4];
        this.sira= new SimpleIntegerProperty(sira);
    }

    public IntegerProperty sıraProperty() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira.set(sira);
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public String getYazarİsmi() {
        return yazarİsmi;
    }

    public void setYazarİsmi(String yazarİsmi) {
        this.yazarİsmi = yazarİsmi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getYazarSoyadi() {
        return yazarSoyadi;
    }

    public void setYazarSoyadi(String yazarSoyadi) {
        this.yazarSoyadi = yazarSoyadi;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    @Override
    public String toString() {
        return this.kitapAdi + " " + this.yazarAdi;
    }

    //MLA tipi referans döndüren fonksiyon
    public String mlaTypeFonksiyonum(){
        mlaTipDonus=this.yazarSoyadi+", "+this.yazarAdi+". "+this.kitapAdi+". "+this.publisher+", "+this.yayinTarihi+".";
        return mlaTipDonus;
    }

    //APA tipi referans döndüren fonksiyon
    public String apaTypeFonksiyonum(){
        apaTipDonus=this.yazarSoyadi+", "+this.yazarAdi.substring(0,1)+". ("+this.yayinTarihi+")."+this.kitapAdi+". "+this.publisher+". ";
        return apaTipDonus;
    }
}
