import java.util.Locale;
import java.util.Scanner;

// Declara aqui la classe (sense cap modificador)
class Persona38 {
    // ATRIBUTO: Almacena el nombre de la persona
    String nom;

    // MÉTODO: Imprime el saludo utilizando el atributo de la instancia
    public void saludar() {
        System.out.println("Hola, em dic " + this.nom);
    }
}

public class Solution38 { // Recuerda cambiar el nombre a 'Main' o 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        Persona38 unaPersona = new Persona38();
        if (scanner.hasNext()) {
            unaPersona.nom = scanner.next();
            unaPersona.saludar();
        }

        Persona38 unaAltraPersona = new Persona38();
        if (scanner.hasNext()) {
            unaAltraPersona.nom = scanner.next();
            unaAltraPersona.saludar();
        }
    }
}