public class Main_3612 {
    String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!res.isEmpty()) {
                    res.setLength(res.length() - 1);
                }
            } else if (c == '#') {
                res.append(res);
            } else if (c == '%') {
                res.reverse();
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
