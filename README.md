# 📚 JavaFX Referans Yönetim Sistemi

Java programlama dili ve JavaFX GUI kütüphanesi kullanılarak geliştirilmiş bir **metin referans takip uygulaması**.

## 📋 Proje Hakkında

Bu uygulama, akademik yazılar veya makaleler yazarken kaynak referanslarını kolayca yönetmenizi sağlar. HTML metin editörü içinde köşeli parantez içine yazılan sayıları kullanarak, seçili kütüphanedeki kitap bilgilerinden otomatik olarak kaynakça oluşturur.

### ✨ Özellikler

- **Kullanıcı Yönetimi**: Kullanıcı kayıt ve giriş sistemi
- **Kütüphane Yönetimi**: Birden fazla kütüphane oluşturma ve yönetme
- **Kitap Yönetimi**: Kitap ekleme, listeleme ve silme
- **Otomatik Kaynakça**: `[1]`, `[2]` gibi referansları otomatik olarak kaynakça formatına çevirme
- **Referans Formatları**: MLA ve APA formatlarında kaynakça oluşturma
- **HTML Editör**: Zengin metin düzenleme desteği
- **CSV Desteği**: Veriler CSV dosyalarında saklanır

## 🏗️ Proje Yapısı

```
JavaFxReference/
├── src/
│   ├── module-info.java          # Java modül tanımlaması
│   ├── kitaplar.csv              # Varsayılan kitap verileri
│   ├── kullanicilar.csv          # Kullanıcı verileri
│   │
│   ├── model/                    # Model sınıfları
│   │   ├── Main.java             # Uygulama giriş noktası
│   │   ├── Kitap.java            # Kitap model sınıfı
│   │   ├── Kullanici.java        # Kullanıcı model sınıfı
│   │   ├── Kutuphane.java        # Kütüphane model sınıfı
│   │   └── Referans.java         # Referans temel sınıfı
│   │
│   ├── Scenes/                   # JavaFX sahneleri ve kontrolcüler
│   │   ├── Login.fxml            # Giriş ekranı arayüzü
│   │   ├── Login_control.java    # Giriş ekranı kontrolcüsü
│   │   ├── NewUser.fxml          # Yeni kullanıcı ekranı
│   │   ├── NewUser_control.java  # Yeni kullanıcı kontrolcüsü
│   │   ├── WritingArea.fxml      # Ana yazım alanı arayüzü
│   │   ├── WritingArea_control.java # Yazım alanı kontrolcüsü
│   │   ├── kitapListele.fxml     # Kitap listeleme ekranı
│   │   ├── YeniKitapEkle.fxml    # Yeni kitap ekleme ekranı
│   │   ├── YeniKutuphaneEkle.fxml # Yeni kütüphane ekleme ekranı
│   │   └── Completed.fxml        # Tamamlama ekranı
│   │
│   ├── Csv_Commends/             # CSV işlemleri
│   │   └── CsvKomut.java         # CSV okuma/yazma komutları
│   │
│   └── resources/                # CSS ve görseller
│       ├── *.css                 # Buton stilleri
│       └── images/               # Uygulama görselleri
│
└── README.md
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler

- **Java JDK 11+**
- **JavaFX SDK 11+**

### Adımlar

1. Projeyi klonlayın:
   ```bash
   git clone <repo-url>
   cd JavaFxReference
   ```

2. JavaFX modüllerini ekleyerek çalıştırın:
   ```bash
   java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml,javafx.web -cp . model.Main
   ```

3. Veya IDE üzerinden (IntelliJ IDEA, Eclipse) çalıştırabilirsiniz.

## 📖 Kullanım

1. **Hesap Oluşturma**: Uygulamayı ilk açtığınızda "Yeni Kullanıcı" butonuna tıklayarak hesap oluşturun.

2. **Giriş Yapma**: Oluşturduğunuz kullanıcı adı ve şifre ile giriş yapın.

3. **Kütüphane Seçimi**: Her kullanıcıya varsayılan bir kütüphane atanır. ComboBox'tan kütüphane seçebilirsiniz.

4. **Kitap Ekleme**: "Yeni Kitap Ekle" butonu ile kütüphanenize kitap ekleyebilirsiniz.

5. **Referans Kullanımı**: Metin yazarken `[1]`, `[2]` şeklinde referans numaraları kullanın. Uygulama otomatik olarak tablodaki kitaplardan kaynakça oluşturur.

6. **Format Seçimi**: MLA veya APA formatını seçerek kaynakçanızı istediğiniz stilde oluşturun.

## 🛠️ Teknolojiler

| Teknoloji | Kullanım Alanı |
|-----------|----------------|
| Java | Backend mantığı |
| JavaFX | GUI framework |
| FXML | Arayüz tasarımı |
| CSS | Stil ve görünüm |
| CSV | Veri saklama |

## 📝 Örnek Kullanım

```
Yazı içeriği: "Bu konuda Smith'in çalışması [1] önemli bulgular sunmaktadır..."

Otomatik Kaynakça Çıktısı:
[1] Smith, John. "Örnek Kitap Adı." Yayınevi, 2024.
```

## 🤝 Katkıda Bulunma

1. Bu projeyi fork edin
2. Yeni bir branch oluşturun (`git checkout -b feature/yeniOzellik`)
3. Değişikliklerinizi commit edin (`git commit -m 'Yeni özellik eklendi'`)
4. Branch'inizi push edin (`git push origin feature/yeniOzellik`)
5. Pull Request oluşturun

## 📄 Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

---

**Not**: Programı kullanabilmek için kendi hesabınızı oluşturup her kullanıcıya "default" olarak atanan kütüphaneyi referans vermeyi deneyebilirsiniz.
