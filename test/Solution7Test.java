import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution7Test {

    private final FunctionGame2 game = new FunctionGame2();

    // TEST 1: CAMINO FELIZ (Happy Path) - Evaluando 'function3'
    // EXPLICACIÓN: Verificamos el comportamiento normal del método de duplicación de cadenas de texto.
    @Test
    public void testRepeticionTextoCorrecta() {
        String resultado = game.function3(3, "abc");
        assertEquals("abcabcabc", resultado, "El texto no se repitió el número correcto de veces.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value) - Evaluando 'function7' con arrays
    // EXPLICACIÓN: Evaluamos los límites inferiores de búsqueda de palabras.
    // ¿Qué pasa si el array está vacío o si la palabra buscada ("java") tiene letras en mayúscula ("Java")?
    @Test
    public void testContadorJavaLimites() {
        // Límite: array vacío de strings
        int resultadoVacio = game.function7(new String[0]);
        assertEquals(0, resultadoVacio, "Un array vacío debería retornar 0 coincidencias.");

        // Límite fronterizo de mayúsculas: el método debe ser case-sensitive y omitir "Java" o "JAVA"
        String[] lenguajes = {"Java", "java", "JAVA", "javascript"};
        int resultadoFiltro = game.function7(lenguajes);
        assertEquals(1, resultadoFiltro, "Solo debe contar las coincidencias exactas en minúsculas.");
    }

    // TEST 3: CASO EXCEPCIONAL / ERROR - Evaluando 'function8' con números negativos y extremos
    // EXPLICACIÓN: Comprobamos que el algoritmo de ordenación no falle cuando se mezclan números negativos,
    // valores repetidos o el número cero, garantizando que el orden ascendente se mantenga siempre estable.
    @Test
    public void testOrdenacionTresNumerosExtremos() {
        // Caso con desorden, negativos y repetidos
        int[] ordenados = game.function8(5, -10, 5);

        assertNotNull(ordenados, "El array de retorno no debe ser nulo.");
        assertEquals(3, ordenados.length, "El tamaño devuelto debe ser estrictamente 3.");
        assertEquals(-10, ordenados[0], "El número menor (-10) debe estar en la primera posición.");
        assertEquals(5, ordenados[1], "El segundo elemento debe ser el 5.");
        assertEquals(5, ordenados[2], "El último elemento debe ser el otro 5.");
    }
}