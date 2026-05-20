import java.io.*;
import java.util.*;

class Personaje29 {
    int fuerza;
    int velocidad;

    Personaje29(int fuerza, int velocidad) {
        this.fuerza = fuerza;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "fuerza=" + fuerza + ", velocidad=" + velocidad;
    }
}

class Fusion29 {
    // EXPLICACIÓN DE fusionar():
    // Recibe dos objetos Personaje29, suma sus atributos internos 
    // y devuelve una nueva instancia de Personaje29 con los totales acumulados.
    public Personaje29 fusionar(Personaje29 p1, Personaje29 p2) {
        int fuerzaTotal = p1.fuerza + p2.fuerza;
        int velocidadTotal = p1.velocidad + p2.velocidad;

        return new Personaje29(fuerzaTotal, velocidadTotal);
    }
}

public class Solution29 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Personaje29 goku = new Personaje29(100, 100);
        Personaje29 vegeta = new Personaje29(90, 90);
        Personaje29 goten = new Personaje29(80, 100);
        Personaje29 trunks = new Personaje29(70, 90);

        Personaje29 gotenks = new Fusion29().fusionar(goten, trunks);
        Personaje29 gogeta = new Fusion29().fusionar(goku, vegeta);

        System.out.println("Goku: " + goku);
        System.out.println("Vegeta: " + vegeta);
        System.out.println("Goten: " + goten);
        System.out.println("Trunks: " + trunks);
        System.out.println("Gotenks: " + gotenks);
        System.out.println("Gogeta: " + gogeta);
    }
}