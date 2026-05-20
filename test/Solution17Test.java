import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution17Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos una resolución matemática estándar con los valores del 'Sample Input 0'
    // (base = 3.0, altura = 4.0). El cálculo (3 * 4) / 2 debe dar exactamente 6.00.
    @Test
    public void testCalculoAreaEstandar() {
        Triangle17 triangulo = new Triangle17();
        triangulo.base = 3.0f;
        triangulo.height = 4.0f;

        float areaResultado = triangulo.calculateArea();

        // Usamos un delta de tolerancia de 0.001 para la precisión de tipos float
        assertEquals(6.00f, areaResultado, 0.001, "El área de un triángulo de base 3 y altura 4 debe ser 6.00");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites inferiores basados en el 'Sample Input 2'. Si la base o la altura
    // valen 0, el área resultante debe ser exactamente 0.00 sin lanzar indeterminaciones ni errores aritméticos.
    @Test
    public void testAreaConDimensionCero() {
        Triangle17 trianguloLimite = new Triangle17();
        trianguloLimite.base = 0.0f; // Límite inferior absoluto
        trianguloLimite.height = 89.0f;

        float areaResultado = trianguloLimite.calculateArea();

        assertEquals(0.00f, areaResultado, 0.001, "Si la base es 0, el área debe ser estrictamente 0.00");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos la precisión con valores de punto flotante que contienen múltiples decimales
    // (basado en el Sample Input 1: base = 30.77, altura = 23.5). Comprobamos que el método opere con exactitud
    // y mantenga la estabilidad matemática necesaria antes de pasar al formateador de texto.
    @Test
    public void testPrecisionConDecimalesComplejos() {
        Triangle17 trianguloDecimal = new Triangle17();
        trianguloDecimal.base = 30.77f;
        trianguloDecimal.height = 23.5f;

        float areaResultado = trianguloDecimal.calculateArea(); // (30.77 * 23.5) / 2 = 361.5475

        // Validamos que el resultado crudo coincida con el margen de redondeo del ejercicio (361.55)
        assertEquals(361.5475f, areaResultado, 0.001, "Falló la precisión decimal en el cálculo crudo del área.");
    }
}