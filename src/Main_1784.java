public class Main_1784 {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                while (i < s.length() && s.charAt(i) == '1') i++;
            }
        }
        return cnt <= 1;
    }
}
