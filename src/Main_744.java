public class Main_744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            int left = -1;
            int right = n;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right < n ? letters[right] : letters[0];
        }
    }
}
