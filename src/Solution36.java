import java.io.*;
import java.util.*;

class Casella36 {
    char lletra;

    // EXPLICACIÓN: Asigna el carácter directamente a la variable de instancia.
    Casella36(char lletra){
        this.lletra = lletra;
    }
}

class Columna36 {
    Casella36 casella;

    // EXPLICACIÓN: Una columna contiene una casilla, por lo que instanciamos 
    // el objeto Casella pasando el carácter recibido.
    Columna36(char lletra){
        this.casella = new Casella36(lletra);
    }
}

class Fila36 {
    Columna36[] columnes;

    // EXPLICACIÓN: Una fila contiene un array de columnas. Inicializamos el array 
    // con el tamaño 'nColumnes' y rellenamos cada posición creando una nueva Columna.
    Fila36(int nColumnes, char lletra){
        this.columnes = new Columna36[nColumnes];
        for (int i = 0; i < nColumnes; i++) {
            this.columnes[i] = new Columna36(lletra);
        }
    }
}

class Taula36 {
    Fila36[] files;

    // EXPLICACIÓN: La tabla es la raíz. Inicializa el array de filas con 'nFiles' 
    // y utiliza un bucle para instanciar cada Fila pasándole el número de columnas y el carácter.
    Taula36(int nFiles, int nColumnes, char lletra){
        this.files = new Fila36[nFiles];
        for (int i = 0; i < nFiles; i++) {
            this.files[i] = new Fila36(nColumnes, lletra);
        }
    }
}

public class Solution36 { // Recuerda cambiar a 'Solution' en DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            Taula36 taula = new Taula36(scanner.nextInt(), scanner.nextInt(), scanner.next().charAt(0));

            // Impresión por pantalla de la tabla generada en memoria
            for (int i = 0; i < taula.files.length; i++) {
                for (int j = 0; j < taula.files[i].columnes.length; j++) {
                    System.out.print(taula.files[i].columnes[j].casella.lletra);
                }
                System.out.println();
            }
        }
    }
}