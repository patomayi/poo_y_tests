import java.util.Scanner;

// escriu el codi aqui
class LineSeparator11 {
    // Atributo que almacenará la longitud de la línea de guiones
    int size;

    // EXPLICACIÓN DEL MÉTODO print:
    // Usamos un bucle 'for' que se ejecuta tantas veces como indique 'size'.
    // En cada iteración imprimimos un único guion sin saltar de línea (System.out.print).
    // Al finalizar el bucle, metemos un 'System.out.println()' para hacer el salto de línea obligatorio.
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.println(); // Salto de línea final exigido por el formato de salida
    }
}

public class Solution11 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Instanciamos nuestra clase interna
        LineSeparator11 lineSeparator = new LineSeparator11();

        // Bucle continuo de lectura hasta detectar un -1
        while((lineSeparator.size = scanner.nextInt()) != -1){
            System.out.format("Aqui sota hi surt una linia de %d guions%n", lineSeparator.size);
            lineSeparator.print();
        }
    }
}