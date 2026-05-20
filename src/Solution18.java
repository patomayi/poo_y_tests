import java.io.*;
import java.util.*;

class Equation2D18 {
    float a, b, c;

    // EXPLICACIÓN DEL MÉTODO solve:
    // 1. Calculamos el discriminante (b^2 - 4ac) usando Math.sqrt().
    // 2. Aplicamos la fórmula cuadrática tanto para la suma (+) como para la resta (-).
    // 3. Almacenamos y retornamos los dos resultados en un array de float de tamaño 2.
    public float[] solve() {
        float[] soluciones = new float[2];

        // Operamos con Math.sqrt (que requiere double) y casteamos el resultado a float
        float discriminante = (float) Math.sqrt((b * b) - (4 * a * c));

        // Primera solución (con el signo +)
        soluciones[0] = (-b + discriminante) / (2 * a);

        // Segunda solución (con el signo -)
        soluciones[1] = (-b - discriminante) / (2 * a);

        return soluciones;
    }
}

public class Solution18 { // Recuerda cambiar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equation2D18 equation2D = new Equation2D18();

        equation2D.a = scanner.nextFloat();
        equation2D.b = scanner.nextFloat();
        equation2D.c = scanner.nextFloat();

        float[] x = equation2D.solve();

        System.out.format("%1$.2f * %4$.2f * %4$.2f  + %2$.2f * %4$.2f + %3$.2f = 0%n",
                equation2D.a, equation2D.b, equation2D.c, x[0]);
        System.out.format("%1$.2f * %4$.2f * %4$.2f  + %2$.2f * %4$.2f + %3$.2f = 0%n",
                equation2D.a, equation2D.b, equation2D.c, x[1]);
    }
}