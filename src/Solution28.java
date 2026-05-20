import java.io.*;
import java.util.*;

// EXPLICACIÓN DE LA CLASE STAT:
// Representa una característica del personaje que posee un valor actual y un límite máximo.
class Stat28 {
    int value;
    int max;

    public Stat28(int value, int max) {
        this.value = value;
        this.max = max;
    }
}

// EXPLICACIÓN DE LA CLASE ENEMY:
// Modela al enemigo inicializando sus estadísticas compuestas según su rol.
class Enemy28 {
    Stat28 health;
    Stat28 weapon;

    public Enemy28(String type) {
        // Evaluamos el tipo de enemigo ignorando mayúsculas/minúsculas por seguridad
        if (type.equalsIgnoreCase("guerrero")) {
            this.health = new Stat28(50, 50);
            this.weapon = new Stat28(60, 60);
        } else if (type.equalsIgnoreCase("amazona")) {
            this.health = new Stat28(40, 40);
            this.weapon = new Stat28(70, 70);
        } else if (type.equalsIgnoreCase("brujo")) {
            this.health = new Stat28(30, 30);
            this.weapon = new Stat28(80, 80);
        }
    }
}

public class Solution28 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Enemy28 guerrero = new Enemy28("guerrero");
        Enemy28 amazona = new Enemy28("amazona");
        Enemy28 brujo = new Enemy28("brujo");

        System.out.println("GUERRERO  " +
                "Health: " + guerrero.health.value + "/" + guerrero.health.max + "   " +
                "Weapon: " + guerrero.weapon.value + "/" + guerrero.weapon.max);
        System.out.println("AMAZONA   " +
                "Health: " + amazona.health.value + "/" + amazona.health.max + "   " +
                "Weapon: " + amazona.weapon.value + "/" + amazona.weapon.max);
        System.out.println("BRUJO     " +
                "Health: " + brujo.health.value + "/" + brujo.health.max + "   " +
                "Weapon: " + brujo.weapon.value + "/" + brujo.weapon.max);
    }
}