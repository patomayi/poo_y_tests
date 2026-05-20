import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution38Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo estándar asignando el nombre "Joan" (Sample Input 0).
    // Comprobamos que el atributo 'nom' retenga el valor asignado correctamente antes de saludar.
    @Test
    public void testAsignacionNombreYRetencionEstandar() {
        Persona38 persona = new Persona38();
        persona.nom = "Joan";

        assertNotNull(persona.nom, "El campo 'nom' no debería ser nulo.");
        assertEquals("Joan", persona.nom, "El nombre asignado de forma directa no coincide.");
        assertDoesNotThrow(() -> persona.saludar(), "El método saludar() debe ejecutarse sin errores estructurales.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el comportamiento con una cadena vacía "" como nombre.
    // La clase debe ser capaz de soportar strings de longitud cero sin romperse.
    @Test
    public void testNombreCadenaVaciaLimite() {
        Persona38 personaLimite = new Persona38();
        personaLimite.nom = ""; // Límite inferior de longitud de un String útil

        assertEquals("", personaLimite.nom, "El sistema debe admitir un nombre vacío.");
        assertDoesNotThrow(() -> personaLimite.saludar());
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Probamos el comportamiento por defecto de Java. Si instanciamos una Persona38
    // pero no le asignamos ningún valor al campo 'nom', este quedará como 'null'. Comprobamos
    // que al llamar al método 'saludar()', no se produzca una excepción, sino que imprima el literal con "null".
    @Test
    public void testPersonaSinNombreNoLanzaExcepcion() {
        Persona38 personaNueva = new Persona38();

        assertNull(personaNueva.nom, "Por defecto, los objetos String en Java se inicializan en null.");
        assertDoesNotThrow(() -> personaNueva.saludar(), "Llamar a saludar() con un nombre null no debe romper el programa.");
    }
}