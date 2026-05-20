import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution34Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el estado inicial tras instanciar una partida estándar con la palabra "hola".
    // Verificamos que la palabra se almacene, los fallos arranquen en 0, completado en false, y
    // que el array descubierta contenga exactamente 4 guiones bajos.
    @Test
    public void testInicializacionJuegoEstandar() {
        Ahorcado34 juego = new Ahorcado34("hola");

        assertEquals("hola", juego.palabra);
        assertEquals(0, juego.fallos, "Los fallos iniciales deben ser cero de forma estricta.");
        assertFalse(juego.completado, "El juego no puede iniciar completado.");
        assertNotNull(juego.descubierta, "El array de caracteres descubiertos no puede ser nulo.");
        assertEquals(4, juego.descubierta.length, "La longitud del array debe coincidir con la palabra.");

        // Comprobamos que esté lleno de guiones bajos
        for (char c : juego.descubierta) {
            assertEquals('_', c, "Cada casilla del progreso inicial debe albergar un guion bajo.");
        }
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites inferiores de longitud del juego pasando una palabra
    // de un solo carácter ("a"). El array descubierta debe dimensionarse a tamaño 1 correctamente.
    @Test
    public void testPalabraSecretaLongitudMinima() {
        Ahorcado34 juegoLimite = new Ahorcado34("a");

        assertEquals(1, juegoLimite.descubierta.length, "El sistema debe admitir palabras fronterizas de longitud 1.");
        assertEquals('_', juegoLimite.descubierta[0], "El único elemento del array debe empezar como guion bajo.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Probamos qué ocurre ante un error de entrada crítica (palabra vacía ""). El constructor
    // debe poder ejecutarse generando un array de tamaño 0 de forma segura. Asegurar este escenario evita
    // que la aplicación rompa con un IndexOutOfBoundsException inesperado si el flujo de red o consola falla.
    @Test
    public void testPalabraVaciaManejoExcepcional() {
        Ahorcado34 juegoVacio = new Ahorcado34("");

        assertEquals(0, juegoVacio.descubierta.length, "Una palabra vacía debe generar un array seguro de longitud 0.");
        assertEquals("", juegoVacio.palabra);
    }
}