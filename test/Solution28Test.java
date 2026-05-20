import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution28Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Validamos la instanciación de un guerrero estándar. Verificamos que
    // sus estadísticas se carguen con los valores exactos definidos en el Sample Output (50 de vida, 60 de arma).
    @Test
    public void testInicializacionGuerreroEstandar() {
        Enemy28 g = new Enemy28("guerrero");

        assertNotNull(g.health, "La estadística 'health' del guerrero no debería ser nula.");
        assertNotNull(g.weapon, "La estadística 'weapon' del guerrero no debería ser nula.");

        assertEquals(50, g.health.value, "El valor actual de salud del guerrero debe ser 50.");
        assertEquals(50, g.health.max, "El valor máximo de salud del guerrero debe ser 50.");
        assertEquals(60, g.weapon.value, "El valor de arma del guerrero debe ser 60.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos la asignación del rol con menor salud del juego ("brujo") con 30 puntos,
    // garantizando que las fronteras de inicialización más bajas se cumplan estrictamente sin mezclarse.
    @Test
    public void testInicializacionBrujoValoresMinimos() {
        Enemy28 b = new Enemy28("brujo");

        assertEquals(30, b.health.value, "La salud del brujo representa el límite inferior del juego (30).");
        assertEquals(80, b.weapon.max, "El arma del brujo representa el límite superior de durabilidad (80).");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: ¿Qué ocurre si pasamos un nombre de clase inexistente por parámetro (ej. "orco")?
    // Comprobamos que el constructor maneje la falta de coincidencias de forma segura. Al no entrar en ningún
    // bloque condicional, los atributos 'health' y 'weapon' quedarán como 'null', previniendo fallos colaterales.
    @Test
    public void testTipoEnemigoInexistenteDejaCamposNulos() {
        Enemy28 orco = new Enemy28("orco");

        assertNull(orco.health, "Un tipo desconocido no debe inicializar la estadística de salud.");
        assertNull(orco.weapon, "Un tipo desconocido no debe inicializar la estadística de arma.");
    }
}