public class App {
    public static void main(String[] args) {    
        System.out.println(pow(2, 10));
    
    }

    public static double pow(double base, int exponent) {
    
        if (exponent == 0) return 1;
        double y = pow(base, exponent / 2);
        y = y * y;
        if (exponent % 2 == 1) y *= base;
        return y;
    
    }
}