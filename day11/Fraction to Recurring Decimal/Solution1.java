import java.util.*;

//--------LONG DIVISION METHODE

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if (numerator == 0) {
            res.append(0);
            return res.toString();
        }
        if (numerator < 0 != denominator < 0)
            res.append("-");
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        res.append(num / deno);
        num %= deno;
        if (num == 0)
            return res.toString();
        res.append(".");
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / deno);
            num %= deno;
            if (map.containsKey(num)) {
                int ind = map.get(num);
                res.insert(ind, "(");
                res.append(")");
                return res.toString();
            }
            map.put(num, res.length());
        }
        return res.toString();
    }
}