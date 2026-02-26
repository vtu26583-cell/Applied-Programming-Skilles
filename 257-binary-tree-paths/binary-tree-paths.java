class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            findPaths(root, "", result);
        }
        return result;
    }

    private void findPaths(TreeNode node, String path, List<String> result) {
        // Append current node value to the path
        path += node.val;

        // Check if it's a leaf node
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // If not a leaf, continue to children with the "->" separator
        if (node.left != null) {
            findPaths(node.left, path + "->", result);
        }
        if (node.right != null) {
            findPaths(node.right, path + "->", result);
        }
    }
}