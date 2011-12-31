package acm;

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

/* Solve equation of the form x^2 - dy^2 = c, where c = 1 or c = -1. */
public class PellSolver {
    private int d;
    private int c; // Must be 1 or -1
    private Quadratic now;
    private int period;
    private int prevIndex;
    private boolean solvable;
    private BigInteger[] p; // Store intermediate values of denominator
    private BigInteger[] q; // nominator

    public PellSolver (int d, int c) {
        this.init(d, c, 1000);
    }

    public PellSolver (int d, int c, int maxSolution) {
        this.init(d, c, maxSolution);
    }

    private void init(int d, int c, int maxSolution) {
        this.d = d;
        this.c = c;
        this.now = new Quadratic(1, d, 0, 1);
        this.period = now.period();
        this.solvable = (c == 1 || c == -1 && period % 2 == 1);
        if (solvable) {
            this.prevIndex = 1;
            maxSolution = Math.max(1, maxSolution);
            this.p = new BigInteger[maxSolution + 10];
            this.q = new BigInteger[maxSolution + 10];
            p[0] = q[1] = BigInteger.ZERO;
            p[1] = q[0] = BigInteger.ONE;
        }
    }

    private boolean isSolutionIndex (int index) {
        if (this.period % 2 == 0) {
            if (this.c == 1) {
                return (index - 1) % this.period == 0 && (index - 1) / this.period >= 1;
            }
        } else {
            if (this.c == 1) {
                return (index - 1) % this.period == 0 && (index - 1) / this.period >= 2 && ((index - 1) / this.period) % 2 == 0;
            } else if (this.c == -1) {
                return (index - 1) % this.period == 0 && (index - 1) / this.period >= 1 && ((index - 1) / this.period) % 2 == 1;
            }
        }
        return false;
    }

    /* Return a solution pair {x, y} */
    public BigInteger[] getNext() {
        if (solvable) {
            for (int i = ++this.prevIndex; ; i = ++this.prevIndex) {
                int now_x = this.now.getInt();
                this.now = this.now.getNext();
                this.p[i] = this.p[i - 1].multiply(BigInteger.valueOf(now_x)).add(this.p[i - 2]);
                this.q[i] = this.q[i - 1].multiply(BigInteger.valueOf(now_x)).add(this.q[i - 2]);
                if (this.isSolutionIndex(i)) {
                    BigInteger[] res = {p[i], q[i]};
                    return res;
                }
            }
        }
        BigInteger[] res = {BigInteger.ZERO, BigInteger.ZERO};
        return res;
    }
}
