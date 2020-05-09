import java.util.*;

public class DotProduct {
    private static int indexOfMax(int[] a) {
        int max = a[0];
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static long maxDotProduct(int[] a, int[] b) {
        long sum = 0;
        int n = a.length;
        while (n > 0){
            int indexA = indexOfMax(a);
            int indexB = indexOfMax(b);
            long this_multi = a[indexA] * b[indexB];
            System.out.println(String.valueOf(indexA) + " : " + String.valueOf(indexB));
            sum += this_multi;
            // System.out.println(this_multi);
            // for (int i = 0; i < n; i ++ ) {
            //   System.out.println(String.valueOf(i) + " : " + String.valueOf(a[i]));
            // }
            a = deleteWithIndex(a, indexA);
            b = deleteWithIndex(b, indexB);
            n--;
            // System.out.println("DELETED " + String.valueOf(indexA));
            // for (int i = 0; i < n; i ++ ) {
            //   System.out.println(String.valueOf(i) + " : " + String.valueOf(a[i]));
            // }
            // System.out.println();
        }
        return sum;
    }

    private static int[] deleteWithIndex(int[] a, int index) {
        int[] x = new int[a.length - 1];
        for (int i = 0; i < index; i ++ ) {
            x[i] = a[i];
        }
        for (int i = index; i < a.length - 1; i ++) {
            x[i] = a[i + 1];
        }
        return x;
    }

    private static void sortMas(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < n - i; j++) {
                if (x[j] > x[j - 1]) {
                    int temp = x[j];
                    x[j] = x[j - 1];
                    x[j - 1] = temp;
                }
            }
        }
    }

    private static long maxDotProductNaive(int[] a, int[] b) {
        sortMas(a);
        sortMas(b);
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (long) (a[i]) * b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProductNaive(a, b));
        // final Random rand = new Random();
        // while(true) {
        //     int n = rand.nextInt(500) + 500;
        //     System.out.println("N = " + String.valueOf(n) + "\nA: ");
        //     int[] a = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         a[i] = rand.nextInt(200000) - 100000;
        //         System.out.print(String.valueOf(a[i]) + " ");
        //     }
        //     System.out.println("\nB:");
        //     int[] b = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         b[i] =  rand.nextInt(200000) - 100000;
        //         System.out.print(String.valueOf(b[i]) + " ");
        //     }
        //     System.out.println();
        //     int[] x = a.clone();
        //     int[] y = b.clone();
        //     long res = maxDotProduct(a, b);
        //     long resNaive = maxDotProductNaive(x, y);
        //     System.out.println(String.valueOf(res) + " :: " + String.valueOf(resNaive));
        //     if (res != resNaive) {
        //         System.out.println("ERROR");
        //         break;
        //     }
        // }

    }
}
