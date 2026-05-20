import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution6Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos el comportamiento estándar del sistema emulando el Test Case 1.
    // Verificamos que al instanciar toda la estructura en cadena (Stream -> Post -> Author)
    // los datos se queden bien grabados y que el método '.trim()' limpie correctamente los espacios.
    @Test
    public void testFlujoCompletoDatosCorrectos() {
        // 1. Instanciamos la jerarquía completa de objetos en memoria
        Stream6 stream = new Stream6();
        stream.posts = new Post6[1]; // Array de tamaño 1

        stream.posts[0] = new Post6();
        stream.posts[0].author = new Author6();

        // 2. Simulamos la inserción de datos limpios
        stream.posts[0].author.name = "@popeye";
        stream.posts[0].author.photoURL = "http://img.io/1234.jpg";

        // Simulamos la lectura de contenido usando el .trim() para quitar espacios residuales
        String entradaScanner = "   Hola que tal   ";
        stream.posts[0].content = entradaScanner.trim();

        // 3. Verificaciones de seguridad (Asserts)
        assertNotNull(stream.posts[0], "El Post6 no debería ser nulo en memoria.");
        assertNotNull(stream.posts[0].author, "El Author6 anidado no debería ser nulo.");
        assertEquals("@popeye", stream.posts[0].author.name, "El nombre de usuario falló.");
        assertEquals("Hola que tal", stream.posts[0].content, "El .trim() no limpió los espacios correctamente.");
    }

    // TEST 2: VALORES LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el límite inferior de la estructura de datos. ¿Qué pasa si el scanner
    // recibe que se van a procesar 0 posts? El array debe inicializarse con tamaño 0 y no colapsar.
    @Test
    public void testLimiteDePostsEnCero() {
        Stream6 streamVacio = new Stream6();

        // Inicializamos el array con longitud cero (límite estructural)
        streamVacio.posts = new Post6[0];

        assertEquals(0, streamVacio.posts.length, "El sistema debería admitir streams de 0 elementos.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Basado en el Test Case 2 del ejercicio, donde la URL de la foto llega como "null" (String)
    // y el mensaje tiene palabras clave. Comprobamos que el sistema trate el texto "null" como una cadena válida
    // y que soporte textos largos sin romper las referencias de memoria.
    @Test
    public void testUrlComoTextoNullYContenidoLargo() {
        Stream6 stream = new Stream6();
        stream.posts = new Post6[1];
        stream.posts[0] = new Post6();
        stream.posts[0].author = new Author6();

        // Asignamos la cadena literal "null" tal como lo hace el Scanner en el Test Case 2
        stream.posts[0].author.photoURL = "null";
        stream.posts[0].content = "Mensaje largo de prueba para simular fallos de desbordamiento en el Scanner";

        // Comprobamos que el sistema no confunda el String "null" con un valor nulo real de Java
        assertNotNull(stream.posts[0].author.photoURL, "La URL no es un null real de Java, es un texto.");
        assertEquals("null", stream.posts[0].author.photoURL, "El valor almacenado debe ser el texto 'null'.");
        assertTrue(stream.posts[0].content.length() > 20, "El contenido del post debería almacenar frases largas.");
    }
}