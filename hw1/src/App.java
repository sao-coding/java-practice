public class App {
    public static void main(String[] args) throws Exception {
        int x = (int)(Math.random() * 100);
        int n = -1;
        int min = 0;
        int max = 99;
        while (n != x) {
            System.out.print("請輸入" + min + "~" + max + "之間的數字: ");
            n = Integer.parseInt(System.console().readLine());
            if (n == x) {
                System.out.println("You win!");
                break;
            } else if (n < min || n > max) {
                System.out.println("請重新輸入");
            } else if (n > x) {
                max = n-1;
            } else if (n < x) {
                min = n+1;
            } 
            if (x == min && x == max) {
                System.out.println("答案是" + x);
                System.out.println("You lose!");
                break;
            }
            System.out.println("(" + min + "," + max + ")?");
        }
    }
}