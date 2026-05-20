import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution33Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos la asignación de datos estándar basada en el 'Sample Input 0'.
    // Comprobamos que el objeto guarde fielmente los Strings con espacios, el float y el booleano.
    @Test
    public void testAsignacionCancionEstandar() {
        Song33 cancion = new Song33();
        cancion.name = "One love";
        cancion.artist = "Bob Marley";
        cancion.rating = 4.5f;
        cancion.favorite = true;

        assertEquals("One love", cancion.name);
        assertEquals("Bob Marley", cancion.artist);
        assertEquals(4.5f, cancion.rating, 0.001);
        assertTrue(cancion.favorite, "El estado favorito (true) no se guardó correctamente.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites lógicos basados en el 'Sample Input 2', donde la propiedad
    // 'favorite' pasa a ser 'false' y comprobamos los límites inferiores de puntuación.
    @Test
    public void testCancionNoFavoritaYRatingLimite() {
        Song33 cancionLimite = new Song33();
        cancionLimite.name = "Whole Lotta Love";
        cancionLimite.artist = "Led Zeppelin";
        cancionLimite.rating = 0.0f; // Límite inferior de calificación
        cancionLimite.favorite = false; // Estado fronterizo opuesto al Happy Path

        assertFalse(cancionLimite.favorite, "El estado favorito debería registrarse como false.");
        assertEquals(0.0f, cancionLimite.rating, 0.001, "El rating mínimo de 0.0 debe ser soportado.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Comprobamos el comportamiento de los valores por defecto al instanciar la clase.
    // Al no tener un constructor explícito, Java inicializa los Strings en 'null', el float en '0.0'
    // y el booleano en 'false'. Confirmar esto previene errores en la lógica de renderizado del bucle de estrellas.
    @Test
    public void testValoresInicialesPorDefecto() {
        Song33 cancionNueva = new Song33();

        assertNull(cancionNueva.name, "El título sin inicializar debe ser null por defecto.");
        assertNull(cancionNueva.artist, "El artista sin inicializar debe ser null por defecto.");
        assertEquals(0.0f, cancionNueva.rating, 0.001, "El rating inicial debe ser 0.0.");
        assertFalse(cancionNueva.favorite, "El booleano por defecto en Java debe ser false.");
    }
}