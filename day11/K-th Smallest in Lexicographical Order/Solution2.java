//----------OPTMIZATION OVER PREVIOUS CONCEPT

//Hint : calculate the number of nodes in particular sub tree, then move to next subtree if required
// https://www.youtube.com/watch?v=s3y1l3KV8bM

class Solution2 {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k--;
        while (k > 0) {
            int nodes = countNodes(n, cur);
            if (k >= nodes) {
                cur++;
                k -= nodes;
            } else {
                cur *= 10;
                k--;
            }
        }
        return (int) cur;

    }

    private int countNodes(int n, long cur) {
        long ttl = 0;
        long next = cur + 1;
        while (cur <= n) {
            ttl += Math.min(n - cur + 1, next - cur);
            cur *= 10;
            next *= 10;
        }
        return (int) ttl;
    }

}
// Time complexity : <O(k)