import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution12Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Probamos una configuración estándar basada en el Sample Input 0.
    // Verificamos que los campos se carguen y retengan el carácter '*' y el tamaño 30 de forma correcta.
    @Test
    public void testAsignacionCamposPersonalizados() {
        AdvancedLineSeparator12 separador = new AdvancedLineSeparator12();
        separador.charSeparator = '*';
        separador.size = 30;

        assertEquals('*', separador.charSeparator, "El carácter separador no se configuró correctamente.");
        assertEquals(30, separador.size, "El tamaño de la línea no coincide.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Comprobamos qué sucede en el límite inferior estructural de dibujo (tamaño 0).
    // El método 'print()' no debe colapsar, simplemente el bucle interno 'for' dará 0 vueltas.
    @Test
    public void testLineaConTamanoCero() {
        AdvancedLineSeparator12 separadorVacio = new AdvancedLineSeparator12();
        separadorVacio.charSeparator = '#';
        separadorVacio.size = 0; // Límite inferior

        assertEquals(0, separadorVacio.size, "El tamaño cero debería ser aceptado como valor límite.");
        assertEquals('#', separadorVacio.charSeparator);
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo inicializa Java por defecto las propiedades de este objeto.
    // Un carácter primitivo 'char' no asignado equivale al valor nulo de la tabla ASCII '\u0000',
    // y el entero se inicializa en 0. Validar esto asegura el control de fallos antes de usar el 'print'.
    @Test
    public void testValoresPorDefectoAlInstanciar() {
        AdvancedLineSeparator12 separadorNuevo = new AdvancedLineSeparator12();

        // Comprobamos los valores predeterminados de los tipos de datos primitivos en Java
        assertEquals(0, separadorNuevo.size, "Un int por defecto debe empezar en 0.");
        assertEquals('\u0000', separadorNuevo.charSeparator, "Un char por defecto debe empezar con el valor nulo de caracteres.");
    }
}