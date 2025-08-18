# 🤝 Katkı Sağlama Rehberi

Agac Plugin'e katkı sağlamak istediğiniz için teşekkürler! Bu rehber, projeye nasıl katkı sağlayacağınızı açıklar.

## 🚀 Hızlı Başlangıç

### 1. Repository'yi Fork Edin
- GitHub'da bu repository'yi fork edin
- Fork'u local bilgisayarınıza clone edin

### 2. Geliştirme Ortamını Hazırlayın
```bash
git clone https://github.com/YOUR_USERNAME/agac.git
cd agac
```

### 3. Gerekli Araçlar
- **Java**: 17 veya üzeri
- **Maven**: 3.6 veya üzeri
- **IDE**: IntelliJ IDEA, Eclipse veya VS Code

### 4. Projeyi Derleyin
```bash
mvn clean package
```

## 🔧 Geliştirme

### Kod Standartları
- Java naming conventions'larına uyun
- Açıklayıcı değişken ve method isimleri kullanın
- Her public method için JavaDoc ekleyin
- Kod satır uzunluğu 120 karakteri geçmesin

### Commit Mesajları
```
feat: yeni özellik eklendi
fix: hata düzeltildi
docs: dokümantasyon güncellendi
style: kod formatı düzeltildi
refactor: kod yeniden düzenlendi
test: test eklendi
chore: build araçları güncellendi
```

### Branch Stratejisi
- `main`: Ana branch, sadece release'ler için
- `develop`: Geliştirme branch'i
- `feature/özellik-adı`: Yeni özellikler için
- `fix/hata-adı`: Hata düzeltmeleri için

## 📝 Pull Request Oluşturma

### 1. Feature Branch Oluşturun
```bash
git checkout -b feature/yeni-ozellik
```

### 2. Değişiklikleri Yapın
- Kodunuzu yazın
- Test edin
- Commit edin

### 3. Push Edin
```bash
git push origin feature/yeni-ozellik
```

### 4. Pull Request Oluşturun
- GitHub'da Pull Request oluşturun
- Açıklayıcı başlık ve açıklama yazın
- Template'i doldurun

## 🧪 Test Etme

### Unit Testler
```bash
mvn test
```

### Plugin Testi
1. Plugin'i derleyin: `mvn clean package`
2. JAR dosyasını test sunucunuza kopyalayın
3. Sunucuyu başlatın ve test edin

### Test Senaryoları
- [ ] Ağaç kırma çalışıyor
- [ ] Animasyonlar düzgün
- [ ] Drop sistemi çalışıyor
- [ ] İzinler çalışıyor
- [ ] Komutlar çalışıyor

## 📋 Pull Request Template

```markdown
## 📝 Açıklama
Bu PR ne yapıyor?

## ✨ Yeni Özellikler
- [ ] Yeni özellik 1
- [ ] Yeni özellik 2

## 🐛 Hata Düzeltmeleri
- [ ] Hata 1 düzeltildi
- [ ] Hata 2 düzeltildi

## 🧪 Test Edildi
- [ ] Unit testler geçiyor
- [ ] Plugin test edildi
- [ ] Sunucuda test edildi

## 📸 Ekran Görüntüleri
Varsa ekran görüntüleri ekleyin

## 📚 Dokümantasyon
- [ ] README güncellendi
- [ ] KURULUM.md güncellendi
- [ ] Yeni dokümantasyon eklendi
```

## 🔍 Code Review Süreci

1. **Otomatik Kontroller**: GitHub Actions otomatik olarak derleme ve test yapar
2. **Code Review**: En az bir maintainer tarafından review edilir
3. **Test**: Değişiklikler test edilir
4. **Merge**: Onay sonrası merge edilir

## 🚫 Yapılmaması Gerekenler

- ❌ Main branch'e direkt push yapmayın
- ❌ Test edilmemiş kod göndermeyin
- ❌ Büyük değişiklikleri tek PR'da yapmayın
- ❌ Commit mesajlarında açıklayıcı olmayın

## 🆘 Yardım

- **Issues**: Bug report'ları ve özellik istekleri için
- **Discussions**: Genel sorular için
- **Wiki**: Detaylı dokümantasyon için

## 📜 Lisans

Bu projeye katkı sağlayarak, katkılarınızın MIT lisansı altında yayınlanacağını kabul etmiş olursunuz.

---

**Teşekkürler!** 🎉