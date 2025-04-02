import java.util.Arrays;
import java.util.Comparator;

class Estudiante implements Comparable<Estudiante> {
    private String idEstu;
    private String nombre;
    private float promAcum;

    public Estudiante(String idEstu, String nombre, float promAcum) {
        this.idEstu = idEstu;
        this.nombre = nombre;
        this.promAcum = promAcum;
    }

    public float getPromAcum() {
        return promAcum;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Float.compare(this.promAcum, otro.promAcum);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + idEstu + '\'' +
                ", nombre='" + nombre + '\'' +
                ", promAcum=" + promAcum +
                '}';
    }

    public static class ComparadorPorPromAcum implements Comparator<Estudiante> {
        @Override
        public int compare(Estudiante e1, Estudiante e2) {
            return Float.compare(e1.getPromAcum(), e2.getPromAcum());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[100];

        // Llenar el arreglo con estudiantes aleatorios
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Estudiante("ID" + i, "Estudiante" + i, (float) (Math.random() * 5));
        }

        // Ordenar usando Comparable
        Arrays.sort(estudiantes);
        System.out.println("Ordenados por promAcum (Comparable):");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }

        // Ordenar usando Comparator
        Arrays.sort(estudiantes, new Estudiante.ComparadorPorPromAcum());
        System.out.println("\nOrdenados por promAcum (Comparator):");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
