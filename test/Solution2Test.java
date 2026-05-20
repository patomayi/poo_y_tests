import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution2Test {

    // 1. CAMINO FELIZ (Happy Path)
    // Verificamos que los datos comunes (texto y números normales) se asignen correctamente.
    @Test
    public void testCreacionPostCorrecta() {
        Post1 post1 = new Post1("@user", "Hola Mundo", 150, 45);

        assertEquals("@user", post1.user, "El usuario no se asignó correctamente");
        assertEquals("Hola Mundo", post1.content, "El contenido no se asignó correctamente");
        assertEquals(150, post1.favs, "Los favs no coinciden");
        assertEquals(45, post1.retweets, "Los retweets no coinciden");
    }

    // 2. VALORES LÍMITE / FRONTERA (Boundary Values)
    // Los contadores de redes sociales pueden empezar en 0. Probamos los límites inferiores.
    @Test
    public void testPostConValoresEnCero() {
        Post1 post1Nuevecito = new Post1("@nuevo", "Primer tweet", 0, 0);

        assertEquals(0, post1Nuevecito.favs, "El contador de favs debería aceptar 0");
        assertEquals(0, post1Nuevecito.retweets, "El contador de retweets debería aceptar 0");
    }

    // 3. CASOS EXCEPCIONALES / ERROR
    // ¿Qué pasa si el contenido del mensaje o el usuario vienen vacíos o nulos?
    // El constructor los debe aceptar igual porque son objetos String.
    @Test
    public void testPostConCamposVaciosONulos() {
        Post1 post1Vacio = new Post1("", "", 0, 0);
        Post1 post1Nulo = new Post1(null, null, 10, 10);

        // Verificaciones para el caso vacío
        assertEquals("", post1Vacio.user);
        assertEquals("", post1Vacio.content);

        // Verificaciones para el caso nulo
        assertNull(post1Nulo.user, "El usuario debería poder ser null");
        assertNull(post1Nulo.content, "El contenido debería poder ser null");
    }
}