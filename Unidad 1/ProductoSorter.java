import java.util.Arrays;

class Producto {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + ": $" + precio;
    }
}

public class ProductoSorter {

    public static void bubbleSort(Producto[] productos) {
        int n = productos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos[j].precio > productos[j + 1].precio) {
                    // Swap productos[j] and productos[j+1]
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Producto[] productos) {
        int n = productos.length;
        for (int i = 1; i < n; ++i) {
            Producto key = productos[i];
            int j = i - 1;

            
            while (j >= 0 && productos[j].precio > key.precio) {
                productos[j + 1] = productos[j];
                j = j - 1;
            }
            productos[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Agua", 1.00),
            new Producto("Gaseosa", 1.50),
            new Producto("Papas", 2.00),
            new Producto("Chocolate", 1.75),
            new Producto("Galletas", 1.25)
        };

        System.out.println("Productos originales:");
        System.out.println(Arrays.toString(productos));

        // Ordenar con Bubble Sort
        bubbleSort(productos);
        System.out.println("\nProductos ordenados con Bubble Sort:");
        System.out.println(Arrays.toString(productos));

        // Reordenar para Insertion Sort
        Producto[] productos2 = {
            new Producto("Agua", 1.00),
            new Producto("Gaseosa", 1.50),
            new Producto("Papas", 2.00),
            new Producto("Chocolate", 1.75),
            new Producto("Galletas", 1.25)
        };

        // Ordenar con Insertion Sort
        insertionSort(productos2);
        System.out.println("\nProductos ordenados con Insertion Sort:");
        System.out.println(Arrays.toString(productos2));
    }
}
