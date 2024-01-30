# automated-web-testing-jayjay
Projek automation web testing untuk memenuhi tugas dari pelatihan JayJay School Profesional SQA

# build With
Proyek pengujian otomatis melibatkan beberapa library yang dibutuhkan, yaitu
- cucumber framework
- selenium framework
- webdriver manager
- testng
- assertion (tambahan)

# Getting Started

## Prerequisite
Sebelum menjalankan proyek ini, diperluan persyaratan environtmen yang harus disiapkan
1. JDK diatas versi 8
2. Gradle 

## File Configuration
Project ini menggunakan alat build automation Gradle dengan bahasa Groovy. File build.gradle berisi konfigurasi
1. Penganturan dependency cucumber agar dapat mengenali syntax Gherkin
2. Penganturan dependency selenium agar dapat melakukan web locator dan melakukan aksi kepada web element saat melaksanakan eksekusi pengujian
3. Penganturan dependency web driver manager agar dapat menjalankan driver web via selenium
4. Penganturan dependency TestNG agar dapat memutuskan test result (PASS / FAIL)
5. Pengaturan testing dengan kode:
```
useTestNG()
    testLogging {
        events "PASSED", "SKIPPED", "FAILED", "STANDARD_OUT", "STANDARD_ERROR"
    }
    systemProperty "cucumber.filter.tags", System.getProperty("cucumber.filter.tags")
```
7. Penambahan gradle task web testing dengan kode:
```
configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}

tasks.register('webTest') {
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'pretty',
                    '--plugin', 'html:reports/cucumber-web-report.html',
                    '--glue', 'stepdefinitions',
                    '--tags', "@web",
                    'src/test/resources/features']
        }
    }
}
```   
9. 

# Struture Project Test
Tujuan project adalah proses pengujian automation web, sehingga kode program tersimpan dalam package test. Adapun struktur package sbb:
```
{nama proyek}
  src
    java
    test
      java
        helper
          Utility.java
        pages
          {nama halaman}Page.java
        runner
          TestRunner.java
        stepdefinitions
          Hooks.java
          {nama halaman}Test.java
      resorces
        feature
          {nama halaman}.feature
    
```
- package helper berisi property supporting project, inisiasi driver web dan fungsi-fungsi umum untuk mendukung eksekusi pengujian
- package pages berisi test pemrograman dalam bentuk lower code yang akan menjalankan scenario step. 
- package runner berisi class java untuk pengaturan eksekusi pengujian dan pengaturan test report
- package stepdefinitions berisi kumpulan fungsi yang menghubungkan Gehrkin Steo dengan logika pemgogramannya
- package feature berisi daftar file yang mengandung skenario pengujian dalam bahasa Gherkin
  
# Workflow
Langkah pembuatan test script
1. Buat feature file yang mengandung langkah-langkah pengujia dalam bahasa natural
2. Buat kelas stepdefinition dalam bahasa java untuk melakukan panggilan method dari test pemrograman dalam pakacge pages
3. Buast test logic masing-masing operasi halaman. Wujud implementasinya biasanya melakukan web locator untuk mendapatkan web element dan pembuatan aksi yang dapat diberikan pada web elemen tersebut
4. Jika ada library lain yang dibutuhkan, maka dapat menambahkan pada file build.gradle bagian dependency
5. Jika ada test implementation yang bersifat umum untuk mendukung eksekusi pengujian, maka penambahan kode dapat dilakukan pada Class Utility atau membuat class baru pada package helper 

# How to Run Execution Testing
Proses menjalankan eksekusi testing teridiri dari dua cara, yaitu Terminal dan Class testRunner

## Terminal
Proses menjalankan eksekusi testing melalui terminal dengan menjalankan kode berikut:
```
gradle webTest
```
Namun, sebelumnya harus dilakukan build terlebih dahulu agar library dependency sudah terkonfigurasi pada project. Kode build sbb:
```
gradle build
```
Tambahan, developer dapat melakukan clean library jika terjadi error pada saat build project dengan kode:
```
gradle clean
```
atau bisa juga clean dan build project dapat dilakukan secara bersama-sama dengan mengetikan kode:
```
gradle clean build
```

# Author
Asri Maspupah
Jurusan Teknik Komputer dan Informatika
Politeknik Negeri Bandung

# Acknowledgments
Daftar resource yang dapat dipelajari
- <a href="https://www.selenium.dev/documentation/">Selenium documentation</a>
- <a href="https://cucumber.io/docs/cucumber/">Cucumber documentation</a>
- <a href="https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html">TestNg documentation</a>
- <a href="https://gradle.org/install/">Tutorial Gradle Instalasi</a>
- <a href="https://www.youtube.com/playlist?list=PL-CtdCApEFH8yGJzfU_gners0ybO4MlrV">Gradle Tutotrial</a>


