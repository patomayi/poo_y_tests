import java.io.*;
import java.util.*;

// EXPLICACIÓN DE LA CLASE PRODUCT:
// Define un artículo individual con su nombre y su precio decimal.
class Product30 {
    String name;
    float price;
}

// EXPLICACIÓN DE LA CLASE SHOPPINGCART:
// Modela el contenedor que almacena la colección o array de productos.
class ShoppingCart30 {
    Product30[] products;
}

public class Solution30 { // Recuerda renombrar a 'Solution' al subirlo a DMOJ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart30 shoppingCart = new ShoppingCart30();
        int nProducts = scanner.nextInt();
        scanner.nextLine(); // Limpiamos el salto de línea que deja nextInt()

        shoppingCart.products = new Product30[nProducts];
        for (int i = 0; i < nProducts; i++) {
            shoppingCart.products[i] = new Product30();
            shoppingCart.products[i].name = scanner.nextLine();
            shoppingCart.products[i].price = scanner.nextFloat();
            scanner.nextLine(); // Limpiamos el salto de línea tras leer el float
        }

        System.out.println("ShoppingCart");
        for (int i = 0; i < nProducts; i++) {
            System.out.format("%40s  %6.2f%n", shoppingCart.products[i].name, shoppingCart.products[i].price);
        }
    }
}