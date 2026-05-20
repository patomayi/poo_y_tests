import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution4Test {

    // 1. CAMINO FELIZ
    // Verificamos que se pueda instanciar la clase y asignar notas correctamente
    @Test
    public void testAsignacionNotasCorrecta() {
        Alumno alumno = new Alumno();
        alumno.notas = new float[]{9.0f, 5.6f, 7.0f, 7.5f, 6.4f};

        assertNotNull(alumno.notas, "El array de notas no debería ser nulo");
        assertEquals(5, alumno.notas.length, "El alumno debería tener exactamente 5 notas");
        assertEquals(5.6f, alumno.notas[1], 0.01, "La segunda nota debería ser 5.6");
    }

    // 2. VALOR LÍMITE
    // ¿Qué pasa si un alumno tiene 0 notas? El sistema debe permitir un array de tamaño 0
    @Test
    public void testAlumnoSinNotas() {
        Alumno alumnoSiniestro = new Alumno();
        alumnoSiniestro.notas = new float[0]; // Tamaño cero

        assertEquals(0, alumnoSiniestro.notas.length, "El tamaño del array debería ser 0");
    }

    // 3. CASO EXCEPCIONAL / ERROR
    // Por defecto, al crear un Alumno su atributo 'notas' es 'null' hasta que se inicializa.
    // Es importante verificar que inicialmente no apunte a ninguna dirección de memoria.
    @Test
    public void testAlumnoNotasInicialmenteNulas() {
        Alumno alumnoNuevo = new Alumno();

        assertNull(alumnoNuevo.notas, "El array de notas debería ser null antes de ser inicializado con 'new'");
    }
}