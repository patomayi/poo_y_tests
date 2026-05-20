import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution15Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos las transiciones estándar de punto muerto (0) a primera (1)
    // y de vuelta a punto muerto siguiendo un comportamiento ordinario.
    @Test
    public void testCambioMarchasEstandar() {
        GearBox15 caja = new GearBox15();
        caja.numGears = 5; // Caja de 5 marchas
        assertEquals(0, caja.gear, "El coche debería iniciar en Neutro (0).");

        caja.gearUp();
        assertEquals(1, caja.gear, "Al hacer UP desde N, debería subir a 1.");

        caja.gearDown();
        assertEquals(0, caja.gear, "Al hacer DOWN desde 1, debería bajar a N (0).");
    }

    // TEST 2: VALOR LÍMITE SUPERIOR (Boundary Value)
    // EXPLICACIÓN: Basado en el Sample Input 2. Si el coche tiene 5 marchas e intentamos hacer UP
    // repetidas veces, el sistema debe bloquearse en la marcha 5 sin desbordarse a la 6.
    @Test
    public void testLimiteSuperiorMarchas() {
        GearBox15 cajaTop = new GearBox15();
        cajaTop.numGears = 5;

        // Forzamos 6 subidas en una caja de 5 marchas
        for (int i = 0; i < 6; i++) {
            cajaTop.gearUp();
        }

        assertEquals(5, cajaTop.gear, "La marcha no debería superar el número total de marchas (5).");
    }

    // TEST 3: CASO EXCEPCIONAL / LÍMITE INFERIOR (Error Scenario)
    // EXPLICACIÓN: Basado en el Sample Input 3. Si bajamos hasta la marcha atrás (-1 o 'R'),
    // cualquier intento posterior de hacer DOWN debe ser ignorado para proteger la transmisión.
    @Test
    public void testLimiteInferiorMarchaAtras() {
        GearBox15 cajaBack = new GearBox15();
        cajaBack.numGears = 5;

        // Bajamos dos veces: de 0 a -1 (Reverse) y de -1 intentamos bajar otra vez
        cajaBack.gearDown(); // Pasa a -1
        cajaBack.gearDown(); // Debería quedarse en -1

        assertEquals(-1, cajaBack.gear, "La marcha atrás (-1) es el límite inferior absoluto y no debe sobrepasarse.");
    }
}