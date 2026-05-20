import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution30Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el almacenamiento de un producto estándar basado en el 'Sample Input 1'
    // (LILLHULT MiniUSB cable, precio 2.25). Verificamos que los datos se guarden y recuperen intactos.
    @Test
    public void testAsignacionYRetencionDeDatosEstandar() {
        ShoppingCart30 carrito = new ShoppingCart30();
        carrito.products = new Product30[1];

        carrito.products[0] = new Product30();
        carrito.products[0].name = "LILLHULT MiniUSB cable, 0.4 m";
        carrito.products[0].price = 2.25f;

        assertNotNull(carrito.products, "El array de productos no debería ser nulo.");
        assertEquals("LILLHULT MiniUSB cable, 0.4 m", carrito.products[0].name);
        assertEquals(2.25f, carrito.products[0].price, 0.001, "El precio del producto se desvió.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el comportamiento con un carrito de la compra con capacidad cero (0 productos).
    // El sistema debe permitir definir la longitud del array en su límite inferior sin arrojar excepciones.
    @Test
    public void testCarritoConCapacidadCero() {
        ShoppingCart30 carritoVacio = new ShoppingCart30();
        carritoVacio.products = new Product30[0]; // Límite inferior absoluto de tamaño

        assertEquals(0, carritoVacio.products.length, "La longitud del array de productos debe ser estrictamente 0.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Comprobamos el riesgo clásico de puntero nulo al trabajar con arrays de objetos.
    // Si instanciamos el array con `new Product30[2]`, las posiciones internas contienen 'null' por defecto.
    // Intentar acceder directamente a `.name` sin haber instanciado previamente la posición (`new Product30()`)
    // debe lanzar la excepción 'NullPointerException' de forma controlada.
    @Test
    public void testPosicionDelArrayNoInicializadaLanzaException() {
        ShoppingCart30 carritoIncompleto = new ShoppingCart30();
        carritoIncompleto.products = new Product30[2];
        // Omitimos intencionadamente: carritoIncompleto.products[0] = new Product30();

        // Validamos que salte el error al intentar asignar propiedades a una casilla vacía (null)
        assertThrows(NullPointerException.class, () -> {
            carritoIncompleto.products[0].name = "Cable Fantasma";
        }, "Debería arrojar NullPointerException porque la celda del array guarda un nulo.");
    }
}