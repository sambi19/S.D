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

public class Main {
    public static void main(String[] args) {
        // (b) Crear un arreglo de 100 estudiantes
        Estudiante[] estudiantes = new Estudiante[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            estudiantes[i] = new Estudiante("ID" + i, "Estudiante" + i, rand.nextFloat() * 10);
        }
        
        // Ordenar el arreglo por promedio acumulado
        Arrays.sort(estudiantes);

        // (c) Búsqueda binaria iterativa
        float notaBuscada = 5.0f;
        int indexIterativo = busquedaBinariaIterativa(estudiantes, notaBuscada);
        System.out.println("Iterativa: " + (indexIterativo != -1 ? estudiantes[indexIterativo] : "No encontrado"));

        // (c) Búsqueda binaria recursiva
        int indexRecursivo = busquedaBinariaRecursiva(estudiantes, notaBuscada, 0, estudiantes.length - 1);
        System.out.println("Recursiva: " + (indexRecursivo != -1 ? estudiantes[indexRecursivo] : "No encontrado"));

        // (d) Contar estudiantes con promedio mayor a cierta nota
        float notaReferencia = 6.0f;
        int count = contarEstudiantesMayorQue(estudiantes, notaReferencia);
        System.out.println("Estudiantes con promedio mayor a " + notaReferencia + ": " + count);
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
        int count = 0;
        for (Estudiante e : arr) {
            if (e.promAcum > nota) count++;
        }
        return count;
    }
}
