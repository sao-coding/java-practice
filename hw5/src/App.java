import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner input = new Scanner(System.in);
        // int x = (int)(Math.random() * 100);
        // int n = -1;
        // int min = 0;
        // int max = 99;
        // input.close();

        // new Game(new BinarySearchAI()).run();

        int m = 0, N = 100000;
        Player player = new SuperAI();
        for (int i = 0; i <= N; i++) {
            Game game = new Game(player);
            if (game.run()) {
                m++;
            }
        }

        System.out.println("Win rate: " + 100.0 * m / N + "%");
    }
}

class Player {
    public int next(int min, int max) {
        return 0;
    }
}

class HumanPlayer extends Player {
    private Scanner input = new Scanner(System.in);

    HumanPlayer() {

    }

    @Override // 確認子類別的方法是和父類別的方法完全一樣
    public int next(int min, int max) {
        return input.nextInt();
    }
}

class NaiveAI extends Player {

    @Override
    public int next(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}

class BinarySearchAI extends Player {

    @Override
    public int next(int min, int max) {
        return (min + max) / 2;
    }
}

class SuperAI extends Player {

    @Override
    public int next(int min, int max) {
        return min;
    }
}

class Game {

    private int min = 0, max = 99, x;
    private Player player;

    Game(Player player) {
        x = (int)(Math.random() * 100);
        // System.out.println(x);
        this.player = player;
    }

    public boolean run() {
        int n = -1;
        while (n != x) {
            // System.out.print("請輸入" + min + "~" + max + "之間的數字: ");
            n = player.next(min, max);
            // System.out.println(n);
            // n = Integer.parseInt(System.console().readLine());
            if (n == x) {
                // System.out.println("You win!");
                return true;
                // break;
            } else if (n < min || n > max) {
                // System.out.println("請重新輸入");
            } else if (n > x) {
                max = n-1;
            } else if (n < x) {
                min = n+1;
            } 
            if (x == min && x == max) {
                // System.out.println("答案是" + x);
                // System.out.println("You lose!");
                return false;
                // break;
            }
            // System.out.println("(" + min + "," + max + ")?");
        }
        return false;
    }
}