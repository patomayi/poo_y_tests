import java.io.*;
import java.util.*;

class Producto27 {
    String descripcion;
    float precio;

    Producto27(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // EXPLICACIÓN DE toString():
    // Sobrescribimos el método para que devuelva la cadena con el formato exacto
    // que requiere el enunciado, concatenando las variables de instancia.
    @Override
    public String toString() {
        return "Producto{descripcion='" + descripcion + "', precio=" + precio + "}";
    }
}

class Descuento27 {
    float valor;

    Descuento27(float valor) {
        this.valor = valor;
    }

    // EXPLICACIÓN DE aplicar():
    // Recibe la referencia del objeto Producto27. Al modificar su atributo 'precio'
    // directamente aquí, el cambio se refleja de forma automática en el main
    // porque los objetos en Java se pasan por referencia.
    public void aplicar(Producto27 p) {
        p.precio = p.precio - (p.precio * (this.valor / 100.0f));
    }
}

public class Solution27 { // Recuerda cambiar el nombre a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Producto27 producto = new Producto27(scanner.next(), scanner.nextFloat());
        System.out.println(producto);

        Descuento27 descuento = new Descuento27(scanner.nextFloat());
        descuento.aplicar(producto);
        System.out.println(producto);
    }
}