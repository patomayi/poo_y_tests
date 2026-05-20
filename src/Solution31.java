import java.io.*;
import java.util.*;

class Fighter31 {
    String name;
    float strength;
    float speed;
    float agility;

    Fighter31(String name, float strength, float speed, float agility) {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
        this.agility = agility;
    }

    float getSum(){
        return strength + speed + agility;
    }
}

class Fight31 {
    // EXPLICACIÓN DE winner():
    // Compara la suma total de estadísticas de ambos combatientes.
    // Devuelve el objeto del luchador con mayor puntuación, o null en caso de empate absoluto.
    public Fighter31 winner(Fighter31 f1, Fighter31 f2) {
        float sumaF1 = f1.getSum();
        float sumaF2 = f2.getSum();

        if (sumaF1 > sumaF2) {
            return f1;
        } else if (sumaF2 > sumaF1) {
            return f2;
        } else {
            return null; // Provoca que el main imprima "DOUBLE KO"
        }
    }
}

public class Solution31 { // Recuerda cambiar el nombre a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fighter31 f1 = new Fighter31(scanner.next(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());
        Fighter31 f2 = new Fighter31(scanner.next(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());

        Fighter31 winner = new Fight31().winner(f1, f2);
        System.out.println(winner == null ? "DOUBLE KO" : winner.name);
    }
}