/* Let f(i, j) denote the ways to write i as sum of primes no larger than
 * the jth prime. Then:
 * f(i, j) = f(i - prime[j], j) + f(i, j - 1)
 * With boundary conditions:
 * f(0, j) = 1 for all j >= 0
 * f(i, 0) = 0 for all i > 0
 */

import java.util.Arrays;

public class p77 {
    public static final int MAXN = 1000;
    public static final int MAXM = 1000;
    public static boolean[] isprime = new boolean[MAXM + 1];
    public static int primes[];
    public static int cntPrimes = 0;
    public static int[][] f = new int[MAXN + 1][MAXM + 1];
    public static boolean[][] isCalculated = new boolean[MAXN + 1][MAXM + 1];
    public static void sieve() {
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i <= MAXM; ++i) {
            if (isprime[i]) {
                ++cntPrimes;
                for (int j = i + i; j <= MAXM; j += i) {
                    isprime[j] = false;
                }
            }
        }
        primes = new int[cntPrimes];
        cntPrimes = 0;
        for (int i = 2; i <= MAXM; ++i) {
            if (isprime[i]) {
                primes[cntPrimes++] = i;
            }
        }
    }
    public static boolean isPrime (int num) {
        return isprime[num];
    }
    public static int calc (int i, int j) {
        if (isCalculated[i][j]) {
            return f[i][j];
        }
        isCalculated[i][j] = true;
        if (i == 0) {
            return f[i][j] = 1;
        } else if (j == 0) {
            return f[i][j] = 0;
        } else {
            if (primes[j - 1] <= i) {
                return f[i][j] = calc(i - primes[j - 1], j) + calc(i, j - 1);
            } else {
                return f[i][j] = calc(i, j - 1);
            }
        }
    }
    public static void main (String[] args) {
        sieve();        
        for (int i = 1; ; ++i) {
            if (calc(i, cntPrimes) > 5000) {
                System.out.println(i);
                break;
            }
        }
    }
}
