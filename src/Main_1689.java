public class Main_1689 {
    public int minPartitions(String n) {
        for (int i = 9; i >= 0; i--) {
            if (n.contains(i + "")) {
                return i;
            }
        }
        return 0;
    }
}
