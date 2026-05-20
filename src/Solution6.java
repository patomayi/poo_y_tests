import java.util.*;

// EXPLICACIÓN DEL CONFLICTO:
// Renombramos las clases añadiendo un '6' (Author6, Post6, Stream6).
// De esta forma, IntelliJ no se confunde con la clase 'Post' que creaste en Solution2.
// Cada ejercicio funcionará de manera 100% aislada en tu proyecto.

class Author6 {
    String name;
    String photoURL;
}

class Post6 {
    Author6 author; // Este atributo requiere que exista un objeto Author6 en memoria
    String content;
}

class Stream6 {
    Post6[] posts; // Array que contendrá las referencias a los objetos Post6
}

public class Solution6 { // Al subir a DMOJ, recuerda cambiar a 'public class Solution'
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nPosts = scanner.nextInt();

        // 1. Instanciamos el contenedor principal (Stream6)
        Stream6 stream = new Stream6();

        // 2. Inicializamos el array de posts con el tamaño indicado.
        // CUIDADO: En este punto, todas las posiciones del array contienen 'null'.
        stream.posts = new Post6[nPosts];

        for (int i = 0; i < nPosts; i++) {
            // 3. SOLUCIÓN AL NULLPOINTEREXCEPTION:
            // Instanciamos un objeto Post6 vacío en la posición actual del array.
            stream.posts[i] = new Post6();

            // 4. Instanciamos el objeto Author6 dentro de ese Post6.
            // Si omitimos este paso, al intentar asignar el nombre fallaría porque '.author' sería null.
            stream.posts[i].author = new Author6();

            // 5. ASIGNACIÓN DE DATOS RECOLECTADOS POR EL SCANNER:
            // Ahora que los objetos físicos existen en la memoria ram, guardamos los valores de forma segura.
            stream.posts[i].author.name = scanner.next();      // Lee el nombre del usuario (ej: @popeye)
            stream.posts[i].author.photoURL = scanner.next();  // Lee la URL de la imagen

            // Para evitar conflictos con el salto de línea residual que suele dejar '.nextInt()',
            // usamos '.nextLine().trim()' que captura de golpe todi el texto restante de la línea
            // y elimina los espacios en blanco innecesarios al principio y al final.
            stream.posts[i].content = scanner.nextLine().trim();
        }

        // 6. IMPRESIÓN POR CONSOLA:
        // Recorremos el array ya completado para imprimir los datos con el formato que exige el ejercicio.
        for (int i = 0; i < nPosts; i++) {
            System.out.println(stream.posts[i].author.name);
            System.out.println(stream.posts[i].content);
            System.out.println("------------------------------");
        }
    }
}