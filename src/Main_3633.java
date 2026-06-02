public class Main_3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                f(landStartTime, landDuration, waterStartTime, waterDuration),
                f(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    public int f(int[] s1, int[] d1, int[] s2, int[] d2) {
        int end1 = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length; i++) {
            end1 = Math.min(end1, s1[i] + d1[i]);
        }
        int end2 = Integer.MAX_VALUE;
        for (int i = 0; i < s2.length; i++) {
            end2 = Math.min(end2, Math.max(s2[i], end1) + d2[i]);
        }
        return end2;
    }

}
