# 🌳 Agac Plugin Kurulum Talimatları

## 📋 Gereksinimler

- **Minecraft Sunucu**: 1.21.7 sürümü
- **Server Software**: Spigot veya Paper
- **Java**: 17 veya üzeri
- **RAM**: En az 2GB (sunucu için)

## 🚀 Kurulum Adımları

### 1. Plugin Dosyasını İndirin
- `target/agac-1.0.0.jar` dosyasını sunucunuzun `plugins` klasörüne kopyalayın

### 2. Sunucuyu Yeniden Başlatın
- Sunucuyu kapatın
- Sunucuyu tekrar başlatın
- Plugin otomatik olarak yüklenecektir

### 3. Kurulumu Doğrulayın
- Sunucu konsolunda şu mesajı görmelisiniz:
  ```
  [INFO] Agac plugin başarıyla yüklendi!
  ```

## ⚙️ Konfigürasyon

### Varsayılan Ayarlar
Plugin ilk çalıştırıldığında `plugins/Agac/config.yml` dosyası otomatik olarak oluşturulur.

### Önemli Ayarlar
```yaml
tree-breaking:
  animation-speed: 2  # Animasyon hızı (tick cinsinden)
  
  extra-drops:
    stick-chance: 10.0      # Odun kırarken çubuk düşme şansı (%)
    apple-chance: 5.0       # Yaprak kırarken elma düşme şansı (%)
    leaf-stick-chance: 2.0  # Yaprak kırarken çubuk düşme şansı (%)
```

## 🎮 Kullanım

### Oyuncular İçin
1. Elinizde herhangi bir balta tutun
2. Herhangi bir ağaç odununa vurun
3. Ağaç otomatik olarak kökünden kırılacak
4. Tüm odunlar ve yapraklar envanterinize eklenecek

### Yöneticiler İçin
- `/agac reload` - Plugin'i yeniden yükle
- `/agac info` - Plugin bilgilerini göster
- `/agac version` - Plugin versiyonunu göster

## 🔒 İzinler

- `agac.usetree` - Ağaç kırma özelliğini kullanma (varsayılan: true)
- `agac.admin` - Yönetici komutları (varsayılan: op)

## 🛠️ Desteklenen Araçlar

- Tahta Balta
- Taş Balta
- Demir Balta
- Elmas Balta
- Netherite Balta

## 🌲 Desteklenen Ağaç Türleri

### Odunlar
- Meşe (Oak)
- Huş (Birch)
- Ladin (Spruce)
- Orman (Jungle)
- Akasya (Acacia)
- Koyu Meşe (Dark Oak)
- Mangrov (Mangrove)
- Kiraz (Cherry)
- Bambu (Bamboo)
- Kızıl Kök (Crimson Stem)
- Çarpık Kök (Warped Stem)

### Yapraklar
- Tüm ağaç yaprakları
- Nether yaprakları
- Mantar blokları

## ❗ Sorun Giderme

### Plugin Yüklenmiyor
- Java 17+ yüklü olduğundan emin olun
- Sunucu loglarını kontrol edin
- Plugin dosyasının doğru klasörde olduğunu kontrol edin

### Ağaç Kırılmıyor
- Oyuncunun `agac.usetree` iznine sahip olduğunu kontrol edin
- Oyuncunun elinde balta olduğunu kontrol edin
- Ağaç türünün desteklendiğini kontrol edin

### Performans Sorunları
- `config.yml` dosyasında `animation-speed` değerini artırın
- Sunucu RAM'ini artırın
- Diğer plugin'leri devre dışı bırakarak test edin

## 📞 Destek

Herhangi bir sorun yaşarsanız:
1. Sunucu loglarını kontrol edin
2. Plugin ayarlarını gözden geçirin
3. GitHub üzerinden issue açın

## 🔄 Güncelleme

1. Eski plugin dosyasını yedekleyin
2. Yeni JAR dosyasını `plugins` klasörüne kopyalayın
3. Sunucuyu yeniden başlatın
4. `config.yml` dosyasını kontrol edin (gerekirse yedekten geri yükleyin)

---

**Not**: Bu plugin Minecraft 1.21.7 sürümü için optimize edilmiştir. Daha eski sürümlerde çalışmayabilir.