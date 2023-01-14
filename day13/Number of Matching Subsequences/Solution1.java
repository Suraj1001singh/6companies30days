
//-------------RECURSIVE SOLUTION (Getting TLE)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res=0;
        for(String t : words){
            if(f(s,t,0,0)) res++;
        }
        return res;
    }
    boolean f(String s, String t,int i, int j){
        int n= s.length(),m=t.length();
        if(j==m) return true;
        if(i==n) return j>=m;
        if(s.charAt(i)==t.charAt(j)){
            return f(s,t,i+1,j+1) || f(s,t,i+1,j);
        }
        return f(s,t,i+1,j);
    }
}
