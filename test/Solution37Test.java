import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution37Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Validamos la instanciación estándar de la clase Gos37.
    // Comprobamos que el objeto se cree correctamente en memoria y que su método sea accesible.
    @Test
    public void testInstanciacionYComportamientoGos() {
        Gos37 miPerro = new Gos37();

        assertNotNull(miPerro, "El objeto Gos37 debería instanciarse correctamente.");
        // Ejecutamos el método para asegurar que no lance excepciones internas de estructura
        assertDoesNotThrow(() -> miPerro.lladrar(), "El método lladrar() debería ejecutarse sin lanzar excepciones.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Validamos de forma equivalente la instanciación de la clase Gat37.
    // Aseguramos que la otra entidad del dominio del problema cumpla las mismas condiciones de aislamiento.
    @Test
    public void testInstanciacionYComportamientoGat() {
        Gat37 miGato = new Gat37();

        assertNotNull(miGato, "El objeto Gat37 debería instanciarse correctamente.");
        assertDoesNotThrow(() -> miGato.miolar(), "El método miolar() debería ejecutarse sin lanzar excepciones.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos el riesgo de operar con referencias vacías. Si declaramos la variable
    // de tipo Gos37 pero no la inicializamos (queda en 'null'), intentar invocar su comportamiento
    // debe arrojar un 'NullPointerException'. Esto demuestra que el método depende del estado del objeto.
    @Test
    public void testLlamadaAObjetoNuloLanzaException() {
        Gos37 perroInexistente = null;

        assertThrows(NullPointerException.class, () -> {
            perroInexistente.lladrar();
        }, "Llamar a un método sobre una referencia nula debe lanzar NullPointerException de forma obligatoria.");
    }
}