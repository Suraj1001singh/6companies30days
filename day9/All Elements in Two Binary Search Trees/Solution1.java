import java.util.*;

//Definition for a binary tree node.
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = getList(root1);
        List<Integer> l2 = getList(root2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j))
                res.add(l1.get(i++));
            else if (l1.get(i) > l2.get(j))
                res.add(l2.get(j++));
            else {
                res.add(l1.get(i++));
                res.add(l2.get(j++));
            }
        }
        while (i < l1.size())
            res.add(l1.get(i++));
        while (j < l2.size())
            res.add(l2.get(j++));
        return res;
    }

    List<Integer> getList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);

    }
}
// Time complexity : O(n+m)