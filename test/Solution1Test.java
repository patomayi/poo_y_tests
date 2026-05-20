import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution1Test {

    // 1. CAMINO FELIZ (Happy Path)
    // Comprobamos que un usuario se crea correctamente con datos válidos
    @Test
    void testCreacionUsuarioCorrecta() {
        // Instanciamos un usuario de prueba
        User user = new User(1001, "acasas", "Armando Casas", "acasas@mail.com");

        // Verificamos (Assert) que cada campo tenga el valor esperado
        assertEquals(1001, user.id, "El ID no coincide");
        assertEquals("acasas", user.username, "El username no coincide");
        assertEquals("Armando Casas", user.displayName, "El displayName no coincide");
        assertEquals("acasas@mail.com", user.email, "El email no coincide");
    }

    // 2. CASO LÍMITE / FRONTERA (Boundary Case)
    // ¿Qué pasa si el ID es 0 o un número negativo? El sistema debería permitirlo según las restricciones básicas de un int
    @Test
    void testCreacionUsuarioConIdLimite() {
        User userNegativo = new User(-1, "test", "Test", "test@mail.com");
        User userCero = new User(0, "test", "Test", "test@mail.com");

        assertEquals(-1, userNegativo.id);
        assertEquals(0, userCero.id);
    }

    // 3. CASO EXCEPCIONAL / ERROR
    // ¿Qué pasa si enviamos valores nulos (null)? El constructor actual lo permite porque son Strings,
    // pero es importante testear cómo se comporta.
    @Test
    void testCreacionUsuarioConCamposNulos() {
        User userNull = new User(1002, null, null, null);

        assertNotNull(userNull, "El objeto User no debería ser nulo");
        assertNull(userNull.username, "El username debería ser null");
        assertNull(userNull.displayName, "El displayName debería ser null");
        assertNull(userNull.email, "El email debería ser null");
    }
}