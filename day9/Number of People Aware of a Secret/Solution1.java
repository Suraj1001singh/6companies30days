
//-------NAIVE APPROACH
//------------RECURSIVE APPROACH

class Solution {
    int glb_delay;
    int glb_forget;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        glb_delay = delay;
        glb_forget = forget;
        return f(n, delay, forget);

    }

    int f(int n, int delay, int forget) {
        if (n == 1)
            return 1;
        if (forget == 1)
            return 0;
        if (delay == 1)
            return f(n - 1, 1, forget - 1) + f(n - 1, glb_delay, glb_forget);
        return f(n - 1, delay - 1, forget - 1);
    }
}