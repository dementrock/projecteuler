public class p5 {
    public static final long MAX = 20;
    public static long gcd (long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd (b % a, a);
    }
    public static long lcm (long a, long b) {
        return a * b / gcd(a, b);
    }
    public static void main (String args[]) {
        long ans = 1;
        for (int i = 1; i <= MAX; ++i) {
            ans = lcm (ans, i);
        }
        System.out.println(ans);
    }
}
