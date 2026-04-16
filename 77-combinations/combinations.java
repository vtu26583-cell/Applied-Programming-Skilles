class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the combination is the desired size
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization: only loop if there are enough numbers left to fill the combination
        // i <= n - (k - current.size()) + 1
        for (int i = start; i <= n; i++) {
            current.add(i);            // Choose the number
            backtrack(i + 1, n, k, current, result); // Recurse to next number
            current.remove(current.size() - 1); // Backtrack (remove the choice)
        }
    }
}