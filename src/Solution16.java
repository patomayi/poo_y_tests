import java.io.*;
import java.util.*;

class Grade16 {
    String name;
    float grade;
    float weight;

    Grade16(String n, float g, float w) {
        name = n;
        grade = g;
        weight = w;
    }
}

class ReportCard16 {
    // EXPLICACIÓN DE LOS CAMPOS FALTANTES:
    // El método main accede a 'reportCard.grades[i]' y a 'reportCard.averageGrade'.
    // Declaramos el array de notas y la variable decimal para la nota final.
    Grade16[] grades;
    float averageGrade;

    ReportCard16(int numGrades){
        grades = new Grade16[numGrades];
    }

    // EXPLICACIÓN DEL MÉTODO calculateAverageGrade:
    // 1. Creamos un acumulador flotante ('sumaPonderada') que empieza en 0.
    // 2. Recorremos con un bucle cada nota almacenada en nuestro array 'grades'.
    // 3. Multiplicamos la nota por su peso y lo sumamos al acumulador.
    // 4. Dividimos el acumulador final entre 100 para obtener la nota real sobre 10.
    public void calculateAverageGrade() {
        float sumaPonderada = 0.0f;
        for (int i = 0; i < grades.length; i++) {
            sumaPonderada += grades[i].grade * (grades[i].weight / 100.0f);
        }
        this.averageGrade = sumaPonderada;
    }
}

public class Solution16 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ReportCard16 reportCard = new ReportCard16(n);

        for (int i = 0; i < n; i++) {
            String assignment = scanner.next();
            float grade = scanner.nextFloat();
            float weight = scanner.nextFloat();
            reportCard.grades[i] = new Grade16(assignment, grade, weight);
        }

        reportCard.calculateAverageGrade();
        System.out.format("Average Grade: %.2f%n", reportCard.averageGrade);
    }
}