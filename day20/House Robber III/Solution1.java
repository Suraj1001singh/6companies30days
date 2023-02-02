
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// -----------RECURSIVE SOLUTION (TLE)

class Solution {
    public int rob(TreeNode root) {
        return Math.max(f(root, false), f(root, true));
    }

    int f(TreeNode node, boolean canRob) {
        if (node == null)
            return 0;
        if (!canRob)
            return f(node.left, true) + f(node.right, true);
        int pick = node.val + f(node.left, false) + f(node.right, false);
        int notPick = f(node.left, true) + f(node.right, true);
        return Math.max(pick, notPick);
    }
}