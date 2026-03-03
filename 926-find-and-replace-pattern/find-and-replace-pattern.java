import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (matches(w, pattern)) ans.add(w);
        }
        return ans;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) return false;

        int[] p2w = new int[128];
        int[] w2p = new int[128];
        Arrays.fill(p2w, -1);
        Arrays.fill(w2p, -1);

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (p2w[p] == -1 && w2p[w] == -1) {
                p2w[p] = w;
                w2p[w] = p;
            } else {
                if (p2w[p] != w || w2p[w] != p) return false;
            }
        }
        return true;
    }
}