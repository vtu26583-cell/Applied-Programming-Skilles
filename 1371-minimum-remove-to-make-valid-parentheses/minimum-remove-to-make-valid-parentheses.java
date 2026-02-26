class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int open = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                open++;
            } else if (arr[i] == ')') {
                if (open == 0) arr[i] = '*';
                else open--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (open > 0 && arr[i] == '(') {
                arr[i] = '*';
                open--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') sb.append(c);
        }
        return sb.toString();
    }
}