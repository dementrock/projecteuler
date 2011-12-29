/* Let the total number of discs be k, and the number of blue discs be x. Then
 * 2x(x - 1) = k(k - 1). So x = (1 + sqrt(2k^2 - 2k + 1)) / 2. So 2k^2 - 2k + 1
 * must be a perfect square. Say 2k^2 - 2k + 1 = m^2 for some integer m. Then k
 * = (1 + sqrt(2m^2 - 1)) / 2. So 2m^2 - 1 is a perfect square. Say 2m^2 - 1 =
 * n^2 for some integer n. Then n^2 - 2m^2 = -1. This is of the form of
 * Diophantine equation, and can be solved using continued fractions.
 */

import java.math.BigInteger;

class Quadratic {

    public int a, b, c, d; // Fraction (a*sqrt(b) + c) / d

    public static final BigInteger maxValue = BigInteger.valueOf(1000000000000L);

    public static final BigInteger TWO = BigInteger.valueOf(2);

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

    public BigInteger bigSqrt (BigInteger lowerbound, BigInteger upperbound, BigInteger x) {
        while (lowerbound.compareTo(upperbound) <= 0) {
            BigInteger mid = lowerbound.add(upperbound).divide(TWO);
            int cmpResult = mid.multiply(mid).compareTo(x);
            if (cmpResult == 0) {
                return mid;
            } else if (cmpResult < 0) {
                lowerbound = mid.add(BigInteger.ONE);
            } else {
                upperbound = mid.subtract(BigInteger.ONE);
            }
        }
        return lowerbound;
    }

    public BigInteger calcKFromN (BigInteger n) {
        return n.add(BigInteger.ONE).divide(TWO);
    }

    public BigInteger calcXfromK (BigInteger k) {
        return bigSqrt(BigInteger.ONE, k.multiply(k).multiply(TWO), k.multiply(k).multiply(TWO).subtract(k.multiply(TWO)).add(BigInteger.ONE)).add(BigInteger.ONE).divide(TWO);
    }


    public BigInteger getx() { // Get the value of n in the equation n^2 - 2m^2 = -1
        int l = this.period(), index;
        BigInteger[] p = new BigInteger[1000];
        BigInteger[] q = new BigInteger[1000];
        p[0] = BigInteger.valueOf(0);
        p[1] = BigInteger.valueOf(1);
        Quadratic now = this;
        for (int i = 2; ; ++i) {
            int now_x = now.getInt();
            now = now.getNext();
            p[i] = p[i - 1].multiply(new BigInteger(Integer.toString(now_x))).add(p[i - 2]);
            if ((i - 1) % l == 0 && ((i - 1) / l) % 2 == 1) {
                BigInteger k = calcKFromN(p[i]);
                if (k.compareTo(maxValue) > 0) {
                    return calcXfromK(k);
                }
            }
        }
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

public class p100 {
    public static void main (String[] args) {
        System.out.println(new Quadratic(1, 2, 0, 1).getx());
    }
}
