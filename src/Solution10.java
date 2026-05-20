import java.io.*;
import java.util.*;

class OLed10 {
    boolean state;

    void switchOn(){
        state = true;
    }

    void switchOff(){
        state = false;
    }

    void draw(){
        if(state){
            System.out.print("(*)");
        } else {
            System.out.print("( )");
        }
    }
}

class LedArray10 {
    OLed10[] leds;

    LedArray10(int size){
        leds = new OLed10[size];
        for (int i = 0; i < size; i++) {
            leds[i] = new OLed10();
        }
    }

    // EXPLICACIÓN DEL MÉTODO switchLed:
    // 1. Accedemos al LED específico usando el índice 'position' que nos pasan por parámetro.
    // 2. Evaluamos su estado actual ('leds[position].state').
    // 3. Invertimos el estado utilizando sus propios métodos switchOff() o switchOn().
    public void switchLed(int position) {
        if (leds[position].state) {
            leds[position].switchOff(); // Si estaba encendido (true), lo apagamos
        } else {
            leds[position].switchOn();  // Si estaba apagado (false), lo encendemos
        }
    }

    void draw(){
        for(OLed10 led : leds){
            led.draw();
        }
    }
}

public class Solution10 { // Recuerda cambiar a 'Solution' al subir a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Inicializa un conjunto de 5 leds
        LedArray10 ledArray = new LedArray10(5);
        int position;

        // Lee números de forma continua hasta que el usuario introduzca un -1
        while((position = scanner.nextInt()) != -1){
            ledArray.switchLed(position);
            ledArray.draw();
            System.out.println();
        }
    }
}