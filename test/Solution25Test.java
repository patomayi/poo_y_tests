import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution25Test {

    // TEST 1: CAMINO FELIZ (Happy Path)
    // EXPLICACIÓN: Evaluamos un escenario estándar basado en el 'Sample Input 0' (velocidades: 10, 20, 30).
    // El método 'fastest()' debe encontrar y retornar con éxito el objeto que contiene la velocidad de 30.
    @Test
    public void testBuscarMotoMasRapidaEstandar() {
        Race25 carrera = new Race25();
        carrera.bikes = new Bike25[3];
        carrera.bikes[0] = new Bike25(10);
        carrera.bikes[1] = new Bike25(20);
        carrera.bikes[2] = new Bike25(30);

        Bike25 resultado = carrera.fastest();

        assertNotNull(resultado, "El resultado no debería ser nulo para un array con elementos.");
        assertEquals(30, resultado.speed, "La velocidad máxima encontrada debería ser 30.");
    }

    // TEST 2: VALOR LÍMITE (Boundary Value)
    // EXPLICACIÓN: ¿Qué pasa si el array se encuentra completamente vacío (longitud 0)?
    // Evaluamos el límite inferior de la estructura. El método debe gestionar la condición de parada
    // de forma segura y devolver 'null' en lugar de lanzar una excepción de índice fuera de rango.
    @Test
    public void testCarreraVaciaDevuelveNull() {
        Race25 carreraVacia = new Race25();
        carreraVacia.bikes = new Bike25[0]; // Límite de tamaño cero

        Bike25 resultado = carreraVacia.fastest();

        assertNull(resultado, "Si el array tiene tamaño 0, el método fastest() debe retornar null.");
    }

    // TEST 3: CASO EXCEPCIONAL / ESCENARIO DE ERROR
    // EXPLICACIÓN: Evaluamos cómo se comporta el algoritmo ante velocidades duplicadas u ordenadas de forma
    // decreciente (basado en el Sample Input 1 y 2, ej: 40, 30). Comprobamos que el condicional del bucle
    // mantenga correctamente la primera moto más rápida detectada sin corromper la referencia del objeto.
    @Test
    public void testCarreraConMasRapidaAlInicioYDuplicados() {
        Race25 carreraDecreciente = new Race25();
        carreraDecreciente.bikes = new Bike25[4];
        carreraDecreciente.bikes[0] = new Bike25(30); // La más rápida está al principio
        carreraDecreciente.bikes[1] = new Bike25(30); // Duplicado de la velocidad máxima
        carreraDecreciente.bikes[2] = new Bike25(20);
        carreraDecreciente.bikes[3] = new Bike25(10);

        Bike25 resultado = carreraDecreciente.fastest();

        assertNotNull(resultado);
        assertEquals(30, resultado.speed, "Debe ser capaz de encontrar el 30 aunque esté al principio y duplicado.");
    }
}