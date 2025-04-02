import java.util.*;

class Estudiante implements Comparable<Estudiante> {
    String idEstu;
    String nombre;
    float promAcum;

    public Estudiante(String idEstu, String nombre, float promAcum) {
        this.idEstu = idEstu;
        this.nombre = nombre;
        this.promAcum = promAcum;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Float.compare(this.promAcum, otro.promAcum);
    }

    @Override
    public String toString() {
        return "[" + idEstu + ", " + nombre + ", Prom: " + promAcum + "]";
    }
}

class ComparadorPorPromedio implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return Float.compare(e1.promAcum, e2.promAcum);
    }
}

public class MainBinarySearch {
    public static void main(String[] args) {
        // Crear un arreglo de 100 estudiantes con datos aleatorios
        Estudiante[] estudiantes = generarEstudiantes(100);

        // Ordenar el arreglo por promedio acumulado
        Arrays.sort(estudiantes);

        // Mostrar los estudiantes ordenados
        System.out.println("Estudiantes ordenados por promedio acumulado:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }

        // Búsqueda binaria iterativa
        float notaBuscada = 5.0f;
        int indexIterativo = busquedaBinariaIterativa(estudiantes, notaBuscada);
        mostrarResultadoBusqueda("Iterativa", estudiantes, indexIterativo);

        // Búsqueda binaria recursiva
        int indexRecursivo = busquedaBinariaRecursiva(estudiantes, notaBuscada, 0, estudiantes.length - 1);
        mostrarResultadoBusqueda("Recursiva", estudiantes, indexRecursivo);

        // Contar estudiantes con promedio mayor a cierta nota
        float notaReferencia = 6.0f;
        int count = contarEstudiantesMayorQue(estudiantes, notaReferencia);
        System.out.println("Estudiantes con promedio mayor a " + notaReferencia + ": " + count);
    }

    private static Estudiante[] generarEstudiantes(int cantidad) {
        Estudiante[] estudiantes = new Estudiante[cantidad];
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            estudiantes[i] = new Estudiante("ID" + i, "Estudiante" + i, rand.nextFloat() * 10);
        }
        return estudiantes;
    }

    private static void mostrarResultadoBusqueda(String metodo, Estudiante[] estudiantes, int index) {
        System.out.println(metodo + ": " + (index != -1 ? estudiantes[index] : "No encontrado"));
    }

    public static int busquedaBinariaIterativa(Estudiante[] arr, float clave) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio].promAcum == clave) return medio;
            if (arr[medio].promAcum < clave) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

    public static int busquedaBinariaRecursiva(Estudiante[] arr, float clave, int inicio, int fin) {
        if (inicio > fin) return -1;
        int medio = inicio + (fin - inicio) / 2;
        if (arr[medio].promAcum == clave) return medio;
        if (arr[medio].promAcum < clave) return busquedaBinariaRecursiva(arr, clave, medio + 1, fin);
        return busquedaBinariaRecursiva(arr, clave, inicio, medio - 1);
    }

    public static int contarEstudiantesMayorQue(Estudiante[] arr, float nota) {
        return (int) Arrays.stream(arr).filter(e -> e.promAcum > nota).count();
    }
}
