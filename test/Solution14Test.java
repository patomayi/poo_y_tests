import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution14Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos con el primer caso del enunciado (a = 10, b = 5).
    // La solución matemática debería dar exactamente -0.50.
    @Test
    public void testResolucionEcuacionEstandar() {
        Equation14 eq = new Equation14();
        eq.a = 10.0f;
        eq.b = 5.0f;

        eq.calculateSolution();

        // Comprobamos que x valga -0.5f con un margen de tolerancia para decimales (0.001)
        assertEquals(-0.5f, eq.x, 0.001, "La resolución para 10x + 5 = 0 debería ser -0.5");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: ¿Qué pasa si el coeficiente 'b' es 0? La ecuación se transforma en 'a * x = 0',
    // lo que significa que el resultado de 'x' debería ser estrictamente 0.0 sin signos negativos extraños.
    @Test
    public void testCoeficienteBEnCero() {
        Equation14 eqLimite = new Equation14();
        eqLimite.a = 5.0f;
        eqLimite.b = 0.0f; // Límite en el numerador

        eqLimite.calculateSolution();

        assertEquals(0.0f, eqLimite.x, 0.001, "Si b es 0, la solución x debe ser obligatoriamente 0.0");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo se comporta el algoritmo si interactúa con números negativos
    // tanto en el coeficiente 'a' como en el 'b'. Esto comprueba que la ley de los signos
    // (- entre - da +) se aplique perfectamente en la máquina.
    @Test
    public void testCoeficientesNegativos() {
        Equation14 eqNegativos = new Equation14();
        eqNegativos.a = -2.5f;
        eqNegativos.b = -5.0f;

        eqNegativos.calculateSolution(); // x = -(-5.0) / -2.5 => 5.0 / -2.5 = -2.0

        assertEquals(-2.0f, eqNegativos.x, 0.001, "Falló el control de signos con coeficientes negativos.");
    }
}