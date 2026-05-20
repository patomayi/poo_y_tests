import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution18Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el 'Sample Input 0' (a=1, b=-5, c=6). Sus soluciones exactas
    // en matemáticas son x1 = 3.0 y x2 = 2.0. Comprobamos que el array devuelva ambos valores en orden.
    @Test
    public void testEcuacionSegundoGradoEstandar() {
        Equation2D18 eq = new Equation2D18();
        eq.a = 1.0f;
        eq.b = -5.0f;
        eq.c = 6.0f;

        float[] resultado = eq.solve();

        assertNotNull(resultado, "El array de soluciones no debería ser nulo.");
        assertEquals(2, resultado.length, "El array de retorno debe contener exactamente 2 soluciones.");
        assertEquals(3.0f, resultado[0], 0.001, "La primera raíz (x1) debería ser 3.00");
        assertEquals(2.0f, resultado[1], 0.001, "La segunda raíz (x2) debería ser 2.00");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Basado en el 'Sample Input 2' (a=1, b=4, c=0). Evaluamos el comportamiento
    // cuando el término independiente 'c' es exactamente 0. Una de las raíces debe dar obligatoriamente 0.0.
    @Test
    public void testTerminoCEndCero() {
        Equation2D18 eqLimite = new Equation2D18();
        eqLimite.a = 1.0f;
        eqLimite.b = 4.0f;
        eqLimite.c = 0.0f; // Límite inferior de coeficientes reales del problema

        float[] resultado = eqLimite.solve();

        assertEquals(0.0f, resultado[0], 0.001, "Al ser c=0, una de las raíces debe ser exactamente 0.0");
        assertEquals(-4.0f, resultado[1], 0.001, "La segunda raíz debería dar -4.0");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Basado en el 'Sample Input 4' con decimales de alta precisión (a=15, b=-6.5, c=-2.7).
    // Comprobamos la tolerancia de redondeo de punto flotante de Java para verificar que no ocurran
    // desviaciones severas antes de que el formateador del 'main' trunque la cadena de texto.
    @Test
    public void testCoeficientesDecimalesComplejos() {
        Equation2D18 eqDecimal = new Equation2D18();
        eqDecimal.a = 15.0f;
        eqDecimal.b = -6.5f;
        eqDecimal.c = -2.7f;

        float[] resultado = eqDecimal.solve();

        // Las respuestas esperadas en el enunciado con dos decimales son 0.69 y -0.26
        assertEquals(0.69f, resultado[0], 0.01, "Fallo de precisión decimal en la primera raíz aproximada.");
        assertEquals(-0.26f, resultado[1], 0.01, "Fallo de precisión decimal en la segunda raíz aproximada.");
    }
}