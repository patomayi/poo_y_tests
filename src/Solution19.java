import java.io.*;
import java.util.*;

class URL19 {
    String protocol;
    String domain;
    String path;
    String query;
    String fragment;

    // EXPLICACIÓN DEL MÉTODO toString():
    // Concatenamos las propiedades del objeto insertando los caracteres obligatorios
    // del estándar URI: '://' tras el protocolo, '?' antes de la query y '#' antes del fragmento.
    @Override
    public String toString() {
        return protocol + "://" + domain + path + "?" + query + "#" + fragment;
    }
}

public class Solution19 { // Recuerda renombrar a 'E11' o 'Solution' según te pida DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        URL19 url = new URL19();

        // EXPLICACIÓN DE LA LECTURA:
        // Asignamos secuencialmente las 5 líneas del Input Format a los campos del objeto.
        if (scanner.hasNextLine()) url.protocol = scanner.nextLine();
        if (scanner.hasNextLine()) url.domain = scanner.nextLine();
        if (scanner.hasNextLine()) url.path = scanner.nextLine();
        if (scanner.hasNextLine()) url.query = scanner.nextLine();
        if (scanner.hasNextLine()) url.fragment = scanner.nextLine();

        // Al imprimir el objeto, se invoca automáticamente el método toString() que creamos arriba.
        System.out.println(url);
    }
}