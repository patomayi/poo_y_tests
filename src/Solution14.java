import java.util.Scanner;

// escriu aqui el codi
class Equation14 {
    // Atributos de tipo flotante para coeficientes e incógnita
    float a;
    float b;
    float x;

    // EXPLICACIÓN DEL MÉTODO calculateSolution:
    // Despejamos la ecuación lineal standard (a * x + b = 0).
    // Pasamos 'b' restando al otro lado y luego dividimos por 'a'.
    public void calculateSolution() {
        this.x = -this.b / this.a;
    }
}

public class Solution14 { // Recuerda cambiar a 'Solution' al subir a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Equation14 equation = new Equation14();

        // Lee coeficientes de forma continua hasta que 'a' sea igual a 0
        while((equation.a = scanner.nextFloat()) != 0) {
            equation.b = scanner.nextFloat();
            equation.calculateSolution();
            System.out.format("%.2f * %.2f + %.2f = 0%n", equation.a, equation.x, equation.b);
        }
    }
}