import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para representar un estudiante
class Estudiante {
    private String nombre;
    private String id;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}

// Clase para representar un curso
class Curso {
    private String nombre;
    private String codigo;
    private int cupoMaximo;
    private List<Estudiante> estudiantesMatriculados;

    public Curso(String nombre, String codigo, int cupoMaximo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cupoMaximo = cupoMaximo;
        this.estudiantesMatriculados = new ArrayList<>();
    }

    public boolean matricularEstudiante(Estudiante estudiante) {
        if (estudiantesMatriculados.size() < cupoMaximo) {
            estudiantesMatriculados.add(estudiante);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
}

// Clase principal para manejar la matrícula
public class SistemaMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de cursos
        Curso curso1 = new Curso("Programación en Java", "CS101", 2);
        Curso curso2 = new Curso("Bases de Datos", "CS102", 3);

        // Lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan Pérez", "1001"));
        estudiantes.add(new Estudiante("María López", "1002"));
        estudiantes.add(new Estudiante("Carlos Gómez", "1003"));

        // Proceso de matrícula
        for (Estudiante est : estudiantes) {
            System.out.println("Matriculando a " + est.getNombre());
            boolean matriculado = curso1.matricularEstudiante(est);
            if (matriculado) {
                System.out.println("Matrícula en " + curso1.getNombre() + " exitosa.");
            } else {
                System.out.println("Cupo lleno en " + curso1.getNombre() + ". Matriculando en " + curso2.getNombre());
                if (curso2.matricularEstudiante(est)) {
                    System.out.println("Matrícula en " + curso2.getNombre() + " exitosa.");
                } else {
                    System.out.println("Cupo lleno en ambos cursos. No se pudo matricular.");
                }
            }
        }

        scanner.close();
    }
}
