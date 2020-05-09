import java.util.*;

public class Main_lcm {
    private static long gcd(long a, long b){
        long c;
        if (a < b) {
            c = a;
            a = b;
            b = c;
        }
        while (b > 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static long lcm_naive(long a, long b) {
        return (long) a * b / gcd(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}