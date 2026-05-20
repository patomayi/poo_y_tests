import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution13Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos el comportamiento estándar del termómetro usando el punto de congelación
    // del agua (0°C). Comprobamos que las conversiones den exactamente 32°F y 273.15K.
    @Test
    public void testConversionesPuntoCongelacion() {
        Thermometer13 termometro = new Thermometer13();
        termometro.celsius = 0.0f;

        // Validamos Celsius
        assertEquals(0.0f, termometro.celsius, 0.001);

        // Validamos el cálculo de Fahrenheit
        float fahrenheit = (termometro.celsius * 1.8f) + 32f;
        assertEquals(32.0f, fahrenheit, 0.001, "La conversión a Fahrenheit a partir de 0C falló.");

        // Validamos el cálculo de Kelvin
        float kelvin = termometro.celsius + 273.15f;
        assertEquals(273.15f, kelvin, 0.001, "La conversión a Kelvin a partir de 0C falló.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el límite inferior físico de la escala (el cero absoluto, aprox -273.15°C).
    // Basado en el Sample Input 0, pasamos -273.10°C y comprobamos que Kelvin quede rozando el cero (0.05K).
    @Test
    public void testConversionesCeroAbsoluto() {
        Thermometer13 termometroLimite = new Thermometer13();
        termometroLimite.celsius = -273.10f; // Límite inferior del programa

        float fahrenheit = (termometroLimite.celsius * 1.8f) + 32f;
        float kelvin = termometroLimite.celsius + 273.15f;

        // Comprobamos la tolerancia matemática estricta exigida en el ejercicio
        assertEquals(-459.58f, fahrenheit, 0.01, "El límite en Fahrenheit no coincide con el ejercicio.");
        assertEquals(0.05f, kelvin, 0.01, "El límite en Kelvin debería dar 0.05K.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo responde la clase ante una temperatura extremadamente alta
    // (punto de ebullición extremo como 5000°C) para comprobar que el uso de variables tipo 'float'
    // no sufra desbordamiento de memoria o pérdida severa de precisión en las operaciones.
    @Test
    public void testTemperaturasExtremasAltas() {
        Thermometer13 termometroExtremo = new Thermometer13();
        termometroExtremo.celsius = 5000.0f;

        float fahrenheit = (termometroExtremo.celsius * 1.8f) + 32f;
        float kelvin = termometroExtremo.celsius + 273.15f;

        // Verificamos que los números gigantes se procesen correctamente de forma lineal
        assertEquals(9032.0f, fahrenheit, 0.01, "Fallo de precisión en Fahrenheit con valores gigantes.");
        assertEquals(5273.15f, kelvin, 0.01, "Fallo de precisión en Kelvin con valores gigantes.");
    }
}