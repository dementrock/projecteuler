class Quadratic {

    public int a, b, c, d; // Fraction (a*sqrt(b) + c) / d

    private int gcd (int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd (y % x, x);
    }

    public Quadratic (int raw_a, int raw_b, int raw_c, int raw_d) {
        int common = gcd(gcd(raw_a, raw_c), raw_d);
        a = raw_a / common;
        b = raw_b;
        c = raw_c / common;
        d = raw_d / common;
    }

    public int getInt() {
        return (int) ((a * Math.sqrt(b) + c) / d);
    }
    
    public Quadratic getNext() {
        int new_a = a, new_b = b, new_c = c - d * getInt(), new_d = d;
        return new Quadratic(new_a * new_d, b, - new_c * new_d, new_a * new_a * new_b - new_c * new_c);
    }

    public String toString() {
        return String.format("(%d*sqrt(%d) + %d) / %d", a, b, c, d);
    }

    public boolean equals (Quadratic other) {
        return a == other.a && b == other.b && c == other.c && d == other.d;
    }
}

public class p64 {
    public static boolean equal (double a, double b) {
        return Math.abs(a - b) < 1e-8;
    }
    public static final int MAX = 100000;
    public static Quadratic[] cache = new Quadratic[MAX];
    public static int calcPeriod (Quadratic x) {
        int now = -1;
        while (true) {
            ++now;
            for (int i = 0; i < now - 1; ++i) {
                if (x.equals(cache[i])) {
                    return now - i - 1;
                }
            }
            x = cache[now] = x.getNext();
        }
    }
    public static void main (String[] args) {
        int ans = 0;
        for (int i = 1; i <= 10000; ++i) {
            if (! equal((int)Math.sqrt(i), Math.sqrt(i))) {
                if (calcPeriod(new Quadratic(1, i, 0, 1)) % 2 == 1) {
                    ++ans;
                }
            }
        }
        System.out.println(ans);
    }
}
