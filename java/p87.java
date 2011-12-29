import java.util.Arrays;

public class p87 {
    public static final int MAX = 50000000;
    public static final int MAXN = 8000;
    public static boolean[] isprime = new boolean[MAXN + 1];
    public static boolean[] isexpressed = new boolean[MAX];
    public static int primes[];
    public static int cntPrimes = 0;
    public static void sieve() {
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i <= MAXN; ++i) {
            if (isprime[i]) {
                ++cntPrimes;
                for (int j = i + i; j <= MAXN; j += i) {
                    isprime[j] = false;
                }
            }
        }
        primes = new int[cntPrimes];
        cntPrimes = 0;
        for (int i = 2; i <= MAXN; ++i) {
            if (isprime[i]) {
                primes[cntPrimes++] = i;
            }
        }
    }
    public static boolean isPrime (int num) {
        return isprime[num];
    }
    public static int pow (int i, int j) {
        return (int) Math.pow(i, j);
    }
    public static void main (String[] args) {
        int ans = 0;
        sieve();        
        for (int i = 0; i < cntPrimes && pow(primes[i], 2) < MAX; ++i) {
            for (int j = 0; j < cntPrimes && pow(primes[i], 2) + pow(primes[j], 3) < MAX; ++j) {
                for (int k = 0; k < cntPrimes && pow(primes[i], 2) + pow(primes[j], 3) + pow(primes[k], 4) < MAX; ++k) {
                    isexpressed[pow(primes[i], 2) + pow(primes[j], 3) + pow(primes[k], 4)] = true;
                }
            }
        }
        for (int i = 0; i < MAX; ++i) {
            if (isexpressed[i]) {
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
