import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution32Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos la asignación de datos estándar basada en el 'Sample Input 0'.
    // Verificamos que el objeto guarde con fidelidad las cadenas con espacios y los valores numéricos.
    @Test
    public void testAsignacionProductoEstandar() {
        Producte32 prod = new Producte32();
        prod.nom = "Corsair Vengeance RGB Pro";
        prod.descripcio = "DDR4 3200 PC4-25600 16GB 2x8GB CL16";
        prod.preu = 109.0f;
        prod.stock = 25;

        assertEquals("Corsair Vengeance RGB Pro", prod.nom);
        assertEquals("DDR4 3200 PC4-25600 16GB 2x8GB CL16", prod.descripcio);
        assertEquals(109.0f, prod.preu, 0.001);
        assertEquals(25, prod.stock, "La cantidad de unidades en stock sufrió alteraciones.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites inferiores basados en el 'Sample Input 1' combinados con escenarios
    // frontera como un stock mínimo de 0 piezas. Las propiedades numéricas deben soportar el valor límite de stock nulo.
    @Test
    public void testStockFronteraEnCero() {
        Producte32 prodLimite = new Producte32();
        prodLimite.nom = "Kingston HyperX Fury Black";
        prodLimite.descripcio = "16GB DDR4 2666Mhz PC-21300 (2x8GB) CL16";
        prodLimite.preu = 79.5f;
        prodLimite.stock = 0; // Límite inferior absoluto de inventario útil

        assertEquals(0, prodLimite.stock, "El sistema de inventario debe admitir que no quede stock de un producto.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Comprobamos el comportamiento de los valores por defecto de inicialización de Java.
    // Al no disponer de constructor, un producto recién creado debe arrancar obligatoriamente en nulo
    // para los Strings y en 0 para los primitivos. Asegurar esto evita el procesamiento accidental de basura en memoria.
    @Test
    public void testValoresInicialesPorDefecto() {
        Producte32 prodNuevo = new Producte32();

        assertNull(prodNuevo.nom, "El nombre no inicializado debe ser null por defecto de la JVM.");
        assertNull(prodNuevo.descripcio, "La descripción sin asignar debe ser null.");
        assertEquals(0.0f, prodNuevo.preu, 0.001, "El precio por defecto inicial debe arrancar en 0.0.");
        assertEquals(0, prodNuevo.stock, "El stock por defecto inicial debe arrancar en 0.");
    }
}