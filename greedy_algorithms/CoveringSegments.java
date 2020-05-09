import java.util.*;

public class CoveringSegments {
    private static void sortSegmentsEnds(Segment[] segments) {
        int n = segments.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j ++) {
                if (segments[j].getEnd() < segments[j - 1].getEnd()) {
                    Segment t = segments[j];
                    segments[j] = segments[j - 1];
                    segments[j - 1] = t;
                }
            }
        }
    }
    //
    // private static void sortSegmentsStarts(Segment[] segments) {
    //     int n = segments.length;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 1; j < n - i; j ++) {
    //             if (segments[j].getStart() < segments[j - 1].getStart()) {
    //                 Segment t = segments[j];
    //                 segments[j] = segments[j - 1];
    //                 segments[j - 1] = t;
    //             }
    //         }
    //     }
    // }

    private static boolean isElemIn(int[] mas, int elem) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == elem) {
                return true;
            }
        }
        return false;
    }

    private static int[] getUniqueNumbers(int[] a) {
        int[] x = new int[a.length];
        x[0] = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (! isElemIn(x, a[i])) { x[count] = a[i]; count++; }

        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = x[i];
        }
        return res;
    }

    private static int[] optimalPoints(Segment[] segments) {
        sortSegmentsEnds(segments);
        int n = segments.length;
        int[] masEnds = new int[n];
        for (int i = 0; i < n; i++) {
            masEnds[i] = segments[i].getEnd();
        }
        int thisMark = masEnds[0];
        for(int i = 1; i < n; i++) {
            if (thisMark <= segments[i].getEnd() && segments[i].getStart() <= thisMark) {
                masEnds[i] = thisMark;
            }
            else {
                thisMark = masEnds[i];
            }
        }

        // for (int i = n - 2; i >= 0; i--) {
        //     int thisEnd = masEnds[i];
        //     for (int j = i + 1; j < n; j ++) {
        //         if (thisEnd <= segments[j].getEnd() && segments[j].getStart() <= thisEnd) {
        //             masEnds[j] = thisEnd;
        //         }
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(masEnds[i]);
        // }
        int[] points = getUniqueNumbers(masEnds);
        return points;
    }
    //
    // private static int[] optimalPointsStarts(Segment[] segments) {
    //     sortSegmentsStarts(segments);
    //     int n = segments.length;
    //     int[] masStarts = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         masStarts[i] = segments[i].getStart();
    //     }
    //     for (int i = 1; i < n; i++) {
    //         int thisStart = masStarts[i];
    //         for (int j = i; j >= 0; j --) {
    //             if (thisStart <= segments[j].getEnd() && segments[j].getStart() <= thisStart) {
    //                 masStarts[j] = thisStart;
    //             }
    //         }
    //     }
    //     // for (int i = 0; i < n; i++) {
    //     //     System.out.println(masEnds[i]);
    //     // }
    //     int[] points = getUniqueNumbers(masStarts);
    //     return points;
    // }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }

        System.out.println();
        //
        // int[] points2 = optimalPointsStarts(segments);
        // System.out.println(points2.length);
        // for (int point : points2) {
        //     System.out.print(point + " ");
        // }
    }
}
