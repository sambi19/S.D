import java.util.Arrays;

class Persona implements Comparable<Persona> {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otra) {
        return this.edad - otra.edad;
    }

    @Override
    public String toString() {
        return nombre + "," + edad ;
    }
}

public class Burbuja {
    public static void main(String[] args) {
        Persona[] personas = {
            new Persona("Ana", 25),
            new Persona("Luis", 30),
            new Persona("Carlos", 20),
            new Persona("Beatriz", 22)
        };

        burbujaSort(personas);

        System.out.println(Arrays.toString(personas));
    }

    public static void burbujaSort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
