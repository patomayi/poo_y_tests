import java.io.*;
import java.util.*;

class Clock20 {
    int hours;
    int minutes;
    int seconds;

    // EXPLICACIÓ DEL MÈTODE tick:
    // Augmenta en un segon. Si els segons arriben a 60, es reinicien i sumen un minut.
    // El mateix passa amb els minuts cap a les hores.
    public void tick() {
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
            if (this.minutes == 60) {
                this.minutes = 0;
                this.hours++;
            }
        }
    }

    // EXPLICACIÓ DEL MÈTODE reset:
    // Torna a posar a zero tots els camps del rellotge.
    public void reset() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // EXPLICACIÓ DEL MÈTODE getTime:
    // Retorna una cadena de text formatada. El patró '%02d' indica que el número
    // tindrà un ample de 2 dígits i s'omplirà amb un zero a l'esquerra si és necessari.
    public String getTime() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
}

public class Solution20 { // Recorda canviar el nom a 'Solution' quan ho pugis a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clock20 clock = new Clock20();
        int t;

        // Bucle de lectura continu fins que es detecti un -1
        while((t = scanner.nextInt()) != -1){
            if(t == 0) {
                clock.reset();
            } else {
                for (int i = 0; i < t; i++) {
                    clock.tick();
                }
            }
            System.out.println(clock.getTime());
        }
    }
}