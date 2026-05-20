import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution21Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos una carga manual de datos idéntica al 'Sample Input 0'.
    // Verificamos que la estructura anidada retenga los datos en memoria con éxito.
    @Test
    public void testCargaYAsignacionEstandar() {
        Contacto21 contacto = new Contacto21();
        contacto.direccion = new Direccion21();

        // Simulamos la inserción manual
        contacto.nombre = "Adrian";
        contacto.apellidos = "Droide Perez";
        contacto.direccion.calle = "C/Calleja, 2";
        contacto.direccion.codPostal = "09876";
        contacto.direccion.ciudad = "Barcelona";
        contacto.direccion.provincia = "Barcelona";

        // Verificaciones
        assertEquals("Adrian", contacto.nombre);
        assertEquals("Droide Perez", contacto.apellidos);
        assertEquals("C/Calleja, 2", contacto.direccion.calle, "La dirección de la calle falló al enlazarse.");
        assertEquals("09876", contacto.direccion.codPostal);
        assertEquals("Barcelona", contacto.direccion.ciudad);
        assertEquals("Barcelona", contacto.direccion.provincia);
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los valores límites mínimos de texto. ¿Qué ocurre si un campo como
    // el código postal o el piso tiene caracteres numéricos atípicos, espacios extras o cadenas vacías?
    @Test
    public void testValoresLimitesDeDireccion() {
        Contacto21 contactoLimite = new Contacto21();
        contactoLimite.direccion = new Direccion21();

        contactoLimite.nombre = "A"; // Nombre de un solo carácter
        contactoLimite.apellidos = "B";
        contactoLimite.direccion.calle = ""; // Calle vacía
        contactoLimite.direccion.codPostal = "00000"; // CP límite inferior numérico

        assertEquals("A", contactoLimite.nombre);
        assertEquals("", contactoLimite.direccion.calle, "El sistema debe soportar strings vacíos en la calle.");
        assertEquals("00000", contactoLimite.direccion.codPostal, "El código postal fronterizo debe ser válido.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Comprobamos el error crítico clásico de objetos compuestos: 'NullPointerException'.
    // Si intentamos asignar datos a la dirección sin haber inicializado primero el subobjeto
    // 'new Direccion21()', Java debe lanzar de forma controlada la excepción de puntero nulo.
    @Test
    public void testSubobjetoNoInicializadoLanzaException() {
        Contacto21 contactoIncompleto = new Contacto21();
        // Omitimos intencionadamente: contactoIncompleto.direccion = new Direccion21();

        // Validamos que el acceso a un campo de un objeto nulo rompa de forma segura y esperada
        assertThrows(NullPointerException.class, () -> {
            contactoIncompleto.direccion.calle = "C/Falsa 123";
        }, "Debería lanzar NullPointerException porque el objeto direccion es nulo.");
    }
}