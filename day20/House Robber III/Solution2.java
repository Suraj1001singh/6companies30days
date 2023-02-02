
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

// -----------MOST OPTIMZED SOLUTION
// HINT :
// https://leetcode.com/problems/house-robber-iii/solutions/79330/step-by-step-tackling-of-the-problem/?orderBy=most_votes

class Solution {
    public int rob(TreeNode root) {
        int ans[] = f(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] f(TreeNode root) {
        if (root == null)
            return new int[2];

        int res[] = new int[2];
        int left[] = f(root.left);
        int right[] = f(root.right);
        // if root is not robbed
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // if root is robbed
        res[1] = root.val + left[0] + right[0];
        return res;
    }

}
// Time complexity : O(n)