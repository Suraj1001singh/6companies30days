
//-----------OPTMIZED SOLUITON (Getting TLE)

class Solution2 {
    public int findIntegers(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) if ((i & (i << 1)) == 0)  res++;
        return res;
    }
}
// Time complexity : O(n)
