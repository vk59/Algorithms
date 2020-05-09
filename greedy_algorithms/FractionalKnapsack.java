import java.util.Scanner;
import java.lang.Math;

public class FractionalKnapsack {
    private static void sortMassive(double[] a, int[] w) {
        int n = a.length;
        for (int i=0; i < n; i++) {
            for (int j=1; j < n - i; j++) {
                if (a[j] > a[j - 1]) {
                    double t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                    int tw = w[j];
                    w[j] = w[j - 1];
                    w[j - 1] = tw;
                }
            }
        }
    }


    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n = values.length;
        double[] optimalValues = new double[n];
        for(int i=0; i<n; i++){
            optimalValues[i] = (double) (values[i]) / weights[i];
        }
        sortMassive(optimalValues, weights);
        // for (int i = 0; i < n; i++) {
        //     System.out.println(optimalValues[i]);
        // }
        int i = 0;
        while (i < n) {
            if (capacity == 0) {
                return value;
            }
            int this_weight = Math.min(capacity, weights[i]);
            value += this_weight * optimalValues[i];
            capacity -= this_weight;
            i++;
        }
        return value;
    }

    private static double getOptimalValueNaive(int capacity, int[] values, int[] weights) {
        double value = 0;
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        // double[] valuesDouble = new double[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            // valuesDouble[i] = (double) values[i];
            weights[i] = scanner.nextInt();
        }
        // valuesDouble = sortMassive(valuesDouble);
        // for (int i = 0; i < n; i ++) {
        //     System.out.print(valuesDouble[i] + " ");
        // }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
