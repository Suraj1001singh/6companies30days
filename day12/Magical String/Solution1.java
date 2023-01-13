
//---Just observe the pattern

class Solution {
    public int magicalString(int n) {
        if (n <= 3) return 1;
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int head = 2, tail = 3, num = 1, res = 1;
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                if (num == 1 && tail < n) res++;
                a[tail++] = num;
            }
            head++;
            num = num ^ 3; // just to toggle num between 1 and 2
        }
        return res;
    }
}
// Time complexity : O(n)