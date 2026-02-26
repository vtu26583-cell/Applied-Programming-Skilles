class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Create a frequency array for 'a'-'z'
        int[] freq = new int[26];
        
        // Fill the array with counts of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Iterate through the string again to find the first count of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}