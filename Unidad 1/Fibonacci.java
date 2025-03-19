public class EjerciciosRecursion {
    public static void main(String[] args) {
        int n = 45; 
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(fibo(i) + " ");
        }
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
