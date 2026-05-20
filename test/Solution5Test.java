import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution5Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Verificamos que un coche con datos estándar extraídos del caso de prueba
    // se cree correctamente mapeando cada propiedad en su lugar correspondiente.
    @Test
    public void testCreacionCocheCorrecta() {
        // Inicializamos un objeto usando datos reales del Ferrari FXX K EVO
        Car coche = new Car("FERRARI FXX K EVO", 370, 2.50f, 24.30f, 1.48f);

        // Verificamos las cadenas de texto
        assertEquals("FERRARI FXX K EVO", coche.model, "El modelo de coche no coincide.");
        // Verificamos los enteros
        assertEquals(370, coche.topSpeed, "La velocidad máxima no coincide.");
        // Verificamos los decimales (float). Usamos un delta de tolerancia (0.001) para evitar errores de precisión.
        assertEquals(2.50f, coche.acceleration, 0.001, "La aceleración no coincide.");
        assertEquals(24.30f, coche.braking, 0.001, "La capacidad de frenado no coincide.");
        assertEquals(1.48f, coche.cornering, 0.001, "El paso por curva no coincide.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: Evaluamos los límites inferiores numéricos. En la simulación de un videojuego
    // o base de datos, un coche roto o estático podría tener estadísticas en 0 o vacías.
    @Test
    public void testCocheConValoresMinimos() {
        // Creamos un objeto con los límites inferiores permitidos por los tipos de datos primarios
        Car cocheInmovil = new Car("", 0, 0.0f, 0.0f, 0.0f);

        assertEquals("", cocheInmovil.model, "El modelo debería aceptar cadenas vacías.");
        assertEquals(0, cocheInmovil.topSpeed, "La velocidad mínima debería poder ser 0.");
        assertEquals(0.0f, cocheInmovil.acceleration, 0.001);
    }

    // TEST 3: CASO EXCEPCIONAL / ERROR
    // EXPLICACIÓN: Evaluamos cómo se comporta el constructor si recibe valores inesperados o nulos.
    // Como Java permite que los Strings apunten a null, debemos certificar que el constructor no se rompa
    // con un NullPointerException al instanciarse bajo estas condiciones.
    @Test
    public void testCocheConCamposNulosYNegativos() {
        // Pasamos null en las referencias y valores negativos en las propiedades físicas
        Car cocheErroneo = new Car(null, -100, -2.5f, -1.0f, -0.5f);

        // Comprobamos que el objeto se crea (no es nulo) pero sus propiedades internas contienen las anomalías pasadas
        assertNotNull(cocheErroneo, "El objeto Car debería crearse incluso con parámetros inválidos.");
        assertNull(cocheErroneo.model, "El modelo debería quedar guardado como null.");
        assertTrue(cocheErroneo.topSpeed < 0, "La velocidad máxima debería registrarse como negativa si el constructor no la valida.");
    }
}