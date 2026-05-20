import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution36Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Simula una tabla cuadrada estándar de 3x3 rellena con la letra 'a' (Sample Input 0).
    // Verifica que las dimensiones de la estructura interna y los caracteres coincidan al 100%.
    @Test
    public void testTablaEstructuraCorrectaEstandar() {
        Taula36 taula = new Taula36(3, 3, 'a');

        assertNotNull(taula.files, "El array de filas no debe ser nulo.");
        assertEquals(3, taula.files.length, "La tabla debe tener exactamente 3 filas.");

        // Comprobamos la primera fila de forma exhaustiva
        assertEquals(3, taula.files[0].columnes.length, "Cada fila debe tener exactamente 3 columnas.");
        assertEquals('a', taula.files[0].columnes[0].casella.lletra, "El carácter de la casilla debe ser 'a'.");
        assertEquals('a', taula.files[2].columnes[2].casella.lletra, "La última esquina de la tabla debe contener 'a'.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites de asimetría dimensional usando una matriz plana de 1 fila
    // por 50 columnas. El motor de inicialización por bucles no debe sufrir desbordamientos en tamaños largos.
    @Test
    public void testTablaAsimetricaUnidimensionalLarga() {
        Taula36 tablaPlana = new Taula36(1, 50, 'x');

        assertEquals(1, tablaPlana.files.length, "Debe contener una única fila.");
        assertEquals(50, tablaPlana.files[0].columnes.length, "La fila debe estirarse de forma segura hasta 50 columnas.");
        assertEquals('x', tablaPlana.files[0].columnes[49].casella.lletra, "El último elemento de la fila debe ser 'x'.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: ¿Qué pasa si pasamos una dimensión de 0 filas o 0 columnas (Tabla vacía)?
    // Evaluamos este escenario extremo para certificar que los arrays se crean vacíos con tamaño 0
    // de forma segura en lugar de romper el programa o generar bucles infinitos.
    @Test
    public void testTablaVaciaManejoDeCero() {
        Taula36 tablaVacia = new Taula36(0, 0, 'z');

        assertNotNull(tablaVacia.files, "El array raíz de filas debe inicializarse aunque su tamaño sea 0.");
        assertEquals(0, tablaVacia.files.length, "La longitud de las filas de una tabla vacía debe ser 0.");
    }
}