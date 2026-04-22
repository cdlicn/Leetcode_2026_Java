import java.util.ArrayList;
import java.util.List;

public class Main_2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int diff = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        diff++;
                    }
                }
                if (diff <= 2) {
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }
}
