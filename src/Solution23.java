import java.util.Scanner;

// escriu aqui el codi
class CreditCard23 {
    // EXPLICACIÓN DE LOS CAMPOS:
    // Definimos los campos exactamente con los nombres y tipos de datos
    // requeridos por las instrucciones de lectura del método main.
    String holderName;
    long cardNumber;
    float accountBalance;
    float spendingLimit;
}

public class Solution23 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditCard23 creditCard = new CreditCard23();

        // Carga secuencial de datos desde el flujo de entrada
        creditCard.holderName = scanner.nextLine();
        creditCard.cardNumber = scanner.nextLong();
        creditCard.accountBalance = scanner.nextFloat();
        creditCard.spendingLimit = scanner.nextFloat();

        // Bloque de salida con formatos específicos (Mayúsculas y separación de bloques de tarjeta)
        System.out.println(creditCard.holderName.toUpperCase());
        System.out.println(String.valueOf(creditCard.cardNumber).replaceAll(".{4}","$0 "));
        System.out.println("Saldo: " + creditCard.accountBalance);
        System.out.println("Limit: " + creditCard.spendingLimit);
    }
}