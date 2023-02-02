import java.util.*;

//-------------------MEMOIZATION 

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        HashMap<String, Integer> dp = new HashMap<>();
        return f(0, n, price, special, needs, dp);
    }

    int f(int ind, int n, List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            HashMap<String, Integer> dp) {
        // base case
        if (ind == special.size()) {
            int cost = 0;
            for (int i = 0; i < n; i++) {
                cost += needs.get(i) * price.get(i);
            }
            return cost;
        }
        if (dp.containsKey(getString(ind, needs)))
            return dp.get(getString(ind, needs));
        List<Integer> it = special.get(ind);
        boolean isValid = true;
        for (int i = 0; i < n; i++) {
            if (needs.get(i) < it.get(i)) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(needs.get(i) - it.get(i));

            int a = it.get(n) + f(ind, n, price, special, temp, dp); // take
            int b = f(ind + 1, n, price, special, needs, dp);// not take
            dp.put(getString(ind, needs), Math.min(a, b));
            return Math.min(a, b);

        } else {
            int a = f(ind + 1, n, price, special, needs, dp);
            dp.put(getString(ind, needs), a);
            return a;
        }

    }

    String getString(int ind, List<Integer> list) {
        StringBuilder str = new StringBuilder();
        str.append(ind);
        for (int i : list)
            str.append("-" + i);
        return str.toString();

    }
}
// Time complexity : O( len(special) * len(needs) )