import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution3Test {

    private final FunctionGame game = new FunctionGame();

    // 1. CAMINO FELIZ (Testear operaciones con casos normales)
    @Test
    public void testFunction4OperacionLineal() {
        // Patrón: 2x - 1
        assertEquals(1, game.function4(1));
        assertEquals(9, game.function4(5));
        assertEquals(19, game.function4(10));
    }

    // 2. VALORES LÍMITE (Testear máximos con números repetidos o extremos)
    @Test
    public void testFunction7Maximo() {
        // Caso feliz
        assertEquals(7, game.function7(3, 7));
        // Límitrofe: números iguales
        assertEquals(5, game.function7(5, 5));
        // Límitrofe: números negativos
        assertEquals(-2, game.function7(-10, -2));
    }

    // 3. CASOS EXCEPCIONALES / ERROR (Testear mínimos combinando positivos, negativos y ceros)
    @Test
    public void testFunction8MinimoConNegativosYCero() {
        // El menor de tres números donde hay ceros y negativos
        assertEquals(-5, game.function8(0, -5, 3), "Debería detectar el número negativo como el menor");
        assertEquals(0, game.function8(10, 0, 4), "Debería detectar el cero como el menor");
        assertEquals(-10, game.function8(-10, -10, -1), "Debería funcionar con repetidos negativos");
    }
}