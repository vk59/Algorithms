import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int i = 0;
        int sum = 0;
        while (sum < n) {
            i++;
            sum += i;
            summands.add(i);
        }
        if (sum != n) {
            int i1 = summands.size() - 1;
            int i2 = i1 - 1;
            sum = sum - summands.get(i1) - summands.get(i2);
            summands.remove(i1);
            summands.remove(i2);
            summands.add(n - sum);
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
