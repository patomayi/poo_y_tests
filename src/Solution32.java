import java.util.Scanner;

class Producte32 {
    String nom;
    String descripcio;
    float preu;
    int stock;
}

public class Solution32 { // Recuerda cambiar el nombre a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producte32 producte = new Producte32();

        // EXPLICACIÓN DE LA LECTURA:
        // Leemos secuencialmente los datos de la entrada respetando los tipos de datos.
        if (scanner.hasNextLine()) producte.nom = scanner.nextLine();
        if (scanner.hasNextLine()) producte.descripcio = scanner.nextLine();
        if (scanner.hasNextFloat()) producte.preu = scanner.nextFloat();
        if (scanner.hasNextInt()) producte.stock = scanner.nextInt();

        // Estructura de salida formateada por defecto en el ejercicio
        System.out.println("Nom:        " + producte.nom);
        System.out.println("Descripcio: " + producte.descripcio);
        System.out.println("Preu:       " + producte.preu);
        System.out.println("Stock:      " + producte.stock);
    }
}