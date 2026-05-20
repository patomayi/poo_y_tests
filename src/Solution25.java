import java.io.*;
import java.util.*;

class Bike25 {
    int speed;
    public Bike25(int speed) {
        this.speed = speed;
    }
}

class Race25 {
    Bike25[] bikes;

    // EXPLICACIÓN DEL MÉTODO fastest():
    // 1. Control de errores: Si el array es nulo o su longitud es 0, devolvemos null directamente.
    // 2. Inicializamos una variable 'motoMasRapida' apuntando al primer elemento del array (posición 0).
    // 3. Recorremos el array a partir de la posición 1 comparando las velocidades.
    // 4. Si encontramos una moto con mayor velocidad, actualizamos nuestra variable de referencia.
    public Bike25 fastest() {
        if (this.bikes == null || this.bikes.length == 0) {
            return null;
        }

        Bike25 motoMasRapida = this.bikes[0];

        for (int i = 1; i < this.bikes.length; i++) {
            if (this.bikes[i].speed > motoMasRapida.speed) {
                motoMasRapida = this.bikes[i];
            }
        }

        return motoMasRapida;
    }
}

public class Solution25 { // Recuerda cambiar el nombre a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race25 race = new Race25();

        // Comprobamos si hay datos de entrada para evitar excepciones si el input está vacío
        if (!scanner.hasNextInt()) {
            System.out.println("No bikes");
            return;
        }

        int numBikes = scanner.nextInt();
        race.bikes = new Bike25[numBikes];

        for (int i = 0; i < numBikes; i++) {
            race.bikes[i] = new Bike25(scanner.nextInt());
        }

        Bike25 fastest = race.fastest();
        System.out.println(fastest == null ? "No bikes" : fastest.speed);
    }
}