import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution24Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo ordinario basándonos en el 'Sample Input 0'.
    // Comprobamos que tras rellenar los datos de ambas clases, la información persista con exactitud.
    @Test
    public void testAsignacionEstructuraLibroYAutor() {
        Libro24 libro = new Libro24();
        libro.autor = new Autor24();

        libro.titulo = "C Programming Language";
        libro.ISBN = "978-0131103627";
        libro.rating = 4.5f;
        libro.autor.nombre = "Dennis M. Ritchie";
        libro.autor.rating = 5.0f;

        assertEquals("C Programming Language", libro.titulo);
        assertEquals("978-0131103627", libro.ISBN);
        assertEquals(4.5f, libro.rating, 0.001);
        assertEquals("Dennis M. Ritchie", libro.autor.nombre, "La vinculación del nombre del autor falló.");
        assertEquals(5.0f, libro.autor.rating, 0.001);
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: ¿Qué pasa si el rating del libro es 0 absoluto? Evaluamos el comportamiento
    // en los límites mínimos de puntuación. El sistema debe aceptar el valor sin romper las variables flotantes.
    @Test
    public void testRatingFronteraEnCero() {
        Libro24 libroLimite = new Libro24();
        libroLimite.autor = new Autor24();

        libroLimite.rating = 0.0f; // Límite inferior absoluto
        libroLimite.autor.rating = 1.0f;

        assertEquals(0.0f, libroLimite.rating, 0.001, "El sistema de ratings debe soportar la nota mínima de 0.0");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Verificamos la robustez ante desatenciones de inicialización. Al igual que con las
    // direcciones, si se intenta guardar el nombre del autor en 'libro.autor.nombre' sin antes haber
    // inicializado la propiedad 'libro.autor = new Autor24()', el programa debe lanzar un 'NullPointerException'.
    @Test
    public void testFaltaDeInstanciaAutorLanzaException() {
        Libro24 libroIncompleto = new Libro24();
        // Omitimos de forma intencionada la línea: libroIncompleto.autor = new Autor24();

        // Validamos que se capture el error clásico de puntero nulo al intentar acceder a sus campos
        assertThrows(NullPointerException.class, () -> {
            libroIncompleto.autor.nombre = "Dennis M. Ritchie";
        }, "Debería arrojar NullPointerException porque la sub-instancia del autor es nula.");
    }
}