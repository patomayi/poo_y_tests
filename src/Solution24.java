import java.util.Scanner;

// escriu el codi aqui
class Autor24 {
    String nombre;
    float rating;
}

class Libro24 {
    String titulo;
    String ISBN;
    float rating;
    Autor24 autor; // Relación de composición: un Libro tiene un Autor
}

public class Solution24 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Libro24 libro = new Libro24();
        libro.autor = new Autor24();

        // Lectura de los datos del libro
        libro.titulo = scanner.nextLine();
        libro.ISBN = scanner.nextLine();
        libro.rating = scanner.nextFloat();
        scanner.nextLine(); // Limpiamos el residuo del salto de línea que deja nextFloat()

        // Lectura de los datos del autor
        libro.autor.nombre = scanner.nextLine();
        libro.autor.rating = scanner.nextFloat();

        // Bloque de salida por consola estándar
        System.out.println(libro.ISBN);
        System.out.println(libro.titulo);
        System.out.println(new String(new char[(int)libro.rating]).replace("\0","*"));
        System.out.println(libro.autor.nombre);
        System.out.println(new String(new char[(int)libro.autor.rating]).replace("\0","*"));
    }
}