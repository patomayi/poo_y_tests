import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution10Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos el comportamiento estándar del método. Al llamar a switchLed en una
    // posición válida, el LED asignado debe cambiar de apagado a encendido de forma correcta.
    @Test
    public void testInversionDeEstadoCorrecta() {
        LedArray10 conjunto = new LedArray10(5);

        // Inicialmente el LED en la posición 2 está apagado (false)
        assertFalse(conjunto.leds[2].state, "El LED de la posición 2 debería empezar apagado.");

        // Ejecutamos la inversión de estado
        conjunto.switchLed(2);
        assertTrue(conjunto.leds[2].state, "El LED de la posición 2 debería haberse encendido.");

        // Volvemos a invertir para comprobar el camino inverso
        conjunto.switchLed(2);
        assertFalse(conjunto.leds[2].state, "El LED de la posición 2 debería haberse apagado otra vez.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites físicos superiores e inferiores del array de LEDs.
    // Si creamos un array de tamaño 5, las posiciones límites válidas para operar son la 0 (mínima) y la 4 (máxima).
    @Test
    public void testInversionEnLimitesDelArray() {
        LedArray10 conjunto = new LedArray10(5);

        // Probamos el límite inferior (índice 0)
        conjunto.switchLed(0);
        assertTrue(conjunto.leds[0].state, "Falló la inversión en el límite inferior (0).");

        // Probamos el límite superior válido (índice 4, ya que el tamaño es 5)
        conjunto.switchLed(4);
        assertTrue(conjunto.leds[4].state, "Falló la inversion en el límite superior válido (4).");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo se comporta el programa ante una posición inválida (fuera de rango).
    // Si intentamos pasarle un índice negativo o superior al tamaño del array, Java debería lanzar de forma
    // controlada una excepción de tipo 'ArrayIndexOutOfBoundsException'.
    @Test
    public void testPosicionFueraDeRangoLanzaExcepcion() {
        LedArray10 conjunto = new LedArray10(5);

        // Validamos que el sistema capture el error correctamente si se intenta acceder a una celda que no existe
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conjunto.switchLed(99); // Posición totalmente inválida
        }, "Debería lanzar una excepción al salirse del rango del array.");
    }
}