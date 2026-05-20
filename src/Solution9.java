import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Led {
    boolean state;

    // EXPLICACIÓN DEL MÉTODO switchOn:
    // Este método no devuelve nada (void) y su única función es
    // cambiar el valor de la variable de estado interna a 'true' (encendido).
    public void switchOn() {
        this.state = true;
    }

    // EXPLICACIÓN DEL MÉTODO switchOff:
    // Al igual que el anterior, cambia el valor de la variable
    // de estado interna, pero en este caso a 'false' (apagado).
    public void switchOff() {
        this.state = false;
    }

    void draw(){
        if(state){
            System.out.print("(*)");
        } else {
            System.out.print("( )");
        }
    }
}

public class Solution9 { // Recuerda cambiar a 'Solution' al subir a DMOJ
    public static void main(String[] args) {
        Led l1 = new Led();
        Led l2 = new Led();

        l1.draw();
        l2.draw();
        l1.switchOn();
        System.out.println();

        l1.draw();
        l2.draw();
        l2.switchOn();
        System.out.println();

        l1.draw();
        l2.draw();
        l1.switchOff();
        System.out.println();

        l1.draw();
        l2.draw();
    }
}