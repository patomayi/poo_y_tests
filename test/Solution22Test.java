import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution22Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos que al crear un juego con dos jugadores con 0 puntos,
    // el sistema los guarde correctamente y permita la mutación e incremento de sus puntuaciones.
    @Test
    public void testInicializacionYAsignacionPuntos() {
        Player22 p1 = new Player22(0);
        Player22 p2 = new Player22(0);
        Game22 juego = new Game22(p1, p2);

        assertNotNull(juego.player1, "El jugador 1 no debería ser nulo.");
        assertNotNull(juego.player2, "El jugador 2 no debería ser nulo.");

        // Simulamos un incremento de puntos del jugador 1
        juego.player1.points++;

        assertEquals(1, juego.player1.points, "Los puntos del jugador 1 deberían haber aumentado a 1.");
        assertEquals(0, juego.player2.points, "Los puntos del jugador 2 deberían mantenerse en 0.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Probamos la flexibilidad de los constructores permitiendo que los jugadores
    // comiencen con una puntuación inicial límite alta o distinta de cero. El estado del objeto debe persistir.
    @Test
    public void testPuntuacionInicialDistintaDeCero() {
        Player22 p1 = new Player22(10);
        Player22 p2 = new Player22(5);
        Game22 juegoLimite = new Game22(p1, p2);

        assertEquals(10, juegoLimite.player1.points, "El constructor de Player debería admitir valores límite como 10.");
        assertEquals(5, juegoLimite.player2.points, "El jugador 2 debería retener sus 5 puntos.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos el acoplamiento y control de errores. Si creamos un juego pasando
    // referencias nulas en lugar de objetos 'Player22' válidos, el sistema debe permitir compilar la estructura,
    // pero lanzar un 'NullPointerException' si intentamos interactuar con la puntuación de un jugador inexistente.
    @Test
    public void testJugadoresNulosLanzanExcepcionAlOperar() {
        // Escenario anómalo: Pasar nulos a la composición de la clase
        Game22 juegoInvalido = new Game22(null, null);

        assertNull(juegoInvalido.player1, "El campo del jugador 1 debería registrarse como null.");

        // Validamos que se lance la excepción correspondiente al intentar manipular la propiedad de un nulo
        assertThrows(NullPointerException.class, () -> {
            juegoInvalido.player1.points++;
        }, "Debería lanzar NullPointerException porque player1 no fue instanciado.");
    }
}