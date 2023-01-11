//------------OPTMIZED SOLUTION
//HINT : Number of appearance of 5 is less than  or equal to 2

class Solution {
    public int trailingZeroes(int n) {
        int b = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0 && num % 5 == 0) {
                b++;
                num /= 5;
            }
        }
        return b;
    }
}