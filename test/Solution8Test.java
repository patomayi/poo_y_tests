import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution8Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos que al crear un libro y asignarle valores válidos en sus campos,
    // la memoria los retenga correctamente respetando los tipos String, int y boolean.
    @Test
    public void testAsignacionPropiedadesLibro() {
        Book libro = new Book();
        libro.title = "Through the looking glass";
        libro.yearOfPublishing = 1871;
        libro.isAvailable = true;

        assertEquals("Through the looking glass", libro.title, "El título no se asignó correctamente.");
        assertEquals(1871, libro.yearOfPublishing, "El año de publicación no coincide.");
        assertTrue(libro.isAvailable, "El estado de disponibilidad debería ser true.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Comprobamos el comportamiento con los límites inferiores por defecto del sistema.
    // Por ejemplo, el año 0 en el calendario o un título vacío de un manuscrito sin catalogar.
    @Test
    public void testLibroConValoresLimites() {
        Book libroLimite = new Book();
        libroLimite.title = "";
        libroLimite.yearOfPublishing = 0;
        libroLimite.isAvailable = false;

        assertEquals("", libroLimite.title, "Debería soportar cadenas de texto vacías.");
        assertEquals(0, libroLimite.yearOfPublishing, "El año cero debería ser un entero válido.");
        assertFalse(libroLimite.isAvailable, "La disponibilidad debería registrarse como false.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos el estado inicial de un objeto recién creado con el constructor por defecto.
    // En Java, los objetos se inicializan con valores predeterminados (null para referencias, 0 para enteros
    // y false para booleanos). Validar esto evita errores de lógica antes de usar el objeto.
    @Test
    public void testValoresPredeterminadosAlInstanciar() {
        Book libroNuevo = new Book();

        // Verificamos que los valores por defecto de Java se apliquen correctamente en nuestra estructura
        assertNull(libroNuevo.title, "Un String no inicializado debe empezar siendo null.");
        assertEquals(0, libroNuevo.yearOfPublishing, "Un entero no inicializado debe empezar en 0.");
        assertFalse(libroNuevo.isAvailable, "Un booleano no inicializado debe empezar en false.");
    }
}