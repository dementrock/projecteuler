import java.util.Arrays;
public class p70 {
    public static final int MAX = 10000000;
    public static boolean[] isPrime = new boolean[MAX + 1];
    public static int[] primes = new int[MAX + 1];
    public static int cntPrimes = 0;
    public static int[] calcPhi = new int[MAX + 1];
    public static void sieve() {
        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= MAX; ++i) {
            if (isPrime[i]) {
                primes[cntPrimes++] = i;
                for (int j = i + i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public static int phi (int x) {
        if (isPrime[x]) {
            return calcPhi[x] = x - 1;
        }
        int res = 1;
        for (int i = 0; primes[i] < x && i < cntPrimes; ++i) {
            if (x % primes[i] == 0) {
                return calcPhi[x] = calcPhi[primes[i]] * calcPhi[x / primes[i]];
            }
        }
        return calcPhi[x] = x - 1;
    }
    public static boolean isPermutation (int x, int y) {
        String str_x = Integer.toString(x), str_y = Integer.toString(y);
        if (str_x.length() != str_y.length()) {
            return false;
        } else {
            int[] freqx = new int[10];
            int[] freqy = new int[10];
            Arrays.fill(freqx, 0);
            Arrays.fill(freqy, 0);
            for (int i = 0; i < str_x.length(); ++i) {
                ++freqx[str_x.charAt(i) - '0'];
                ++freqy[str_y.charAt(i) - '0'];
            }
            for (int i = 0; i <= 9; ++i) {
                if (freqx[i] != freqy[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main (String[] args) {
        double min_ratio = 1e10;
        int min_i = 0;
        sieve();
        for (int i = 2; i < 10000000; ++i) {
            int phii = phi(i);
            if (isPermutation(i, phii)) {
                if (i * 1.0 / phii < min_ratio) {
                    min_ratio = i * 1.0 / phii;
                    min_i = i;
                }
            }
        }
        System.out.println(min_i);
    }
}
