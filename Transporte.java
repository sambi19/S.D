import java.util.Scanner;

public class Transporte {
    static char[] nodos = {'A', 'B', 'C', 'D', 'E'};
    static String[] nombres = {"Capri", "Pampalinda", "Guadalupe", "Unidad Deportiva", "Tequendama"};
    static int[][] matriz = {
            {0, 1, 1, 0, 0}, // A
            {1, 0, 0, 1, 0}, // B
            {1, 0, 0, 1, 0}, // C
            {0, 1, 1, 0, 1}, // D
            {0, 0, 0, 1, 0}  // E
    };

    
    static int buscarIndicePorNombre(String nombre) {
        for(int i=0;i<nombres.length;i++){
            if(nombres[i].equalsIgnoreCase(nombre.trim())){
                return i;
            }
        }
        return -1;
    }

    static boolean vecinos(int i, int j) {
        if(i==-1 || j==-1){
            System.out.println("No existe alguna estación");
            return false;
        }
        if(matriz[i][j]==1){
            return true;
        }
        return false;
    }

    static boolean camino(int i, int j) {
        boolean[] vis = new boolean[nombres.length];
        if(i==-1 || j==-1){
            System.out.println("No existe alguna estación");
            return false;
        }
        return dfs(i, j, vis);
    }

    static boolean dfs(int actual, int destino, boolean[] vis) {
        if(actual==destino){
            return true;
        }
        vis[actual]=true;
        for(int k=0;k<nombres.length;k++){
            if(matriz[actual][k]==1 && !vis[k]){
                if(dfs(k, destino, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de transporte");
        System.out.println("Estaciones:");
        for(int i=0;i<nombres.length;i++){
            System.out.println("- " + nombres[i]);
        }
        System.out.println("Ingrese dos nombres de estaciones separados por coma (ejemplo: Capri, Tequendama):");
        String entrada = sc.nextLine();
        String[] partes = entrada.split(",");
        if(partes.length < 2){
            System.out.println("Debe ingresar dos nombres separados por coma.");
            return;
        }
        String nombreUno = partes[0].trim();
        String nombreDos = partes[1].trim();

        int idxUno = buscarIndicePorNombre(nombreUno);
        int idxDos = buscarIndicePorNombre(nombreDos);

        if(idxUno == -1 || idxDos == -1){
            System.out.println("Una de las estaciones no existe.");
        } else {
            if(vecinos(idxUno, idxDos)){
                System.out.println("Las estaciones " + nombres[idxUno] + " y " + nombres[idxDos] + " son vecinas.");
            }else{
                System.out.println("No son vecinas.");
                if(camino(idxUno, idxDos)){
                    System.out.println("Pero sí hay un camino entre " + nombres[idxUno] + " y " + nombres[idxDos] + ".");
                }else{
                    System.out.println("Y tampoco hay camino entre ellas.");
                }
            }
        }

    }
}
