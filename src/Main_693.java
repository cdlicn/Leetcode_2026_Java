public class Main_693 {
    public boolean hasAlternatingBits(int n) {
        int x = n % 2;
        n /= 2;
        while (n > 0) {
            if (n % 2 == x) {
                return false;
            }
            x = n % 2;
            n /= 2;
        }
        return true;
    }
}
