import java.io.*;
import java.util.*;

class GearBox15 {
    int gear;
    int numGears;

    // EXPLICACIÓN DE gearUp:
    // Incrementa la marcha actual en 1 siempre y cuando sea estrictamente 
    // menor que el número máximo de marchas (numGears).
    public void gearUp() {
        if (this.gear < this.numGears) {
            this.gear++;
        }
    }

    // EXPLICACIÓN DE gearDown:
    // Decrementa la marcha actual en 1 siempre y cuando sea estrictamente 
    // mayor que -1 (el límite inferior que representa la marcha atrás 'R').
    public void gearDown() {
        if (this.gear > -1) {
            this.gear--;
        }
    }

    void show(){
        System.out.print("Current gear: ");
        switch (gear){
            case -1:
                System.out.println("R");
                break;
            case 0:
                System.out.println("N");
                break;
            default:
                System.out.println(gear);
        }
    }
}

public class Solution15 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GearBox15 gearBox = new GearBox15();
        gearBox.numGears = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el salto de línea residual

        String action;
        while(!(action = scanner.nextLine()).equals("__END__")){
            switch (action){
                case "UP":
                    gearBox.gearUp();
                    break;
                case "DOWN":
                    gearBox.gearDown();
                    break;
            }
            gearBox.show();
        }
    }
}