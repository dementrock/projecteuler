import java.util.Arrays;
public class p78 {
    public static final int MAX = 1000000, MAXPENT = 1000, MOD = 1000000;
    public static int[] p = new int[MAX + 1];
    public static int[] pents = new int [2 * MAXPENT + 1];
    public static int pent (int n) {
        return n * (3 * n - 1) / 2;
    }
    public static void init () {
        for (int i = 1; i <= MAXPENT; ++i) {
            pents[2 * i - 1] = pent(-i);
            pents[2 * i] = pent(i);
        }
        Arrays.sort(pents);
    }
    public static void main (String[] args) {
        init();
        p[0] = p[1] = 1;
        for (int i = 2; ; ++i) {
            for (int j = 1; pents[j] <= i; ++j) {
                if (j % 4 == 1 || j % 4 == 2) {
                    p[i] = (p[i] + p[i - pents[j]]) % MOD;
                } else {
                    p[i] = (p[i] - p[i - pents[j]]) % MOD;
                }
            }
            if (p[i] == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
