import java.util.ArrayList;
import java.util.List;

// TODO 761. 特殊的二进制字符串
public class Main_761 {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }

        // 把 s 划分成若干段合法括号字符串，记录在 substrings 中
        List<String> substrings = new ArrayList<>();
        int diff = 0; // 左括号个数 - 右括号个数
        int start = 0; // 子串开始下标
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') { // 左括号
                diff++;
            } else if (--diff == 0) { // 右括号
                // 子串 [start, i] 是合法括号字符串，且无法继续划分
                // 这意味着子串 [start, i] 只能是嵌套的括号，那么去掉外层的括号，递归解决 [start+1, i-1]
                substrings.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                start = i + 1; // 下一个子串从 i+1 开始
            }
        }

        substrings.sort((a, b) -> b.compareTo(a));
        return String.join("", substrings);
    }
}
