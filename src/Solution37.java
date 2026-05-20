import java.io.*;
import java.util.*;

// EXPLICACIÓN DE LA CLASE GOS:
// Define el objeto perro con su comportamiento específico de ladrar.
class Gos37 {
    public void lladrar() {
        System.out.println("Guau, guau");
    }
}

// EXPLICACIÓN DE LA CLASE GAT:
// Define el objeto gato con su comportamiento específico de maullar.
class Gat37 {
    public void miolar() {
        System.out.println("Miau, miau");
    }
}

public class Solution37 { // Recuerda cambiar el nombre a 'Main' o 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Gos37 gos = new Gos37();
        Gat37 gat = new Gat37();

        // Ejecución de los métodos de comportamiento
        gos.lladrar();
        gat.miolar();
    }
}