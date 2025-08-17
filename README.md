# 🌳 Agac Plugin

[![Build and Release](https://github.com/agac/agac/actions/workflows/release.yml/badge.svg)](https://github.com/agac/agac/actions/workflows/release.yml)
[![PR Check](https://github.com/agac/agac/actions/workflows/pr-check.yml/badge.svg)](https://github.com/agac/agac/actions/workflows/pr-check.yml)

Minecraft 1.21.7 sunucuları için gelişmiş ağaç kırma plugin'i.

## ✨ Özellikler

- **Otomatik Ağaç Kırma**: Bir ağaç bloğunu kırdığınızda tüm ağaç otomatik olarak kırılır
- **Gerçekçi Animasyon**: Ağaçlar yukarıdan aşağıya doğru animasyonlu olarak kırılır
- **Otomatik Drop**: Kırılan odunlar ve yapraklar otomatik olarak envanterinize eklenir
- **Ekstra Drop Şansları**: Çubuk ve elma gibi ekstra item'lar düşme şansı
- **Balta Gereksinimi**: Sadece balta ile ağaç kırılabilir
- **Tüm Ağaç Türleri**: Vanilla Minecraft'taki tüm ağaç türleri desteklenir

## 🚀 Kurulum

1. Plugin JAR dosyasını sunucunuzun `plugins` klasörüne kopyalayın
2. Sunucuyu yeniden başlatın
3. Plugin otomatik olarak yüklenecektir

## 📋 Gereksinimler

- **Minecraft**: 1.21.7
- **Server Software**: Spigot/Paper
- **Java**: 17+

## 🎮 Kullanım

### Oyuncular İçin
- Elinizde herhangi bir balta tutun
- Herhangi bir ağaç odununa vurun
- Ağaç otomatik olarak kökünden kırılacak ve tüm bloklar envanterinize eklenecek

### Yöneticiler İçin
- `/agac reload` - Plugin'i yeniden yükle
- `/agac info` - Plugin bilgilerini göster
- `/agac version` - Plugin versiyonunu göster

## 🔧 Konfigürasyon

Plugin ayarları `config.yml` dosyasından düzenlenebilir:

- Animasyon hızı
- Ekstra drop şansları
- Desteklenen ağaç türleri
- Desteklenen araçlar

## 📁 Desteklenen Ağaç Türleri

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

## 🛠️ Desteklenen Araçlar

- Tahta Balta
- Taş Balta
- Demir Balta
- Elmas Balta
- Netherite Balta

## 🔒 İzinler

- `agac.usetree` - Ağaç kırma özelliğini kullanma (varsayılan: true)
- `agac.admin` - Yönetici komutları (varsayılan: op)

## 📝 Lisans

Bu plugin MIT lisansı altında lisanslanmıştır.

## 🤝 Destek

Herhangi bir sorun yaşarsanız veya öneriniz varsa, lütfen GitHub üzerinden issue açın.

## 🔄 Güncellemeler

### v1.0.0
- İlk sürüm
- Temel ağaç kırma özelliği
- Animasyonlu kırma
- Otomatik drop sistemi
- Konfigürasyon dosyası
- Yönetici komutları