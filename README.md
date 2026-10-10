# 📐 Tugas PBO – Inheritance & Polymorphism (Geometri)

Repository ini berisi tugas mata kuliah **Pemrograman Berorientasi Objek (PBO)** berupa program Java yang memodelkan bangun datar dan ruang menggunakan konsep **Inheritance (Pewarisan)**, **Method Overriding**, dan **Polymorphism**. 

Studi kasus ini menggunakan hierarki kelas bentuk geometri yang dimulai dari kelas induk `Shape`, diturunkan ke `Square` dan `Circle`, serta turunan bertingkat dari `Circle` menjadi `Cylinder`. Program ini mendemonstrasikan bagaimana sebuah array bertipe kelas induk (`Shape[]`) dapat menampung berbagai macam objek turunan dan memanggil method secara polimorfis.

Dokumen ini memuat struktur proyek, penjelasan kode setiap kelas, cara menjalankan program, serta tangkapan layar hasil eksekusinya.

## 👤 Identitas

| Data | Keterangan |
|---|---|
| 👤 **Nama** | Dahlia Wahyuni|
| 🆔 **NIM** | F1D02510047|
| 🏫 **Kelas** | 3A |
| 📘 **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| 👨‍🏫 **Dosen Pengampu** | Royana Afwani, S.T., M.T. |

---

## 📑 Daftar Isi

1. [📖 Deskripsi Program](#-1-deskripsi-program)
2. [📁 Struktur Proyek](#-2-struktur-proyek)
3. [💻 Penjelasan Kode](#-3-penjelasan-kode)
4. [▶️ Cara Menjalankan](#️-4-cara-menjalankan)
5. [📸 Hasil Program (Screenshot)](#-5-hasil-program-screenshot)
6. [✅ Kesimpulan](#-6-kesimpulan)

---

## 📖 1. Deskripsi Program

Program ini dibuat untuk mempraktikkan pilar-pilar utama Pemrograman Berorientasi Objek, khususnya:
- **Inheritance (`extends`)**: Menurunkan atribut dan method dari kelas induk ke kelas anak agar kode lebih *reusable*.
- **Method Overriding (`@Override`)**: Memodifikasi implementasi method `printInfo()` pada kelas turunan agar sesuai dengan karakteristik bentuknya masing-masing.
- **Polymorphism**: Memungkinkan penggunaan variabel kelas induk (`Shape`) untuk mereferensikan objek dari berbagai kelas turunannya, sehingga pemanggilan method menjadi lebih fleksibel melalui perulangan array.

**🧩 Rancangan Kelas**
- **`Shape` (Superclass)**: Menyimpan atribut dasar berupa `color` (warna) beserta *getter*, *setter*, dan method dasar `printInfo()`.
- **`Square` (Subclass dari `Shape`)**: Menambahkan atribut `side` (sisi), menghitung luas (`area`), dan melakukan *override* pada `printInfo()`.
- **`Circle` (Subclass dari `Shape`)**: Menambahkan atribut `radius` (jari-jari) dan konstanta `PI`, menghitung luas lingkaran, serta melakukan *override* pada `printInfo()`.
- **`Cylinder` (Subclass dari `Circle`)**: Mewarisi sifat lingkaran dan menambahkan atribut `height` (tinggi) untuk menghitung volume tabung, serta melakukan *override* pada `printInfo()`.
- **`Main`**: Kelas utama yang menguji penerapan polimorfisme menggunakan array bertipe `Shape[]`.

---

## 📁 2. Struktur Proyek
.
├── src/
│   ├── Shape.java
│   ├── Square.java
│   ├── Circle.java
│   ├── Cylinder.java
│   └── Main.java
├── .gitignore
└── README.md

### 🔗 Hubungan Pewarisan (Inheritance Hierarchy)
Shape (Superclass)
├── Square (extends Shape)
└── Circle (extends Shape)
└── Cylinder (extends Circle)


---

## 💻 3. Penjelasan Kode

### 🟦 3.1 `Shape.java` (Kelas Induk)
```java
public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo() {
        System.out.println("Shape colored " + color);
    }
}
🟩 3.2 Square.java (Turunan Shape)
Java
public class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    @Override
    public void printInfo() {
        System.out.println("Square colored " + getColor() + ", area = " + area());
    }
}
🟧 3.3 Circle.java (Turunan Shape)
Java
public class Circle extends Shape {
    protected double radius;
    public static final double PI = 3.14;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle " + getColor() + ", area = " + area());
    }
}
🟨 3.4 Cylinder.java (Turunan Circle)
Java
public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return area() * height;
    }

    @Override
    public void printInfo() {
        System.out.println("Cylinder " + getColor() + ", volume = " + volume());
    }
}
🚀 3.5 Main.java (Demonstrasi Polimorfisme)
Java
public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("      INFORMASI BENTUK & GEOMETRI        ");
        System.out.println("==========================================");

        // Penerapan Polymorphism menggunakan Array dari kelas Induk (Shape)
        Shape[] objShapes = new Shape[3];
        objShapes[0] = new Square(5.0, "red");
        objShapes[1] = new Circle(14.0, "blue");
        objShapes[2] = new Cylinder(21.0, 28.0, "yellow");

        // Perulangan untuk memanggil method printInfo() secara polimorfis
        for (Shape s : objShapes) {
            s.printInfo();
        }
        System.out.println("==========================================");
    }
}
▶️ 4. Cara Menjalankan
⚙️ Prasyarat: Pastikan JDK sudah terpasang di perangkatmu.

Bash
# 1. Clone repository
git clone [https://github.com/dalia-wa/Tugas-PBO-Inheritance-dan-Polymorphism.git]
cd Tugas-PBO-Inheritance-dan-Polymorphism

# 2. Compile semua file di dalam folder src
javac src/*.java

# 3. Jalankan program utama
java -cp src Main
📸 5. Hasil Program (Screenshot)
🖥️ Output Eksekusi Program
<img width="308" height="123" alt="image" src="https://github.com/user-attachments/assets/540e0581-e54c-4560-ac20-cb646c025d80" />


✅ 6. Kesimpulan
Inheritance memungkinkan kode pada kelas induk (Shape) digunakan kembali oleh kelas turunan tanpa perlu menulis ulang logika pewarnaan.

Method Overriding memberikan kebebasan bagi kelas anak untuk mengubah isi method printInfo() agar sesuai dengan perhitungan luas atau volume masing-masing bentuk.

Polymorphism mempermudah pengelolaan objek dalam jumlah banyak secara seragam menggunakan array bertipe kelas induk (Shape[]).
