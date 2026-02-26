class Solution {
    public boolean isSymmetric(TreeNode root) {
        // A null tree is technically symmetric
        if (root == null) {
            return true;
        }
        // Compare the left and right subtrees
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both reach the end, they match
        if (t1 == null && t2 == null) return true;
        
        // If only one is null, they aren't mirrors
        if (t1 == null || t2 == null) return false;
        
        // The values must match AND their subtrees must be cross-mirrored
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)  // Left of T1 with Right of T2
            && isMirror(t1.right, t2.left); // Right of T1 with Left of T2
    }
}