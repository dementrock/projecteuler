import java.util.Arrays;
public class p12 {
    public static final int MAX = 1000000;
    public static boolean isprime[];
    public static int primes[];
    public static int cntPrimes = 0;
    public static void sieve() {
        isprime = new boolean[MAX + 1];
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i <= MAX; ++i) {
            if (isprime[i]) {
                ++cntPrimes;
                for (int j = i + i; j <= MAX; j += i) {
                    isprime[j] = false;
                }
            }
        }
        primes = new int[cntPrimes];
        cntPrimes = 0;
        for (int i = 2; i <= MAX; ++i) {
            if (isprime[i]) {
                primes[cntPrimes++] = i;
            }
        }
    }
    public static boolean isPrime (int num) {
        return isprime[num];
    }
    public static int getCntDivisors (int num) {
        int ans = 1;
        for (int i = 0; i < cntPrimes && num > 1; ++i) {
            int exp = 0;
            while (num % primes[i] == 0) {
                ++exp;
                num /= primes[i];
            }
            ans *= exp + 1;
        }
        return ans;
    }
    public static void main (String args[]) {
        sieve();
        for (int i = 1; ; ++i) {
            int num = i * (i + 1) / 2;
            if (getCntDivisors(num) > 500) {
                System.out.println(num);
                break;
            }
        }
    }
}
