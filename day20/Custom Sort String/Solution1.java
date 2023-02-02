import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(new Pair(s.charAt(i), map.getOrDefault(s.charAt(i), 26)));
        }
        Collections.sort(list, (a, b) -> a.order - b.order);
        StringBuilder str = new StringBuilder();
        for (Pair p : list)
            str.append(p.c);
        return str.toString();
    }
}

class Pair {
    char c;
    int order;

    Pair(char a, int b) {
        c = a;
        order = b;
    }
}