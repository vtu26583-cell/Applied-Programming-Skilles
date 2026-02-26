class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. If the node is null, no path exists
        if (root == null) {
            return false;
        }

        // 2. Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 3. Subtract current value and recurse down to children
        // Use OR (||) because we only need ONE path to be true
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}