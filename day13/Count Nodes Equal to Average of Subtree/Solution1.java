// Definition for a binary tree node.
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

class Solution {
    int ans;

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        getSum(root);
        return ans;
    }

    int[] getSum(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int left[] = getSum(root.left);
        int right[] = getSum(root.right);
        if (root.val == (left[0] + right[0] + root.val) / (left[1] + right[1] + 1))
            ans++;
        return new int[] { left[0] + right[0] + root.val, left[1] + right[1] + 1 };
    }

}
// Time complexity : O(n) n : number of nodes