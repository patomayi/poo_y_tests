import java.util.Scanner;

class Direccion21 {
    String calle;
    String codPostal;
    String ciudad;
    String provincia;
}

class Contacto21 {
    String nombre;
    String apellidos;
    Direccion21 direccion;
}

public class Solution21 { // Recuerda cambiar a 'Solution' al subir a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacto21 contacto = new Contacto21();
        contacto.direccion = new Direccion21();

        // EXPLICACIÓN DE LA LECTURA:
        // Como la entrada viene con espacios y saltos de línea, usamos scanner.nextLine()
        // para absorber toda la línea completa y asignarla secuencialmente.
        if (scanner.hasNextLine()) contacto.nombre = scanner.nextLine();
        if (scanner.hasNextLine()) contacto.apellidos = scanner.nextLine();
        if (scanner.hasNextLine()) contacto.direccion.calle = scanner.nextLine();
        if (scanner.hasNextLine()) contacto.direccion.codPostal = scanner.nextLine();
        if (scanner.hasNextLine()) contacto.direccion.ciudad = scanner.nextLine();
        if (scanner.hasNextLine()) contacto.direccion.provincia = scanner.nextLine();

        // Impresión oficial requerida por el problema
        System.out.println(contacto.apellidos + ", " + contacto.nombre);
        System.out.println(contacto.direccion.calle);
        System.out.println(contacto.direccion.codPostal + " - " + contacto.direccion.ciudad);
        System.out.println(contacto.direccion.provincia);
    }
}