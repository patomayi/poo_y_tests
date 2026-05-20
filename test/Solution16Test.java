import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution16Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos con los datos del 'Sample Input 0'. Un proyecto de 10 que vale el 50%
    // y un examen de 0 que vale el otro 50%. La media final debe dar exactamente 5.00.
    @Test
    public void testCalculoMediaPonderadaEstandar() {
        ReportCard16 boletin = new ReportCard16(2);
        boletin.grades[0] = new Grade16("Projecte", 10.0f, 50.0f);
        boletin.grades[1] = new Grade16("Examen", 0.0f, 50.0f);

        boletin.calculateAverageGrade();

        // Usamos un delta de tolerancia de 0.001 para la precisión de números flotantes
        assertEquals(5.00f, boletin.averageGrade, 0.001, "La nota media ponderada de 10(50%) y 0(50%) debe ser 5.00");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el caso extremo de un único elemento que representa el 100% de la nota final
    // (basado en el Sample Input 4). La nota resultante debe ser idéntica a la nota obtenida.
    @Test
    public void testUnicaNotaCienPorCien() {
        ReportCard16 boletinLimite = new ReportCard16(1);
        boletinLimite.grades[0] = new Grade16("Examen", 7.75f, 100.0f);

        boletinLimite.calculateAverageGrade();

        assertEquals(7.75f, boletinLimite.averageGrade, 0.001, "Si solo hay una nota al 100%, la media debe ser esa misma nota.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: ¿Qué pasa si el estudiante saca un 0 absoluto en todas sus actividades?
    // Evaluamos que el bucle procese la acumulación de ceros correctamente y asigne un 0.00 estable
    // en la nota final, evitando errores de inicialización o valores indefinidos (NaN).
    @Test
    public void testNotasCeroAbsoluto() {
        ReportCard16 boletinCero = new ReportCard16(3);
        boletinCero.grades[0] = new Grade16("A1", 0.0f, 30.0f);
        boletinCero.grades[1] = new Grade16("A2", 0.0f, 30.0f);
        boletinCero.grades[2] = new Grade16("A3", 0.0f, 40.0f);

        boletinCero.calculateAverageGrade();

        assertEquals(0.00f, boletinCero.averageGrade, 0.001, "La acumulación de calificaciones en cero debe dar un promedio final de 0.00");
    }
}