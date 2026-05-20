import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution35Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo estándar simulando el 'Sample Input 0'. Comprobamos que
    // tras instanciar toda la estructura de clases anidadas, los datos se conserven de forma íntegra.
    @Test
    public void testInicializacionYAsignacionEstructuraAnidada() {
        Game35 game = new Game35();
        game.player1 = new Player35();
        game.player1.position = new Coords35();
        game.player2 = new Player35();
        game.player2.position = new Coords35();

        game.width = 10;
        game.height = 10;
        game.player1.name = "a";
        game.player1.score = 2300;
        game.player1.position.x = 9;
        game.player1.position.y = 5;

        assertEquals(10, game.width);
        assertEquals("a", game.player1.name);
        assertEquals(2300, game.player1.score);
        assertEquals(9, game.player1.position.x, "La coordenada X del jugador 1 no se guardó correctamente.");
        assertEquals(5, game.player1.position.y);
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el comportamiento con coordenadas en los límites inferiores del mapa (posición 0,0).
    // El sistema de tipos primitivos enteros debe registrar la frontera correctamente sin alteraciones.
    @Test
    public void testCoordenadasFronteraEnElOrigen() {
        Game35 gameLimite = new Game35();
        gameLimite.player1 = new Player35();
        gameLimite.player1.position = new Coords35();

        gameLimite.player1.position.x = 0; // Límite inferior absoluto del eje X
        gameLimite.player1.position.y = 0; // Límite inferior absoluto del eje Y

        assertEquals(0, gameLimite.player1.position.x);
        assertEquals(0, gameLimite.player1.position.y, "El origen (0,0) debe registrarse sin problemas.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Probamos la robustez del diseño relacional. Si inicializamos el objeto `Game35`
    // e intentamos asignar el nombre al jugador 1 omitiendo la instanciación de su clase interna
    // (`game.player1 = new Player35()`), el programa debe lanzar obligatoriamente un NullPointerException.
    @Test
    public void testFaltaDeInstanciaInternaLanzaNullPointerException() {
        Game35 gameIncompleto = new Game35();
        // Omitimos intencionadamente inicializar: gameIncompleto.player1 = new Player35();

        // Validamos que salte de forma controlada el error de puntero nulo
        assertThrows(NullPointerException.class, () -> {
            gameIncompleto.player1.name = "ErrorInminente";
        }, "Debería arrojar NullPointerException debido a que player1 es un objeto nulo.");
    }
}