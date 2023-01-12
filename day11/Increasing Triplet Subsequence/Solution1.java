//-------ALGO
//lets take two number x1, and x2
// if a[i] <x1 this means it shoudl be x1
// if a[i]>x1 but less than x2 , then it should be x2
// and if  a[i]>x1 and greater than x2 as well, it should be third number and return true;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int x1=Integer.MAX_VALUE;
        int x2=Integer.MAX_VALUE;
        for(int i : nums){
            if(i<x1) x1=i;
            else if( i<x2 && i>x1) x2=i;
            else if(i>x2) return true;
        }
        return false;
    }
}
//Time complexity : O(n)