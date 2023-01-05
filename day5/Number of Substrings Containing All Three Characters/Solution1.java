class Solution {
    public int numberOfSubstrings(String s) {
        int a[] = new int[3];
        int i = 0, cnt = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            a[c - 'a']++;
            if (a[0] > 0 && a[1] > 0 && a[2] > 0) {
                while (i < s.length() && isValid(i, a, s)) {
                    a[s.charAt(i) - 'a']--;
                    i++;
                }
                cnt += i + 1;
            }
        }
        return cnt;
    }

    public boolean isValid(int i, int[] a, String s) {
        int c = s.charAt(i);
        if (a[c - 'a'] - 1 <= 0)
            return false;
        return true;
    }
}