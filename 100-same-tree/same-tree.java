/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Both are null: reached the end of the branch successfully
        if (p == null && q == null) {
            return true;
        }
        
        // 2. One is null but the other isn't: structural mismatch
        if (p == null || q == null) {
            return false;
        }
        
        // 3. Values don't match: data mismatch
        if (p.val != q.val) {
            return false;
        }
        
        // 4. Recursively check both subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}