// Last updated: 4/15/2026, 3:42:21 PM
class Fancy {
private static final int MOD = 1000000007;
    private long add;
    private long mul;
    private List<Integer> seq;

    public Fancy() {
        add = 0;
        mul = 1;
        seq = new ArrayList<>();
    }

    public void append(int val) {
        long v = ((val - add) % MOD + MOD) % MOD;
        v = (v * modInverse(mul)) % MOD;
        seq.add((int) v);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) {
            return -1;
        }
        long val = seq.get(idx);
        long res = (val * mul + add) % MOD;
        return (int) res;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % MOD;
            }
            exp = exp >> 1;
            base = (base * base) % MOD;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */