class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, paths);
        return paths;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) return;

        // 1. Add current node to the path
        currentPath.add(node.val);

        // 2. Check if it's a leaf and the sum matches
        if (node.left == null && node.right == null && targetSum == node.val) {
            // We must create a new copy of the list because currentPath is mutable
            paths.add(new ArrayList<>(currentPath));
        } else {
            // 3. Continue exploring left and right subtrees
            findPaths(node.left, targetSum - node.val, currentPath, paths);
            findPaths(node.right, targetSum - node.val, currentPath, paths);
        }

        // 4. Backtrack: remove the current node before going back up to the parent
        currentPath.remove(currentPath.size() - 1);
    }
}