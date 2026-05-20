import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class AdvancedLineSeparator12 {
    // EXPLICACIÓN DE LOS CAMPOS FALTANTES:
    // Al observar el método main, vemos que el programa intenta asignar:
    // lineSeparator.charSeparator (un carácter, tipo char)
    // lineSeparator.size (un número entero, tipo int)
    char charSeparator;
    int size;

    void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(charSeparator);
        }
        System.out.println();
    }
}

public class Solution12 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdvancedLineSeparator12 lineSeparator = new AdvancedLineSeparator12();
        String line;

        // El bucle se ejecuta de manera continua hasta que la entrada sea exactamente "__END__"
        while(!(line = scanner.nextLine()).equals("__END__")) {
            lineSeparator.charSeparator = line.charAt(0);
            lineSeparator.size = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el salto de línea residual que deja .nextInt()

            System.out.format("Aqui sota apareix una linea de %s %s%n", lineSeparator.size, lineSeparator.charSeparator);

            // EXPLICACIÓN DEL LLAMADO:
            // Invocamos el método print() del objeto para que dibuje la línea personalizada en la consola.
            lineSeparator.print();
        }
    }
}