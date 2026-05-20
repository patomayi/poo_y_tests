import java.io.*;
import java.util.*;

// Declara aqui la classe (sense cap modificador)
class Box39 {
    // ATRIBUTOS PRIMITIVOS: Dimensiones de la caja actual
    float length;
    float height;
    float width;

    // ATRIBUTO DE AUTORREFERENCIA (Recursividad estructural):
    // Una caja puede contener de manera opcional otra caja en su interior.
    Box39 innerBox;
}

public class Solution39 { // Recuerda cambiar el nombre a 'Solution' en DMOJ
    public static void main(String[] args) {
        Box39 box = new Box39();
        box.length = 10000.5f;
        box.height = 3000.5f;
        box.width = 4000.75f;

        // Primera caja interna
        box.innerBox = new Box39();
        box.innerBox.length = 1000.5f;
        box.innerBox.height = 300.5f;
        box.innerBox.width = 400.75f;

        // Segunda caja interna (anidamiento de nivel 2)
        box.innerBox.innerBox = new Box39();
        box.innerBox.innerBox.length = 100.5f;
        box.innerBox.innerBox.height = 30.5f;
        box.innerBox.innerBox.width = 40.75f;

        // Tercera caja interna (anidamiento de nivel 3)
        box.innerBox.innerBox.innerBox = new Box39();
        box.innerBox.innerBox.innerBox.length = 10.5f;
        box.innerBox.innerBox.innerBox.height = 3.5f;
        box.innerBox.innerBox.innerBox.width = 4.75f;

        // Imprime el ancho de la caja más profunda
        System.out.println(box.innerBox.innerBox.innerBox.width);
    }
}