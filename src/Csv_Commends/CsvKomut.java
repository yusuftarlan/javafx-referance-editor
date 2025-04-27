package Csv_Commends;

import java.io.*;
import java.util.ArrayList;

// Programda kullanılan dosya işlemleri için hazır fonksiyonlar tanımlanmıştır.
public class CsvKomut {

    // CSV DOSYASININ İÇİNDEKİ VERİLERİ ARRAYLİST OLARAK DÖNDÜRÜR(BAŞLIK DAHİL)
    public static ArrayList<Object[]> veriCıkart(String file) throws IOException {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            line = br.readLine();
            ArrayList<Object[]> data = new ArrayList<>();
            while (line != null){
                data.add(line.split(","));
                line = br.readLine();
            }

            return data;
        }
    }
    // CSV DOSYASININ EN ALTINA 1 SATIR EKLER
    public static void satirEkle(String [] veri,String dosya) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dosya,true))){
            bw.write("\n"+veri[0]+","+veri[1]+","+veri[2]+","+veri[3]+","+veri[4]);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void kullaniciEkle(String [] veri,String dosya) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dosya,true))){
            bw.write("\n"+veri[0]+","+veri[1]);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
