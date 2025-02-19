import java.util.Arrays;
import java.util.Comparator;

public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        Persona[] personas = {
            new Persona("Carlos"),
            new Persona("Ana"),
            new Persona("Beatriz"),
            new Persona("David")
        };

        Arrays.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        for (Persona persona : personas) {
            System.out.println(persona.getNombre());
        }
    }
}
