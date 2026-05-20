import java.io.*;
import java.util.*;

class Coords35 {
    int x, y;
}

class Player35 {
    String name;
    Coords35 position;
    int score;
}

class Game35 {
    int width;
    int height;
    Player35 player1;
    Player35 player2;
}

public class Solution35 { // Recuerda cambiar el nombre a 'Main' o 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        // EXPLICACIÓN DEL CÓDIGO A ESCRIBIR:
        // Inicializamos secuencialmente el juego y cada uno de sus sub-objetos
        // anidados para evitar errores de puntero nulo (NullPointerException).
        Game35 game = new Game35();

        game.player1 = new Player35();
        game.player1.position = new Coords35();

        game.player2 = new Player35();
        game.player2.position = new Coords35();

        // Lectura secuencial de las dimensiones del mapa y los atributos de los jugadores
        if (scanner.hasNextInt()) {
            game.width = scanner.nextInt();
            game.height = scanner.nextInt();

            game.player1.name = scanner.next();
            game.player1.score = scanner.nextInt();
            game.player1.position.x = scanner.nextInt();
            game.player1.position.y = scanner.nextInt();

            game.player2.name = scanner.next();
            game.player2.score = scanner.nextInt();
            game.player2.position.x = scanner.nextInt();
            game.player2.position.y = scanner.nextInt();
        }

        // Bloque de salida por pantalla estándar provisto por el ejercicio
        System.out.println("P1:" + game.player1.name + " #" + game.player1.score + " {"+game.player1.position.x+", "+game.player1.position.y+"}");
        System.out.println("P2:" + game.player2.name + " #" + game.player2.score + " {"+game.player2.position.x+", "+game.player2.position.y+"}");
    }
}