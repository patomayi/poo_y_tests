import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution9Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos que al llamar a 'switchOn()', el estado del LED pase
    // efectivamente a ser verdadero ('true') y que al llamar a 'switchOff()' pase a ser falso ('false').
    @Test
    public void testEncendidoYApagadoCorrecto() {
        Led led = new Led();

        // Encendemos y verificamos
        led.switchOn();
        assertTrue(led.state, "El método switchOn() debería cambiar el estado a true.");

        // Apagamos y verificamos
        led.switchOff();
        assertFalse(led.state, "El método switchOff() debería cambiar el estado a false.");
    }

    // TEST 2: VALOR LÍMITE / FRONTERA
    // EXPLICACIÓN: Evaluamos el estado inicial de inicialización por defecto. En Java, todas las variables
    // booleanas primitivas de una clase se inicializan automáticamente como 'false'. Debemos comprobar que
    // al crear un LED, este empiece apagado sin necesidad de llamarle a ningún método previamente.
    @Test
    public void testEstadoInicialPorDefecto() {
        Led ledNuevo = new Led();

        // El LED debe nacer apagado obligatoriamente
        assertFalse(ledNuevo.state, "Un nuevo LED debe inicializarse por defecto en false (apagado).");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE REPETICIÓN
    // EXPLICACIÓN: ¿Qué pasa si llamamos repetidas veces al mismo método consecutivamente? (Idempotencia).
    // Si un LED ya está encendido y volvemos a llamar a 'switchOn()', su estado debe mantenerse en 'true'
    // de manera estable sin provocar comportamientos anómalos ni errores en el objeto.
    @Test
    public void testLlamadasConsecutivasMismoEstado() {
        Led led = new Led();

        // Forzamos múltiples llamadas al encendido consecutivas
        led.switchOn();
        led.switchOn();
        led.switchOn();

        assertTrue(led.state, "El estado debe seguir siendo true tras múltiples llamadas a switchOn().");

        // Forzamos múltiples llamadas al apagado consecutivas
        led.switchOff();
        led.switchOff();

        assertFalse(led.state, "El estado debe seguir siendo false tras múltiples llamadas a switchOff().");
    }
}