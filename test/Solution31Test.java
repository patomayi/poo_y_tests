import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution31Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos una victoria estándar basada en el 'Sample Input 0'.
    // Ryu (80+90+80 = 250) vs Honda (100+60+50 = 210). El ganador indiscutible debe ser Ryu.
    @Test
    public void testVictoriaLuchadorUno() {
        Fighter31 ryu = new Fighter31("ryu", 80.0f, 90.0f, 80.0f);
        Fighter31 honda = new Fighter31("honda", 100.0f, 60.0f, 50.0f);
        Fight31 combate = new Fight31();

        Fighter31 ganador = combate.winner(ryu, honda);

        assertNotNull(ganador, "Debería haber un ganador claro en este combate.");
        assertEquals("ryu", ganador.name, "Ryu debería ganar debido a una suma de estadísticas superior.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el caso límite del empate absoluto basado en el 'Sample Input 2'.
    // Ryu (80+90+80 = 250) vs Ken (80+80+90 = 250). Al ser las sumas idénticas en la frontera matemática,
    // el método debe devolver estrictamente 'null'.
    @Test
    public void testEmpateAbsolutoDevuelveNull() {
        Fighter31 ryu = new Fighter31("ryu", 80.0f, 90.0f, 80.0f);
        Fighter31 ken = new Fighter31("ken", 80.0f, 80.0f, 90.0f);
        Fight31 combateLimite = new Fight31();

        Fighter31 ganador = combateLimite.winner(ryu, ken);

        assertNull(ganador, "En caso de empate simétrico de estadísticas, el método debe retornar null.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos la precisión con valores flotantes decimales muy cercanos.
    // Si un luchador supera al otro por apenas un pequeño margen decimal (ej: 0.01), el sistema de
    // condicionales debe ser lo bastante robusto como para detectar la ventaja y no dar un falso empate.
    @Test
    public void testVentajaDecimalMinimaNoProvocaEmpate() {
        Fighter31 luchadorA = new Fighter31("A", 10.00f, 10.00f, 10.00f); // Total = 30.00
        Fighter31 luchadorB = new Fighter31("B", 10.00f, 10.01f, 10.00f); // Total = 30.01
        Fight31 combatePrecision = new Fight31();

        Fighter31 ganador = combatePrecision.winner(luchadorA, luchadorB);

        assertNotNull(ganador);
        assertEquals("B", ganador.name, "El luchador B debe ganar incluso con una ventaja de 0.01 puntos.");
    }
}