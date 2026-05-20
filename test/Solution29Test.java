import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution29Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Validamos una fusión estándar usando los datos de Goku y Vegeta.
    // El método debe retornar un nuevo personaje con 190 de fuerza y 190 de velocidad.
    @Test
    public void testFusionPersonajesEstandar() {
        Personaje29 goku = new Personaje29(100, 100);
        Personaje29 vegeta = new Personaje29(90, 90);
        Fusion29 danzaFusion = new Fusion29();

        Personaje29 gogeta = danzaFusion.fusionar(goku, vegeta);

        assertNotNull(gogeta, "El personaje resultante de la fusión no debería ser nulo.");
        assertEquals(190, gogeta.fuerza, "La fuerza combinada de gogeta debería ser 190.");
        assertEquals(190, gogeta.velocidad, "La velocidad combinada de gogeta debería ser 190.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites inferiores de los atributos. Si un personaje
    // tiene estadísticas de 0 (debilitado al extremo), la fusión debe operar correctamente
    // sumando cero sin corromper los datos ni arrojar resultados negativos.
    @Test
    public void testFusionConValoresEnCero() {
        Personaje29 debil1 = new Personaje29(0, 50); // Límite inferior en fuerza
        Personaje29 debil2 = new Personaje29(30, 0);  // Límite inferior en velocidad
        Fusion29 danzaFusion = new Fusion29();

        Personaje29 resultado = danzaFusion.fusionar(debil1, debil2);

        assertEquals(30, resultado.fuerza, "La fuerza combinada con cero falló.");
        assertEquals(50, resultado.velocidad, "La velocidad combinada con cero falló.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Verificamos que la fusión genere una nueva instancia independiente en memoria
    // y no devuelva una referencia compartida de los parámetros de entrada. Modificar la fusión
    // no debe alterar a los personajes originales (inmutabilidad de los combatientes base).
    @Test
    public void testInmutabilidadDePersonajesOriginales() {
        Personaje29 goten = new Personaje29(80, 100);
        Personaje29 trunks = new Personaje29(70, 90);
        Fusion29 danzaFusion = new Fusion29();

        Personaje29 gotenks = danzaFusion.fusionar(goten, trunks);

        // Modificamos el resultado de la fusión de forma intencionada
        gotenks.fuerza = 999;

        // Comprobamos que el origen mantenga sus datos intactos protegiendo el estado
        assertEquals(80, goten.fuerza, "Modificar la fusión alteró accidentalmente el objeto 'goten' original.");
        assertEquals(70, trunks.fuerza, "Modificar la fusión alteró accidentalmente el objeto 'trunks' original.");
    }
}