# 🚀 GitHub Actions Kullanım Rehberi

Bu dosya, Agac Plugin'in GitHub Actions ile otomatik derleme ve release sürecini açıklar.

## 📋 Workflow'lar

### 1. 🚀 Release Workflow (`.github/workflows/release.yml`)

**Ne Zaman Çalışır:**
- `main` veya `master` branch'e push yapıldığında
- Manuel olarak tetiklendiğinde

**Ne Yapar:**
- ✅ Kodu checkout eder
- ✅ Java 17 kurar
- ✅ Maven cache'i kullanır
- ✅ Plugin'i derler (`mvn clean package`)
- ✅ JAR dosyasını artifact olarak yükler
- ✅ Otomatik release oluşturur
- ✅ JAR dosyasını release'e ekler

**Çıktı:**
- Her push'ta otomatik release
- JAR dosyası GitHub Releases'da
- Tag'lar otomatik oluşturulur

### 2. 🔍 PR Check Workflow (`.github/workflows/pr-check.yml`)

**Ne Zaman Çalışır:**
- Pull request oluşturulduğunda
- Pull request güncellendiğinde

**Ne Yapar:**
- ✅ Kodu checkout eder
- ✅ Java 17 kurar
- ✅ Maven cache'i kullanır
- ✅ Plugin'i derler
- ✅ JAR dosyasını PR artifact'ı olarak yükler

**Çıktı:**
- PR'da derleme durumu
- JAR dosyası PR'da indirilebilir
- 1 gün sonra otomatik silinir

### 3. 🔒 Code Scanning Workflow (`.github/workflows/code-scanning.yml`)

**Ne Zaman Çalışır:**
- Push ve PR'larda
- Her Pazar günü otomatik

**Ne Yapar:**
- ✅ CodeQL ile güvenlik analizi
- ✅ OWASP Dependency Check
- ✅ Güvenlik açığı taraması

**Çıktı:**
- Güvenlik raporları
- Dependency güvenlik analizi
- Code quality raporları

## ⚙️ Konfigürasyon

### Maven Cache
```yaml
- name: Cache Maven packages
  uses: actions/cache@v3
  with:
    path: ~/.m2
    key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
    restore-keys: ${{ runner.os }}-m2
```

### Java Setup
```yaml
- name: Set up JDK 17
  uses: actions/setup-java@v4
  with:
    java-version: '17'
    distribution: 'temurin'
    cache: maven
```

### Release Oluşturma
```yaml
- name: Create Release
  uses: softprops/action-gh-release@v1
  with:
    files: target/agac-*.jar
    tag_name: ${{ steps.get_version.outputs.tag }}
    name: Release ${{ steps.get_version.outputs.tag }}
```

## 🔄 Otomatik Süreç

### 1. Commit Push
```
Git Push → GitHub Actions Tetiklenir → Derleme Başlar → JAR Oluşur → Release Oluşturulur
```

### 2. Pull Request
```
PR Oluşturulur → GitHub Actions Tetiklenir → Derleme Kontrolü → JAR Upload → Status Check
```

### 3. Haftalık Güvenlik Taraması
```
Her Pazar → Code Scanning → Güvenlik Analizi → Rapor Oluşturulur
```

## 📊 Workflow Durumları

### ✅ Başarılı
- Yeşil tik işareti
- JAR dosyası oluştu
- Release oluşturuldu

### ❌ Başarısız
- Kırmızı X işareti
- Derleme hatası
- Test hatası

### ⏳ Çalışıyor
- Sarı nokta
- Workflow devam ediyor
- Bekleyin

## 🛠️ Manuel Tetikleme

### Workflow Dispatch
```bash
# GitHub'da manuel olarak tetikleme
1. Actions sekmesine git
2. İstediğin workflow'u seç
3. "Run workflow" butonuna tıkla
4. Branch seç ve çalıştır
```

### API ile Tetikleme
```bash
curl -X POST \
  -H "Authorization: token YOUR_TOKEN" \
  -H "Accept: application/vnd.github.v3+json" \
  https://api.github.com/repos/OWNER/REPO/actions/workflows/WORKFLOW_ID/dispatches
```

## 📁 Artifact'lar

### Release Artifact
- **Konum**: GitHub Releases
- **Dosya**: `agac-1.0.0.jar`
- **Süre**: Kalıcı
- **Erişim**: Herkes

### PR Artifact
- **Konum**: Pull Request
- **Dosya**: `agac-plugin-pr`
- **Süre**: 1 gün
- **Erişim**: PR katılımcıları

### Security Reports
- **Konum**: Actions Artifacts
- **Dosya**: `dependency-check-report`
- **Süre**: 30 gün
- **Erişim**: Repository sahipleri

## 🔧 Sorun Giderme

### Derleme Hatası
```bash
# Local'de test et
mvn clean package

# Java sürümünü kontrol et
java -version

# Maven sürümünü kontrol et
mvn -version
```

### Cache Sorunu
```bash
# GitHub'da cache'i temizle
1. Actions → Cache → Manage caches
2. İlgili cache'i sil
3. Workflow'u tekrar çalıştır
```

### Permission Hatası
```yaml
# Repository settings'de
Settings → Actions → General → Workflow permissions
"Read and write permissions" seç
```

## 📈 Performans Optimizasyonu

### Cache Kullanımı
- Maven dependencies cache'lenir
- Java setup cache'lenir
- Build time: ~2-3 dakika → ~1-2 dakika

### Parallel Jobs
- Code scanning ve dependency check paralel
- Toplam süre azalır

### Conditional Steps
- Sadece main branch'de release
- PR'da sadece build check

## 🔗 Faydalı Linkler

- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Maven GitHub Action](https://github.com/actions/setup-java)
- [Release Action](https://github.com/softprops/action-gh-release)
- [CodeQL](https://codeql.github.com/)
- [OWASP Dependency Check](https://owasp.org/www-project-dependency-check/)

---

**Not**: Bu workflow'lar her commit'te otomatik olarak çalışır ve plugin'inizi güncel tutar.