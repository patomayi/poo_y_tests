import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution23Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos el flujo estándar usando los datos del 'Sample Input 0'.
    // Comprobamos que la estructura registre correctamente el nombre, el número de 16 dígitos,
    // el saldo y el límite de crédito en sus variables correspondientes.
    @Test
    public void testAsignacionDatosTarjetaEstandar() {
        CreditCard23 tarjeta = new CreditCard23();
        tarjeta.holderName = "Lola Mento";
        tarjeta.cardNumber = 1234567812345678L; // Nota la 'L' para indicar literal long
        tarjeta.accountBalance = 2000.5f;
        tarjeta.spendingLimit = 300.0f;

        assertEquals("Lola Mento", tarjeta.holderName);
        assertEquals(1234567812345678L, tarjeta.cardNumber, "El número de tarjeta sufrió desbordamiento o alteración.");
        assertEquals(2000.5f, tarjeta.accountBalance, 0.001);
        assertEquals(300.0f, tarjeta.spendingLimit, 0.001);
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Basado en el 'Sample Input 1'. Evaluamos los valores límites inferiores
    // numéricos como un saldo en '0' absoluto y un límite de gasto masivo de un millón.
    @Test
    public void testSaldosYLimitesFronterizos() {
        CreditCard23 tarjetaLimite = new CreditCard23();
        tarjetaLimite.holderName = "Elena Nito";
        tarjetaLimite.cardNumber = 9876543219876543L;
        tarjetaLimite.accountBalance = 0.0f; // Límite inferior de saldo
        tarjetaLimite.spendingLimit = 1000000.0f; // Límite superior alto

        assertEquals(0.0f, tarjetaLimite.accountBalance, "El sistema debería registrar un saldo de 0.0 perfectamente.");
        assertEquals(1000000.0f, tarjetaLimite.spendingLimit, "El límite millonario debe retenerse sin pérdida de precisión.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos el comportamiento por defecto de las propiedades de la clase antes de ser asignadas.
    // Al no tener un constructor explícito, Java asigna valores nulos a los objetos (String) y ceros a los primitivos.
    // Confirmar esto previene errores lógicos de ejecución en operaciones financieras.
    @Test
    public void testValoresPorDefectoAlInstanciar() {
        CreditCard23 tarjetaNueva = new CreditCard23();

        // El titular al ser una referencia de objeto (String) debe comenzar obligatoriamente en null
        assertNull(tarjetaNueva.holderName, "El nombre del titular sin inicializar debe ser null.");

        // Las variables primitivas numéricas deben arrancar en cero
        assertEquals(0L, tarjetaNueva.cardNumber, "El número de tarjeta por defecto debe ser 0.");
        assertEquals(0.0f, tarjetaNueva.accountBalance, 0.001, "El saldo por defecto debe ser 0.0.");
        assertEquals(0.0f, tarjetaNueva.spendingLimit, 0.001);
    }
}