public class Main_67 {
    public String addBinary(String a, String b) {
        String res = "";
        int add = 0, aLen = a.length(), bLen = b.length();
        int i = 0;
        while (i < aLen && i < bLen) {
            int ac = a.charAt(aLen - i - 1) - '0';
            int bc = b.charAt(bLen - i - 1) - '0';
            int sum = ac + bc + add;
            res = (sum % 2) + res;
            add = sum / 2;
            i++;
        }
        while (i < aLen) {
            int ac = a.charAt(aLen - i - 1) - '0';
            int sum = ac + add;
            res = (sum % 2) + res;
            add = sum / 2;
            i++;
        }
        while (i < bLen) {
            int bc = b.charAt(bLen - i - 1) - '0';
            int sum = bc + add;
            res = (sum % 2) + res;
            add = sum / 2;
            i++;
        }
        if (add != 0) {
            res = add + res;
        }
        return res;
    }
}
