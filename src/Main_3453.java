import java.util.*;

public class Main_3453 {
    public double separateSquares(int[][] squares) {
        Arrays.sort(squares, Comparator.comparingInt(a -> a[1]));
        List<int[]> list = new ArrayList<>();
        for (int[] square : squares) {
            int y = square[1];
            int l = square[2];
            list.add(new int[]{y, l});
            list.add(new int[]{y + l, -l});
        }

        list.sort(Comparator.comparingInt(a -> a[0]));

        double sum = 0;
        double currentY = 0;
        long currentL = 0;
        for (int[] ints : list) {
            int y = ints[0];
            int l = ints[1];
            sum += currentL * (y - currentY);
            currentY = y;
            currentL += l;
        }

        double half = sum / 2.0;
        double currentArea = 0.0;
        currentY = 0.0;
        currentL = 0;

        for (int[] ints : list) {
            int y =  ints[0];
            int l = ints[1];
            if (currentL > 0) {
                double areaToAdd = currentL * ((double) y - currentY);
                if (currentArea + areaToAdd >= half) {
                    double remainingArea = half - currentArea;
                    return currentY + remainingArea / currentL;
                }
                currentArea += areaToAdd;
            }
            currentY = y;
            currentL += l;
        }
        return -1.0;
    }
}
