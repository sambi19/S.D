public class OrdenamientosEnteros
{
    public static void main(String[] args)
    {
        int[] desordenado = {15, 8, 7, 9, 5, 1, 0, 4, 10, 3};

    
        int[] ordenadoBurbuja = burbuja(desordenado);
        int[] ordenadoInsercion = insertSort(desordenado);
        int[] ordenadoMerge = mergeSort(desordenado);

        //Ordenar:
        System.out.println("Ordenado por Burbuja:");
        for(int i=0; i < ordenadoBurbuja.length; i++)
            System.out.printf("%d,",ordenadoBurbuja[i]);
        
        System.out.println("\nOrdenado por Inserción:");
        for(int i=0; i < ordenadoInsercion.length; i++)
            System.out.printf("%d,",ordenadoInsercion[i]);

        System.out.println("\nOrdenado por Merge Sort:");
        for(int i=0; i < ordenadoMerge.length; i++)
            System.out.printf("%d,",ordenadoMerge[i]);
    }

    //ordenamiento burbuja
    public static int[] burbuja(int[] arr) {
        int n = arr.length;
        int[] ordenado = arr.clone(); // Copia del arreglo original

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ordenado[j] > ordenado[j + 1]) {
                    // Intercambio de valores
                    int temp = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = temp;
                }
            }
        }
        return ordenado;
    }

    //ordenamiento inserccion
    public static int[] insertSort(int[] arr) {
        int n = arr.length;
        int[] ordenado = arr.clone(); // Copia del arreglo original

        for (int i = 1; i < n; i++) {
            int key = ordenado[i];
            int j = i - 1;

            while (j >= 0 && ordenado[j] > key) {
                ordenado[j + 1] = ordenado[j];
                j = j - 1;
            }
            ordenado[j + 1] = key;
        }
        return ordenado;
    }
//ordenamiento mergesort
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
