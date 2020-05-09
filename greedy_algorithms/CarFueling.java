import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numOfStops = stops.length;
        int[] x = new int[numOfStops + 2];
        for(int i=1; i < numOfStops + 1; i++) {
            x[i] = stops[i - 1];
        }
        x[0] = 0;
        x[numOfStops + 1] = dist;
        int n = x.length - 2;

        int refills = 0;
        int currentRefill = 0;


        while (currentRefill <= n) {
            int lastRefill = currentRefill;
            while (currentRefill <= n && x[currentRefill + 1] - x[lastRefill] <= tank) {
                currentRefill++;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }
            if (currentRefill <= numOfStops) {
                refills++;
            }
        }
        return refills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
