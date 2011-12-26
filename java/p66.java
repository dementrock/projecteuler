import java.math.BigInteger;

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

    public BigInteger getx() {
        int l = this.period(), index;
        BigInteger[] p = new BigInteger[1000];
        BigInteger[] q = new BigInteger[1000];
        p[0] = new BigInteger("0");
        p[1] = new BigInteger("1");
        if (l % 2 == 0) {
            index = l;
        } else {
            index = 2 * l;
        }
        Quadratic now = this;
        //System.out.println(this.b);
        for (int i = 2; i <= index + 1; ++i) {
            int now_x = now.getInt();
            now = now.getNext();
            p[i] = p[i - 1].multiply(new BigInteger(Integer.toString(now_x))).add(p[i - 2]);
            //System.out.printf("%s %s\n", Integer.toString(now_x), p[i]);
        }
        //System.out.println("");
        return p[index + 1];
    }

    public int period() {
        Quadratic[] cache = new Quadratic[10000];
        Quadratic x = this;
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
}

public class p66 {
    public static boolean equal (double a, double b) {
        return Math.abs(a - b) < 1e-8;
    }
    public static void main (String[] args) {
        BigInteger now_x = BigInteger.ZERO, max_x = BigInteger.ZERO;
        int max_d = 0;
        for (int i = 1; i <= 1000; ++i) {
            if (! equal((int)Math.sqrt(i), Math.sqrt(i))) {
                now_x = new Quadratic(1, i, 0, 1).getx();
                if (now_x.compareTo(max_x) > 0) {
                    max_x = now_x;
                    max_d = i;
                }
            }
        }
        System.out.println(max_d);
    }
}
