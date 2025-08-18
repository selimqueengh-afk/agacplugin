# 🔒 Güvenlik Politikası

## 🚨 Güvenlik Açıkları

Eğer Agac Plugin'de bir güvenlik açığı bulduysanız, lütfen **GİZLİ** olarak bildirin. Güvenlik açıklarını public issue olarak açmayın.

## 📧 Güvenlik Açığı Bildirimi

### Email ile Bildirim
Güvenlik açıklarını şu email adresine bildirin:
- **Email**: security@agac-plugin.com
- **Konu**: [SECURITY] Güvenlik Açığı Açıklaması

### GitHub Security Advisories
GitHub'ın Security Advisories özelliğini kullanarak bildirim yapabilirsiniz:
1. Repository'de "Security" sekmesine gidin
2. "Report a vulnerability" butonuna tıklayın
3. Güvenlik açığını detaylandırın

## 📋 Bildirim İçeriği

Güvenlik açığı bildiriminde şu bilgileri ekleyin:

- **Açıklama**: Güvenlik açığının ne olduğu
- **Etki**: Hangi sistemleri etkilediği
- **Tekrar Üretme**: Açığın nasıl tekrar üretileceği
- **Önerilen Çözüm**: Nasıl düzeltilmesi gerektiği
- **İletişim**: Size nasıl ulaşılacağı

## ⏱️ Yanıt Süresi

- **İlk Yanıt**: 24 saat içinde
- **Değerlendirme**: 48 saat içinde
- **Düzeltme**: Kritik açıklar için 7 gün, diğerleri için 30 gün

## 🛡️ Güvenlik Önlemleri

### Kod Güvenliği
- Tüm input'lar validate edilir
- SQL injection koruması
- XSS koruması
- Command injection koruması

### Dependency Güvenliği
- Düzenli güvenlik taramaları
- Güvenlik açığı olan dependency'ler güncellenir
- Maven dependency check kullanılır

### Runtime Güvenliği
- Plugin izinleri kontrol edilir
- Dosya sistemi erişimi kısıtlanır
- Network erişimi kontrol edilir

## 🔍 Güvenlik Taramaları

### Otomatik Taramalar
- **GitHub Code Scanning**: Her commit'te
- **Dependency Check**: Her build'de
- **Security Audit**: Haftalık

### Manuel Taramalar
- **Code Review**: Her PR'da
- **Penetration Testing**: Aylık
- **Security Assessment**: Çeyreklik

## 📚 Güvenlik Dokümantasyonu

- **Güvenlik Özellikleri**: Plugin'in güvenlik özellikleri
- **İzin Sistemi**: Plugin izinlerinin nasıl çalıştığı
- **Güvenlik Ayarları**: Güvenlik konfigürasyonu

## 🏆 Güvenlik Katkıları

Güvenlik açığı bildirenler için:
- **Hall of Fame**: Güvenlik katkıları listesi
- **Teşekkür**: Public teşekkür mesajı
- **Kredi**: Release notlarında kredi

## 📞 İletişim

Güvenlik ile ilgili sorularınız için:
- **Email**: security@agac-plugin.com
- **GitHub**: Security tab'ından
- **Discord**: Güvenlik kanalı

---

**Not**: Bu güvenlik politikası, plugin'in güvenliğini sağlamak için sürekli güncellenir.