import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution39Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo del enunciado. Accedemos al tercer nivel de profundidad
    // (`box.innerBox.innerBox.innerBox.width`) y verificamos que devuelva exactamente 4.75f.
    @Test
    public void testAccesoAnidamientoProfundoEstandar() {
        Box39 box = new Box39();
        box.innerBox = new Box39();
        box.innerBox.innerBox = new Box39();
        box.innerBox.innerBox.innerBox = new Box39();
        box.innerBox.innerBox.innerBox.width = 4.75f;

        assertNotNull(box.innerBox.innerBox.innerBox, "La estructura de cajas anidadas no debe romperse.");
        assertEquals(4.75f, box.innerBox.innerBox.innerBox.width, 0.001, "El valor en el nivel profundo se alteró.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el límite de una caja simple que no contiene nada en su interior.
    // El atributo 'innerBox' debe ser 'null' por defecto, representando el final de la cadena de cajas.
    @Test
    public void testCajaFronteraSinContenidoInterior() {
        Box39 cajaUnica = new Box39();
        cajaUnica.width = 50.0f;

        assertEquals(50.0f, cajaUnica.width, 0.001);
        assertNull(cajaUnica.innerBox, "El límite final de la estructura recursiva debe apuntar a null.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Validamos el riesgo clásico de esta estructura: intentar acceder a una caja interna
    // que no ha sido instanciada con 'new Box39()'. Intentar leer `.length` en un nivel no creado
    // debe lanzar 'NullPointerException' de forma controlada.
    @Test
    public void testAccesoACajaInternaNoInstanciadaLanzaException() {
        Box39 cajaMadre = new Box39();
        // Omitimos instanciar: cajaMadre.innerBox = new Box39();

        assertThrows(NullPointerException.class, () -> {
            float x = cajaMadre.innerBox.length;
        }, "Debería arrojar NullPointerException porque innerBox está vacío (null).");
    }
}