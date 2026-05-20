import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution20Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓ: Verifiquem un flux normal d'avanç de temps i format. Si fem 1 tick,
    // el mètode getTime() ens ha de retornar correctament "00:00:01".
    @Test
    public void testAvançIFormatEstandard() {
        Clock20 rellotge = new Clock20();
        rellotge.tick();

        assertEquals("00:00:01", rellotge.getTime(), "El format o el recompte de segons inicial ha fallat.");
    }

    // TEST 2: VALOR LÍMITE / FRONTERA (Boundary Value)
    // EXPLICACIÓ: Evaluem el límit crític de desbordament on 59 segons passen a 1 minut.
    // Fem un bucle de 60 ticks per assegurar-nos que els segons es reinicien a 0 i es sumi 1 als minuts.
    @Test
    public void testDesbordamentDeSegonsAMinuts() {
        Clock20 rellotgeLimite = new Clock20();

        // Forcem que passi exactament un minut sencer tick a tick
        for (int i = 0; i < 60; i++) {
            rellotgeLimite.tick();
        }

        assertEquals(0, rellotgeLimite.seconds, "Els segons s'haurien d'haver reiniciat a 0.");
        assertEquals(1, rellotgeLimite.minutes, "S'hauria d'haver sumat 1 minut al comptador.");
        assertEquals("00:01:00", rellotgeLimite.getTime(), "El desbordament de segons a minuts ha fallat en format string.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓ: Comprovem el funcionament del mètode 'reset()' en qualsevol moment del cicle de vida.
    // Si el rellotge es troba en un temps qualsevol (p.ex. "01:01:01" extret del Sample Input 0) i rep
    // l'ordre de reset, l'estat intern de l'objecte ha de tornar instantàniament a "00:00:00".
    @Test
    public void testResetEnTempsQualsevol() {
        Clock20 rellotgeReset = new Clock20();

        // Simulem que ha passat una hora, un minut i un segon (3661 segons)
        for (int i = 0; i < 3661; i++) {
            rellotgeReset.tick();
        }
        assertEquals("01:01:01", rellotgeReset.getTime());

        // Executamos la restauració de fàbrica del mètode
        rellotgeReset.reset();

        assertEquals(0, rellotgeReset.hours, "Les hores no s'han reiniciat correctament.");
        assertEquals(0, rellotgeReset.minutes, "Els minuts no s'han reiniciat correctament.");
        assertEquals(0, rellotgeReset.seconds, "Els segons no s'han reiniciat correctament.");
        assertEquals("00:00:00", rellotgeReset.getTime(), "La cadena després del reset ha de ser zero absolut.");
    }
}