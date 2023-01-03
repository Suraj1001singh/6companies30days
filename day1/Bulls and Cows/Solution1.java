

class Solution {
    public String getHint(String secret, String guess) {
        int l1 = secret.length(), l2 = guess.length(), bulls = 0, cows = 0;
        int s[] = new int[10];
        int g[] = new int[10];
        if (l1 != l2) return "0A0B";
        for (int i = 0; i < l2; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++)
            cows += Math.min(s[i], g[i]);
        return bulls + "A" + cows + "B";
    }
}
//Time complexity : O(n)
//Space complexity : O(1) constant 