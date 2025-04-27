package model;
import java.util.ArrayList;

public class Kullanici {
    public static Kullanici mainKullanici;
    public static int kullaniciSayisi = 0;

    public static ArrayList<Kullanici> kullanicilar= new ArrayList<Kullanici>();;
    private String ad;
    private String sifre;
    public ArrayList<Kutuphane> kutuphaneler = new ArrayList<>();

    public Kullanici(String ad, String sifre) {
        this.ad = ad;
        this.sifre = sifre;
        kullaniciSayisi ++;
    }

    public String getAd() {
        return ad;
    }

    public String getSifre() {
        return sifre;
    }


    public void kutuphaneEkle(Kutuphane kutuphane) {
        kutuphaneler.add(kutuphane);
    }

    public void kullaniciBilgileriGoster() {
        System.out.println("Kullanıcı Adı: " + ad);
        System.out.println("Kütüphaneler:");

    }

}
