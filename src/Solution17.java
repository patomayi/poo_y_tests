import java.io.*;
import java.util.*;

class Triangle17 {
    float base;
    float height;

    // EXPLICACIÓN DEL MÉTODO calculateArea:
    // Multiplica los atributos de instancia 'base' y 'height', 
    // y divide el resultado entre 2.0f para obtener el área en formato flotante.
    public float calculateArea() {
        return (this.base * this.height) / 2.0f;
    }
}

public class Solution17 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle17 t1 = new Triangle17();
        Triangle17 t2 = new Triangle17();

        t1.base = scanner.nextFloat();
        t1.height = scanner.nextFloat();
        System.out.format("Area triangle1: %.2f%n", t1.calculateArea());

        t2.base = scanner.nextFloat();
        t2.height = scanner.nextFloat();
        System.out.format("Area triangle2: %.2f%n", t2.calculateArea());
    }
}
