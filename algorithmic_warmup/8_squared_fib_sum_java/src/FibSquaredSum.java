import java.util.ArrayList;
import java.util.Scanner;

public class FibSquaredSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(SumOfSquaresOfFibNum(n));
    }

//    private static int sumOfSquares(ArrayList<Integer> a, long n){
//        ArrayList<Integer> mas = new ArrayList<>();
//        for (int i = 0; i < 60; i++){
//            mas.add(a.get(i));
//        }
//
//        int sumOfSquares = 0;
//
//        for (int elem: mas) {
//            sumOfSquares = (sumOfSquares + elem * elem) % 10;
//        }
//
//        long countOfEntries = n / sumOfSquares;
//        int leftoversNum = (int) n % sumOfSquares;
//
//        int sumOver = 0;
//
//        for(int i = 0; i <= leftoversNum; i ++ ){
//            sumOver = (sumOver + mas.get(i) * mas.get(i)) % 10;
//        }
//        return (sumOver + sumOfSquares) % 10;
//    }

    private static int sumOfSquares(ArrayList<Integer> a, long n){
        ArrayList<Integer> mas = new ArrayList<>();
        for (int i = 0; i < 60; i++){
            mas.add(a.get(i));
        }
//        System.out.println(mas);
        int num = (int) (n % 60);
//        System.out.println(num);
        int nextNum = (num + 1) % 60;
        return (mas.get(num) * mas.get(nextNum)) % 10;
    }

    private static long SumOfSquaresOfFibNum(long n){
        int next = 1;
        int curr = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            a.add(curr);
            int newNext = (curr + next) % 10;
            curr = next;
            next = newNext;
            if (i > 2 && curr == 0 && next == 1){
//                System.out.println("Started");
                return(sumOfSquares(a, n));
            }
        }
        return (curr * next) % 10;
    }
}
