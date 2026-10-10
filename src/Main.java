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