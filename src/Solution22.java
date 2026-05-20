import java.io.*;
import java.util.*;

// EXPLICACIÓN DE LA CLASE PLAYER:
// Contiene un campo entero para almacenar la puntuación y un constructor 
// que inicializa este valor (en este caso, empieza en 0).
class Player22 {
    int points;

    public Player22(int points) {
        this.points = points;
    }
}

// EXPLICACIÓN DE LA CLASE GAME:
// Contiene dos atributos de tipo Player22 y un constructor que los recibe
// y los asigna para que el método main pueda acceder a ellos.
class Game22 {
    Player22 player1;
    Player22 player2;

    public Game22(Player22 p1, Player22 p2) {
        this.player1 = p1;
        this.player2 = p2;
    }
}

public class Solution22 { // Recuerda cambiar el nombre a 'Main' o 'Solution' en DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        // Instanciamos el juego pasándole los dos jugadores creados en el momento
        Game22 game = new Game22(new Player22(0), new Player22(0));
        int numRondas = scanner.nextInt();

        for (int i = 0; i < numRondas; i++) {
            String ronda = scanner.next();
            // Lógica interna del main para evaluar combinaciones de jugadas
            if(ronda.equals("@%") || ronda.equals("#@") || ronda.equals("%#")){
                game.player1.points++;
            } else if(ronda.equals("%@") || ronda.equals("@#") || ronda.equals("#%")){
                game.player2.points++;
            }
        }

        // Determinación del ganador basándose en los puntos acumulados en los objetos
        if(game.player1.points > game.player2.points){
            System.out.println("PLAYER 1 WINS");
        } else if(game.player2.points > game.player1.points){
            System.out.println("PLAYER 2 WINS");
        } else {
            System.out.println("TIE");
        }
    }
}