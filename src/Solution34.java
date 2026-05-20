import java.io.*;
import java.util.*;

// EXPLICACIÓN DE LA CLASE AHORCADO:
// Diseñamos el estado interno del juego para que el método 'main' pueda mutar
// e inspeccionar sus propiedades directamente a lo largo de la partida.
class Ahorcado34 {
    String palabra;
    int fallos;
    boolean completado;
    char[] descubierta;

    // El constructor prepara el escenario inicial del juego
    public Ahorcado34(String palabra) {
        this.palabra = palabra;
        this.fallos = 0;
        this.completado = false;

        // Inicializamos el array con el tamaño de la palabra
        this.descubierta = new char[palabra.length()];

        // Llenamos el progreso inicial con guiones bajos '_'
        for (int i = 0; i < descubierta.length; i++) {
            this.descubierta[i] = '_';
        }
    }
}

public class Solution34 { // Recuerda renombrar a 'Main' o 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        // Instanciamos el juego leyendo la primera palabra secreta
        Ahorcado34 ahorcado = new Ahorcado34(scanner.next());

        // Bucle principal provisto por el ejercicio
        while(ahorcado.fallos < 6 && !ahorcado.completado){
            for (int i = 0; i < ahorcado.descubierta.length; i++) {
                System.out.print(" " + ahorcado.descubierta[i] + " ");
            }
            System.out.println();

            if (!scanner.hasNext()) break; // Control de seguridad por si se acaba el input
            char letra = scanner.next().charAt(0);
            ahorcado.completado = true;
            boolean estaLaLetra = false;

            for (int i = 0; i < ahorcado.palabra.length(); i++) {
                if(ahorcado.palabra.charAt(i) == letra){
                    ahorcado.descubierta[i] = letra;
                    estaLaLetra = true;
                }
                if(ahorcado.descubierta[i] == '_'){
                    ahorcado.completado = false;
                }
            }

            if(!estaLaLetra){
                ahorcado.fallos++;
            }

            // Dibujado de la horca según el estado de fallos acumulado
            if(ahorcado.fallos == 5)      System.out.println("\n  __    \n |  |   \n |  0   \n | /|\\ \n | /    \n |____    \n");
            else if(ahorcado.fallos == 4) System.out.println("\n  __    \n |  |   \n |  0   \n | /|\\ \n |      \n |____    \n");
            else if(ahorcado.fallos == 3) System.out.println("\n  __    \n |  |   \n |  0   \n | /|   \n |      \n |____    \n");
            else if(ahorcado.fallos == 2) System.out.println("\n  __    \n |  |   \n |  0   \n | /    \n |      \n |____    \n");
            else if(ahorcado.fallos == 1) System.out.println("\n  __    \n |  |   \n |  0   \n |      \n |      \n |____    \n");
            else if(ahorcado.fallos == 0) System.out.println("\n  __    \n |  |   \n |      \n |      \n |      \n |____    \n");
        }

        if(ahorcado.fallos == 6) System.out.println("\n  __    \n |  |   \n |  0   \n | /|\\ \n | / \\ \n |____    \n");
        else System.out.println("YOU WIN");
    }
}