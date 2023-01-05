//either nth person will get it's own seat or not so probability is 0.5

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}