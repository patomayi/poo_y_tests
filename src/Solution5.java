import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Car {
    String model;
    int topSpeed;
    float acceleration;
    float braking;
    float cornering;

    // EXPLICACIÓN DEL CONSTRUCTOR:
    // El método main instancia los coches pasando los parámetros en este orden exacto:
    // 1. model (String) -> scanner.nextLine()
    // 2. topSpeed (int) -> scanner.nextInt()
    // 3. acceleration (float) -> scanner.nextFloat()
    // 4. braking (float) -> scanner.nextFloat()
    // 5. cornering (float) -> scanner.nextFloat()
    // Usamos 'this' para diferenciar los parámetros del constructor de los atributos de la clase.
    public Car(String model, int topSpeed, float acceleration, float braking, float cornering) {
        this.model = model;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.braking = braking;
        this.cornering = cornering;
    }
}

public class Solution5 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        int numCars = scanner.nextInt();
        scanner.nextLine();
        Car[] cars = new Car[numCars];

        for (int i = 0; i < numCars; i++) {
            cars[i] = new Car(scanner.nextLine(), scanner.nextInt(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());
            scanner.nextLine();
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> -a.topSpeed));

        for (int i = 0; i < numCars; i++) {
            System.out.format("%-20s  %4d  %4.2f  %4.2f  %4.2f %n", cars[i].model, cars[i].topSpeed, cars[i].acceleration, cars[i].braking, cars[i].cornering);
        }
    }
}