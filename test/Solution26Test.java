import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution26Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Validamos el flujo estándar usando los datos del Sample Output 0.
    // Comprobamos que el objeto retenga los valores asignados correctamente.
    @Test
    public void testAsignacionCamposEstandar() {
        CompteCorrent26 cuenta = new CompteCorrent26();
        cuenta.saldo = 999.9f;
        cuenta.nomPropietari = "Jeff Bezos";
        cuenta.bloquejada = false;

        assertEquals(999.9f, cuenta.saldo, 0.001, "El saldo asignado no coincide.");
        assertEquals("Jeff Bezos", cuenta.nomPropietari, "El nombre del propietario no coincide.");
        assertFalse(cuenta.bloquejada, "La cuenta debería estar desbloqueada (false).");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites lógicos modificando el estado de la cuenta a bloqueada (`true`)
    // y estableciendo un saldo límite en cero absoluto.
    @Test
    public void testCuentaBloqueadaYSaldoCero() {
        CompteCorrent26 cuentaLimite = new CompteCorrent26();
        cuentaLimite.saldo = 0.0f;
        cuentaLimite.nomPropietari = "Elon Musk";
        cuentaLimite.bloquejada = true; // Cambio de estado límite

        assertEquals(0.0f, cuentaLimite.saldo, 0.001);
        assertTrue(cuentaLimite.bloquejada, "La cuenta debería registrarse correctamente como bloqueada (true).");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Comprobamos el comportamiento de los valores por defecto de Java al instanciar
    // la clase sin asignarle ningún valor. Esto garantiza que una cuenta corriente nueva empiece de
    // manera segura con saldo 0.0, propietario null y sin bloqueos accidentales (false).
    @Test
    public void testValoresPorDefectoAlInstanciar() {
        CompteCorrent26 cuentaNueva = new CompteCorrent26();

        assertEquals(0.0f, cuentaNueva.saldo, 0.001, "El saldo inicial por defecto de Java debe ser 0.0.");
        assertNull(cuentaNueva.nomPropietari, "El nombre de usuario por defecto debe ser null.");
        assertFalse(cuentaNueva.bloquejada, "El booleano por defecto debe ser false.");
    }
}