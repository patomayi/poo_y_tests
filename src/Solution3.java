import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class FunctionGame {
    // 1. Suma 1 al parámetro
    public int function1(int n) {
        return n + 1;
    }

    // 2. Resta 3 al parámetro
    public int function2(int n) {
        return n - 3;
    }

    // 3. Multiplica por 10
    public int function3(int n) {
        return n * 10;
    }

    // 4. Multiplica por 2 y resta 1
    public int function4(int n) {
        return (n * 2) - 1;
    }

    // 5. Siempre devuelve 6
    public int function5(int n) {
        return 6;
    }

    // 6. Suma ambos parámetros
    public int function6(int a, int b) {
        return a + b;
    }

    // 7. Devuelve el máximo entre dos números
    public int function7(int a, int b) {
        return Math.max(a, b);
    }

    // 8. Devuelve el mínimo entre tres números
    public int function8(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FunctionGame functionGame = new FunctionGame();
        String functionName = scanner.next();

        if("function1".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param = scanner.nextInt();
                int returnValue = functionGame.function1(param);
                System.out.println(param + " -> " + returnValue);
            }
        } else if("function2".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param = scanner.nextInt();
                int returnValue = functionGame.function2(param);
                System.out.println(param + " -> " + returnValue);
            }
        } else if("function3".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param = scanner.nextInt();
                int returnValue = functionGame.function3(param);
                System.out.println(param + " -> " + returnValue);
            }
        } else if("function4".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param = scanner.nextInt();
                int returnValue = functionGame.function4(param);
                System.out.println(param + " -> " + returnValue);
            }
        } else if("function5".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param = scanner.nextInt();
                int returnValue = functionGame.function5(param);
                System.out.println(param + " -> " + returnValue);
            }
        }  else if("function6".equals(functionName)){
            for (int i = 5; i-->0;) {
                int param1 = scanner.nextInt();
                int param2 = scanner.nextInt();
                int returnValue = functionGame.function6(param1, param2);
                System.out.println(param1 + "," + param2 + " -> " + returnValue);
            }
        } else if("function7".equals(functionName)){
            for (int i = 7; i-->0;) {
                int param1 = scanner.nextInt();
                int param2 = scanner.nextInt();
                int returnValue = functionGame.function7(param1, param2);
                System.out.println(param1 + "," + param2 + " -> " + returnValue);
            }
        } else if("function8".equals(functionName)){
            for (int i = 7; i-->0;) {
                int param1 = scanner.nextInt();
                int param2 = scanner.nextInt();
                int param3 = scanner.nextInt();
                int returnValue = functionGame.function8(param1, param2, param3);
                System.out.println(param1 + "," + param2 + "," + param3 + " -> " + returnValue);
            }
        }
    }
}