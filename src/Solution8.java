import java.io.*;
import java.util.*;

// Declara aqui la classe (sense cap modificador)
// EXPLICACIÓN DE LA CLASE:
// Al no llevar modificadores como 'public' o 'private', la clase tiene visibilidad de paquete (package-private).
// Definimos los tres campos exactamente con los nombres y tipos de datos que utiliza el método main.
class Book {
    String title;
    int yearOfPublishing;
    boolean isAvailable;
}

public class Solution8 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Through the looking glass";
        book.yearOfPublishing = 1871;
        book.isAvailable = true;

        System.out.println(book.title);
        System.out.println(book.yearOfPublishing);
        System.out.println(book.isAvailable);
    }
}