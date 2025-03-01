import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}

public class ProductoSorter {
    public static void main(String[] args) {
        // Usando arreglos estáticos
        Producto[] productosArray = {
            new Producto("001", "Producto A", 10.5, 100),
            new Producto("002", "Producto B", 20.0, 50),
            new Producto("003", "Producto C", 15.0, 75)
        };

        // Convertir a ArrayList
        List<Producto> productos = new ArrayList<>();
        Collections.addAll(productos, productosArray);

        // Ordenar por precio usando Bubble Sort
        bubbleSort(productos, Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Ordenado por precio:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Ordenar por cantidad usando Bubble Sort
        bubbleSort(productos, Comparator.comparingInt(Producto::getCantidad));
        System.out.println("Ordenado por cantidad:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Agregar más productos al arreglo
        productosArray = new Producto[]{
            new Producto("001", "Producto A", 10.5, 100),
            new Producto("002", "Producto B", 20.0, 50),
            new Producto("003", "Producto C", 15.0, 75),
            new Producto("004", "Producto D", 5.0, 200),
            new Producto("005", "Producto E", 25.0, 30),
            new Producto("006", "Producto F", 12.0, 60),
            new Producto("007", "Producto G", 8.0, 150),
            new Producto("008", "Producto H", 18.0, 80),
            new Producto("009", "Producto I", 22.0, 40),
            new Producto("010", "Producto J", 30.0, 20)
        };

        // Convertir a ArrayList nuevamente
        productos = new ArrayList<>();
        Collections.addAll(productos, productosArray);

        // Ordenar por precio usando Bubble Sort
        bubbleSort(productos, Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Ordenado por precio:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Ordenar por cantidad usando Bubble Sort
        bubbleSort(productos, Comparator.comparingInt(Producto::getCantidad));
        System.out.println("Ordenado por cantidad:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Agregar más productos al arreglo con nombres de productos de supermercado
        productosArray = new Producto[]{
            new Producto("001", "Leche", 1.5, 100),
            new Producto("002", "Pan", 0.8, 50),
            new Producto("003", "Huevos", 2.5, 75),
            new Producto("004", "Queso", 3.0, 200),
            new Producto("005", "Mantequilla", 2.0, 30),
            new Producto("006", "Yogur", 1.2, 60),
            new Producto("007", "Cereal", 4.0, 150),
            new Producto("008", "Jugo de Naranja", 3.5, 80),
            new Producto("009", "Café", 5.0, 40),
            new Producto("010", "Té", 2.5, 20)
        };

        // Convertir a ArrayList nuevamente
        productos = new ArrayList<>();
        Collections.addAll(productos, productosArray);

        // Ordenar por precio usando Bubble Sort
        bubbleSort(productos, Comparator.comparingDouble(Producto::getPrecio));
        System.out.println("Ordenado por precio:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Ordenar por cantidad usando Bubble Sort
        bubbleSort(productos, Comparator.comparingInt(Producto::getCantidad));
        System.out.println("Ordenado por cantidad:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Buscar producto por código
        String codigoBuscado = "003";
        Producto productoEncontrado = buscarProductoPorCodigo(productos, codigoBuscado);
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("Producto con código " + codigoBuscado + " no encontrado.");
        }
    }

    public static <T> void bubbleSort(List<T> list, Comparator<? super T> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Swap list[j] and list[j+1]
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static Producto buscarProductoPorCodigo(List<Producto> productos, String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }
}
