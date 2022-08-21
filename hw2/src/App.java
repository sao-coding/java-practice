import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> id = new ArrayList<>();
        List<Integer> contactee = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number of citizens: ");
        int n = input.nextInt();
        
        for (int i = 0; i < n; i++) {
            id.add(i);
            contactee.add(i);
        }

        System.out.print("       id  ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d",id.get(i));
            System.out.print("  ");
        }

        System.out.println();
        Collections.shuffle(contactee);

        System.out.print("contactee  ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d",contactee.get(i));
            System.out.print("  ");
        }

        System.out.println();
        System.out.print("Enter id of infected citizen: ");
        int menber = input.nextInt();
        input.close();
        List<Integer> citizens = new ArrayList<>();
        int find = -1;
        citizens.add(menber);

        while (find != menber) {
            if (find == -1) {
                find = menber;
            }
            int index = id.indexOf(find);
            find = contactee.get(index);
            citizens.add(find);
        }
        citizens.remove(citizens.size() - 1);
        System.out.println("These citizens are to be self-isolated in the following 14 days: ");
        for (int i = 0; i < citizens.size(); i++) {
            System.out.print(citizens.get(i) + " ");
        }
        System.out.println();
    }
}
