import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class FunctionGame2 {

    // EXPLICACIÓN FUNCTION 1:
    // Retorna 'true' si el residuo de dividir entre 2 es cero (número par).
    public boolean function1(int n) {
        return n % 2 == 0;
    }

    // EXPLICACIÓN FUNCTION 2:
    // Valida si el número float se encuentra en el rango de los positivos o es cero.
    public boolean function2(float n) {
        return n >= 0;
    }

    // EXPLICACIÓN FUNCTION 3:
    // Usamos un StringBuilder en un bucle para concatenar el String tantas veces como se pida.
    public String function3(int veces, String texto) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            sb.append(texto);
        }
        return sb.toString();
    }

    // EXPLICACIÓN FUNCTION 4:
    // Recorre el array acumulando el valor de cada celda en la variable 'suma'.
    public int function4(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma;
    }

    // EXPLICACIÓN FUNCTION 5:
    // Crea un nuevo array del mismo tamaño y duplica el valor de cada posición.
    public int[] function5(int[] array) {
        int[] resultado = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultado[i] = array[i] * 2;
        }
        return resultado;
    }

    // EXPLICACIÓN FUNCTION 6:
    // Inicializa un array de Strings e interpreta el booleano para rellenarlo con "cierto" o "falso".
    public String[] function6(int tamano, boolean valor) {
        String[] resultado = new String[tamano];
        String texto = valor ? "cierto" : "falso";
        Arrays.fill(resultado, texto); // Rellena todo el array de golpe de forma eficiente
        return resultado;
    }

    // EXPLICACIÓN FUNCTION 7:
    // Compara cada cadena del array usando '.equals()'. Incrementa el contador si coincide con "java".
    public int function7(String[] array) {
        int contador = 0;
        for (String palabra : array) {
            if ("java".equals(palabra)) {
                contador++;
            }
        }
        return contador;
    }

    // EXPLICACIÓN FUNCTION 8:
    // Guarda los tres parámetros en un array interno y aprovecha 'Arrays.sort()' para ordenarlos de menor a mayor.
    public int[] function8(int a, int b, int c) {
        int[] resultado = {a, b, c};
        Arrays.sort(resultado);
        return resultado;
    }
}

public class Solution7 { // Cambiar a 'Solution' al subir a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FunctionGame2 fg2 = new FunctionGame2();
        if (!scanner.hasNext()) return;
        String functionName = scanner.next();

        switch (functionName) {
            case "function1":
                for (int i = 5; i-- > 0; ) {
                    int param = scanner.nextInt();
                    boolean returnValue = fg2.function1(param);
                    System.out.println(param + " -> " + returnValue);
                }
                break;
            case "function2":
                for (int i = 6; i-- > 0; ) {
                    float param = scanner.nextFloat();
                    boolean returnValue = fg2.function2(param);
                    System.out.println(param + " -> " + returnValue);
                }
                break;
            case "function3":
                for (int i = 4; i-- > 0; ) {
                    int param1 = scanner.nextInt();
                    String param2 = scanner.next();
                    String returnValue = fg2.function3(param1, param2);
                    System.out.println(param1 + "," + param2 + " -> " + returnValue);
                }
                break;
            case "function4":
                for (int i = 4; i-- > 0; ) {
                    int size = scanner.nextInt();
                    int[] param = new int[size];
                    for (int j = 0; j < size; j++) {
                        param[j] = scanner.nextInt();
                    }
                    int returnValue = fg2.function4(param);
                    System.out.println(Arrays.toString(param) + " -> " + returnValue);
                }
                break;
            case "function5":
                for (int i = 4; i-- > 0; ) {
                    int size = scanner.nextInt();
                    int[] param = new int[size];
                    for (int j = 0; j < size; j++) {
                        param[j] = scanner.nextInt();
                    }
                    int[] returnValue = fg2.function5(param);
                    System.out.println(Arrays.toString(param) + " -> " + Arrays.toString(returnValue));
                }
                break;
            case "function6":
                for (int i = 4; i-- > 0; ) {
                    int param1 = scanner.nextInt();
                    boolean param2 = scanner.nextBoolean();
                    String[] returnValue = fg2.function6(param1, param2);
                    System.out.println(param1 + "," + param2 + " -> " + Arrays.toString(returnValue));
                }
                break;
            case "function7":
                for (int i = 5; i-- > 0; ) {
                    int size = scanner.nextInt();
                    String[] param = new String[size];
                    for (int j = 0; j < size; j++) {
                        param[j] = scanner.next();
                    }
                    int returnValue = fg2.function7(param);
                    System.out.println(Arrays.toString(param) + " -> " + returnValue);
                }
                break;
            case "function8":
                for (int i = 9; i-- > 0; ) {
                    int param1 = scanner.nextInt();
                    int param2 = scanner.nextInt();
                    int param3 = scanner.nextInt();
                    int[] returnValue = fg2.function8(param1, param2, param3);
                    System.out.println(param1 + "," + param2 + "," + param3 + " -> " + Arrays.toString(returnValue));
                }
                break;
        }
    }
}