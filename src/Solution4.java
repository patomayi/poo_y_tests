import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// escriu el codi aqui
class Alumno {
    // Atributo que almacena el array de notas con precisión decimal simple
    float[] notes;

    // Nota: Aunque el enunciado pide "Alumne", el código del main busca "Alumno".
    // Para que no falle al compilar en DMOJ, dejamos también el alias o la variable tal como la pide el main:
    float[] notas;
}

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Se crea la instancia de la clase Alumno
        Alumno alumno = new Alumno();
        int numeroNotas = scanner.nextInt();

        // Se inicializa el array dentro del objeto
        alumno.notas = new float[numeroNotas];
        for(int i=0; i<numeroNotas; i++){
            alumno.notas[i] = scanner.nextFloat();
        }

        float suma = 0;
        for(int i=0; i<numeroNotas; i++){
            suma += alumno.notas[i];
        }
        System.out.println("Nota media: " + suma/numeroNotas);
    }
}