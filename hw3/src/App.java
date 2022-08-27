import java.util.Arrays;
public class App {
    public static int numOfRepetitions = 10;
    public static String[] algorithmTitles = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Arrays.sort"};
    public static int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
    public static double[][] records = new double[algorithmTitles.length][sizes.length];

    public static void main(String[] args) {

        // debug();

        for (int i = algorithmTitles.length - 1; i >= 0; i--) {
            simulate(i);
        }
        showStat();
    }

    public static void debug() {
        System.out.println("Debugging...");
        int [] A = arrayGen(5);
        display(A);
        double t0 = System.nanoTime() / 1e6;
        insertionSort(A);
        double t1 = System.nanoTime() / 1e6;
        display(A);
        System.out.println("Time: " + (t1 - t0) + " ms");
        // System.out.println("Algorithm Titles: " + Arrays.toString(algorithmTitles));
        // System.out.println("Sizes: " + Arrays.toString(sizes));
        // System.out.println("Records: " + Arrays.deepToString(records));
    }

    public static void simulate(int algoNo) {
        System.out.printf("Simulating %s: ", algorithmTitles[algoNo]);
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < numOfRepetitions; j++) {
                int[] A = arrayGen(sizes[i]);
                double t0 = System.nanoTime() / 1e6;
                switch (algoNo) {
                    case 0:
                        bubbleSort(A);
                        // break;
                    case 1:
                        selectionSort(A);
                        // break;
                    case 2:
                        insertionSort(A);
                        // break;
                    case 3:
                        Arrays.sort(A);
                        // break;
                }
                double t1 = System.nanoTime() / 1e6;
                records[algoNo][i] += t1 - t0;
            }

            System.out.printf(".");
            records[algoNo][i] /= numOfRepetitions;
        }
        System.out.println("done.");
    }
    
    public static void showStat() {
        System.out.println("Benchmark (time unit: ms)");
        System.out.printf("%7s", "Size");

        for (String title : algorithmTitles) {
            System.out.printf("%17s", title);
        }
        System.out.println();

        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%7d", sizes[i]);
            for (int j = 0; j < algorithmTitles.length; j++) {
                System.out.printf("%17.3f", records[j][i]);
            }
            System.out.println();
        }
    }

    public static int[] arrayGen(int size) {
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = (int) (Math.random() * size * 10);
        }
        return A;
    }

    public static void display(int[] A) {
        for (int item: A) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }

    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int j = i;
            while (j > 0 && A[j - 1] > temp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;

            // System.out.println(i);
            // display(A);
        }
    }


}