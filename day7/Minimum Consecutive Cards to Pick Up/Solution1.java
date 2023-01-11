import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<cards.length; i++){
            if(map.containsKey(cards[i]))
                ans=Math.min(ans, i-map.get(cards[i])+1 );
            map.put(cards[i],i);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
//Time complexity : O(n)
//Space complexity : o(n)