import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];          // ASCII
        Arrays.fill(last, -1);

        int left = 0, best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (last[c] >= left) {
                left = last[c] + 1;         // shrink window
            }
            last[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}