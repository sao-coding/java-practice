public class App {
    public static void main(String[] args) {    
        for (int i = -10; i <= 10; i++) {
            System.out.printf("%d ^ %d = %f\n", 2, i, pow(2, i));
        }
        // System.out.println(5/2);
    }

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        int m = n >= 0 ? n : -n; // 解決 n 為負數的問題
        double y = pow(x, m / 2);
        y = y * y;

        if (m % 2 == 1)
            y = x * y;
        return n > 0 ? y : 1 / y;
        // if (n % 2 == 1) {
        //     y = y * x;
        // }
        // return y;

        // return n % 2 == 1 ? x * y : y;
    }
}