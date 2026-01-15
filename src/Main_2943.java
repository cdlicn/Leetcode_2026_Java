import java.util.Arrays;

public class Main_2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int mxH = 1, mxV = 1, cntH = 1, cntV = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                cntH++;
                mxH = Math.max(mxH, cntH);
            } else {
                cntH = 1;
            }
        }
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                cntV++;
                mxV = Math.max(mxH, cntV);
            } else {
                cntV = 1;
            }
        }
        return (int) Math.pow(Math.min(mxH, mxV) + 1, 2);
    }
}
