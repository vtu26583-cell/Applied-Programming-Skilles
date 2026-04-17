class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Don't compare the word with itself
                if (i == j) continue;
                
                // Check if words[i] is a substring of words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    // Break the inner loop once a match is found
                    break; 
                }
            }
        }
        
        return result;
    }
}