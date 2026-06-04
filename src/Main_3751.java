public class Main_3751 {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        while (num1 <= num2) {
            res += f(num1);
            num1++;
        }
        return res;
    }

    public int f(int x) {
        String s = String.valueOf(x);
        int cnt = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if ((s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) ||
                    (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1))) {
                cnt++;
            }
        }
        return cnt;
    }

}
