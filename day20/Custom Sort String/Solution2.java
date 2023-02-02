
class Solution {
    public String customSortString(String order, String s) {
        int count[] = new int[26];
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        for (int i = 0; i < order.length(); i++) {
            while (count[order.charAt(i) - 'a']-- > 0)
                str.append(order.charAt(i));

        }
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0)
                str.append((char) (i + 'a'));
        }
        return str.toString();
    }
}
// Time complexity : O(len(s))