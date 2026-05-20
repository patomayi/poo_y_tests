import java.util.Scanner;

class Song33 {
    String name;
    String artist;
    float rating;
    boolean favorite;
}

public class Solution33 { // Recuerda cambiar el nombre a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // EXPLICACIÓN DE LA INSTANCIACIÓN:
        // El main del enunciado utiliza la variable 'song' directamente, 
        // por lo que primero debemos crear el objeto en memoria.
        Song33 song = new Song33();

        // EXPLICACIÓN DE LA LECTURA:
        // Asignamos secuencialmente cada línea de la entrada a su propiedad correspondiente.
        if (scanner.hasNextLine()) song.name = scanner.nextLine();
        if (scanner.hasNextLine()) song.artist = scanner.nextLine();
        if (scanner.hasNextFloat()) song.rating = scanner.nextFloat();
        if (scanner.hasNextBoolean()) song.favorite = scanner.nextBoolean();

        // Bloque de salida por consola estándar del ejercicio
        System.out.print(song.favorite ? "<3 " : "   ");
        System.out.println(song.artist + " - " + song.name);
        for (int i = 0; i < (int) song.rating; i++) {
            System.out.print("*");
        }
    }
}