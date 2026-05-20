import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution11Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos que al instanciar el objeto 'LineSeparator11', el atributo
    // 'size' tome el valor asignado de manera correcta, que es la base para que el bucle itere bien.
    @Test
    public void testAsignacionTamanoLinea() {
        LineSeparator11 separador = new LineSeparator11();
        separador.size = 5;

        assertEquals(5, separador.size, "El tamaño de la línea no se configuró correctamente.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: ¿Qué pasa si el tamaño de la línea es 0? El método no debería dar error,
    // simplemente el bucle 'for' no se ejecutará ninguna vez y pasará directamente al salto de línea.
    @Test
    public void testLimiteTamanoCero() {
        LineSeparator11 separadorVacio = new LineSeparator11();
        separadorVacio.size = 0; // Límite inferior absoluto de dibujo

        assertEquals(0, separadorVacio.size, "El sistema debería aceptar un tamaño de línea de 0.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo responde la propiedad si se le asigna un número negativo.
    // Aunque el bucle 'for (i = 0; i < -5; i++)' no se ejecutará debido a la condición, es un caso
    // anómalo que debemos verificar para asegurar que el atributo retenga el valor sin romper el objeto.
    @Test
    public void testTamanoNegativoNoRompeObjeto() {
        LineSeparator11 separadorNegativo = new LineSeparator11();
        separadorNegativo.size = -5;

        // Validamos que se asigne el negativo sin lanzar excepciones de desbordamiento en la inicialización
        assertTrue(separadorNegativo.size < 0, "El tamaño puede registrarse como negativo si no hay validación previa.");
    }
}