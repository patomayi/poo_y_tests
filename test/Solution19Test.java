import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution19Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos la construcción estándar basándonos en el 'Sample Input 0'.
    // Comprobamos que al invocar '.toString()' la URL resultante esté perfectamente estructurada.
    @Test
    public void testConstruccionUrlEstandar() {
        URL19 url = new URL19();
        url.protocol = "http";
        url.domain = "www.mydomain.com";
        url.path = "/path/to";
        url.query = "query=true";
        url.fragment = "fragment1";

        String resultado = url.toString();
        String esperado = "http://www.mydomain.com/path/to?query=true#fragment1";

        assertEquals(esperado, resultado, "La concatenación de la URL con sus delimitadores falló.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el comportamiento con cadenas de texto mínimas o caracteres especiales breves
    // en los campos de la query o fragmento (basado en el Sample Input 1, donde q=1&s=1 contiene un ampersand).
    @Test
    public void testUrlConCaracteresEspecialesEnQuery() {
        URL19 urlLimite = new URL19();
        urlLimite.protocol = "https";
        urlLimite.domain = "anotherdomain.cat";
        urlLimite.path = "/path/to/page";
        urlLimite.query = "q=1&s=1";
        urlLimite.fragment = "frag";

        String resultado = urlLimite.toString();
        String esperado = "https://anotherdomain.cat/path/to/page?q=1&s=1#frag";

        assertEquals(esperado, resultado, "Falló la construcción con parámetros múltiples de query.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: ¿Qué pasa si pasamos strings vacíos a los componentes de la URL?
    // Comprobamos que el método sea robusto, no lance ninguna excepción de puntero nulo y monte
    // la estructura base únicamente con los caracteres delimitadores (`://?#`).
    @Test
    public void testComponentesVaciosNoLanzanError() {
        URL19 urlVacia = new URL19();
        urlVacia.protocol = "";
        urlVacia.domain = "";
        urlVacia.path = "";
        urlVacia.query = "";
        urlVacia.fragment = "";

        String resultado = urlVacia.toString();

        assertNotNull(resultado, "El método toString() jamás debe retornar un nulo real.");
        assertEquals("://?#", resultado, "La estructura de separadores mínimos debe mantenerse fija.");
    }
}