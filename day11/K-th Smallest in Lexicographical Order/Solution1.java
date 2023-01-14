
// Preorder traversal of tree (Getting TLE)
class Solution {
    int ans;
    int count;

    public int findKthNumber(int n, int k) {
        ans = 0;
        count = k;
        for (int i = 1; i < 10; i++) {
            if (f(i, n))
                break;
        }
        return ans;
    }

    boolean f(int num, int n) {
        if (num > n)
            return false;
        count--;
        if (count == 0) {
            ans = num;
            return true;
        }
        for (int i = 0; i < 10; i++) {
            if (f(num * 10 + i, n))
                return true;
        }
        return false;
    }
}
// Time complexity : O(k)