class Solution {
    public int trailingZeroes(int n) {
        int a=0,b=0;
        for(int i=1 ; i<=n; i++){
            int num=i;
            while(num!=0 && num%2==0){
                a++;
                num/=2;
            }
            num=i;
            while(num!=0 && num%5==0){
                b++;
                num/=5;
            }
        }
        return Math.min(a,b);
    }
}