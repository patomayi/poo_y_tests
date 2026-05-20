import java.io.*;
import java.util.*;

// Declara aqui la classe (sense cap modificador)
class CompteCorrent26 {
    // EXPLICACIÓN DE LOS CAMPOS:
    // Definimos las tres propiedades de la cuenta bancaria con los tipos
    // primitivos y de objeto solicitados de forma explícita.
    float saldo;
    String nomPropietari;
    boolean bloquejada;
}

public class Solution26 { // Recuerda cambiar el nombre a 'Main' o 'Solution' en DMOJ
    public static void main(String[] args) {
        CompteCorrent26 cc = new CompteCorrent26();

        // Asignación de los valores de prueba
        cc.saldo = 999.9f;
        cc.nomPropietari = "Jeff Bezos";
        cc.bloquejada = false;

        // Salida por pantalla de las propiedades del objeto
        System.out.println(cc.saldo);
        System.out.println(cc.nomPropietari);
        System.out.println(cc.bloquejada);
    }
}