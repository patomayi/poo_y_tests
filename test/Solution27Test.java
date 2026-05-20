import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution27Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo estándar usando los datos del 'Sample Input 0'
    // (Precio inicial = 10.0, Descuento = 15%). Verificamos que el precio final sea exactamente 8.5.
    @Test
    public void testAplicarDescuentoEstandar() {
        Producto27 prod = new Producto27("producto1", 10.0f);
        Descuento27 desc = new Descuento27(15.0f);

        desc.aplicar(prod);

        // Usamos una tolerancia (delta) de 0.001 para la precisión de tipos float
        assertEquals(8.5f, prod.precio, 0.001, "El descuento del 15% sobre 10.0 debería dejar el precio en 8.5");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos el comportamiento en los límites inferiores del descuento.
    // Si el descuento aplicado es de 0% (sin rebaja), el precio del producto debe permanecer
    // completamente intacto e inalterado.
    @Test
    public void testDescuentoCeroPorCiento() {
        Producto27 prodLimite = new Producto27("productoX", 100.0f);
        Descuento27 descLimite = new Descuento27(0.0f); // Límite inferior

        descLimite.aplicar(prodLimite);

        assertEquals(100.0f, prodLimite.precio, 0.001, "Un descuento de 0% no debe alterar el precio del producto.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos la estructura del formato de texto 'toString()' y la precisión con decimales
    // complejos (basado en el Sample Input 2: precio = 4.5, descuento = 1.5). Nos aseguramos de que el string
    // generado coincida letra por letra con las restricciones exigidas por el software de corrección.
    @Test
    public void testFormatoToStringYPrecisionDecimal() {
        Producto27 prodDecimal = new Producto27("productoV", 4.5f);
        Descuento27 descDecimal = new Descuento27(1.5f);

        // 1. Validamos el toString() antes de la rebaja
        String esperadoAntes = "Producto{descripcion='productoV', precio=4.5}";
        assertEquals(esperadoAntes, prodDecimal.toString(), "El formato de salida del método toString() es incorrecto.");

        // 2. Aplicamos el descuento complejo: 4.5 - (4.5 * 0.015) = 4.4325
        descDecimal.aplicar(prodDecimal);
        assertEquals(4.4325f, prodDecimal.precio, 0.001, "Falló la precisión matemática en descuentos flotantes complejos.");
    }
}