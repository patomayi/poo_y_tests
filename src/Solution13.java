import java.util.Scanner;

// escriu el codi aquí
class Thermometer13 {
    // Atributo que guarda la temperatura base en grados Celsius
    float celsius;

    // EXPLICACIÓN PRINT CELSIUS:
    // Formatea la salida usando '%7.2f' para asegurar que el número ocupe exactamente 
    // 7 espacios a la derecha con dos decimales, seguido de la letra 'C'.
    public void printCelsius() {
        System.out.format("%7.2fC%n", celsius);
    }

    // EXPLICACIÓN PRINT FAHRENHEIT:
    // Aplica la fórmula matemática de conversión (Celsius * 1.8f + 32f) 
    // y lo imprime con el mismo formato de 7 espacios y la letra 'F'.
    public void printFahrenheit() {
        float fahrenheit = (celsius * 1.8f) + 32f;
        System.out.format("%7.2fF%n", fahrenheit);
    }

    // EXPLICACIÓN PRINT KELVIN:
    // Suma la constante 273.15f para obtener el cero absoluto en Kelvin
    // y lo muestra en pantalla con la letra 'K'.
    public void printKelvin() {
        float kelvin = celsius + 273.15f;
        System.out.format("%7.2fK%n", kelvin);
    }
}

public class Solution13 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Thermometer13 thermometer1 = new Thermometer13();
        Thermometer13 thermometer2 = new Thermometer13();
        float a, b;

        // El bucle lee temperaturas hasta que la primera sea menor que el cero absoluto (-273.1)
        while((a = scanner.nextFloat()) >= -273.1f) {
            thermometer1.celsius = a;
            thermometer2.celsius = scanner.nextFloat();

            System.out.println("Termometre 1");
            thermometer1.printCelsius();
            thermometer1.printFahrenheit();
            thermometer1.printKelvin();

            System.out.println("Termometre 2");
            thermometer2.printCelsius();
            thermometer2.printFahrenheit();
            thermometer2.printKelvin();

            System.out.println("--------");
        }
    }
}