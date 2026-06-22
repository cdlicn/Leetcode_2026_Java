public class Main_1189 {
    public int maxNumberOfBalloons(String text) {
        int a = 0, b = 0, l = 0, o = 0, n = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a') a++;
            else if (text.charAt(i) == 'b') b++;
            else if (text.charAt(i) == 'l') l++;
            else if (text.charAt(i) == 'o') o++;
            else if (text.charAt(i) == 'n') n++;
        }
        return Math.min(a, Math.min(Math.min(Math.min(l / 2, o / 2), b), n));
    }
}
