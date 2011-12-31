import java.util.Arrays;
public class p95 {
    public static final int MAX = 1000000;
    public static int[] cacheLength = new int[MAX + 1];
    public static boolean[] appeared = new boolean[MAX + 1];
    public static int[] next = new int[MAX + 1];
    public static boolean[] isprime = new boolean[MAX + 1];
    public static int primes[];
    public static int cntPrimes = 0;
    public static void sieve() {
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
    public static int getNext (int num) {
        int cacheNum = num, product = 1, exp = 1;
        if (isPrime(num)) {
            return 1;
        }
        for (int i = 0; i < cntPrimes && primes[i] <= num; ++i) {
            if (num == 1) {
                return product - cacheNum;
            } else if (isPrime(num)) {
                return product * (num + 1) - cacheNum;
            }
            if (num % primes[i] == 0) {
                exp = 1;
                while (num % primes[i] == 0) {
                    num /= primes[i];
                    exp *= primes[i];
                }
                product *= (exp * primes[i] - 1) / (primes[i] - 1);
            }
        }
        return product - cacheNum;
    }
    public static int getLength (int x) {
        if (appeared[x]) {
            return cacheLength[x];
        }
        int now = x, curLength = 0;
        do {
            appeared[now] = true;
            now = next[now];
            ++curLength;
            if (now > MAX || now < 0 || now < x) {
                return 0;
            }
        } while (now != x && !appeared[now]);
        if (appeared[now] && now != x) {
            now = x;
            do {
                appeared[now] = false;
                now = next[now];
                if (now > MAX || now < 0 || now < x) {
                    return 0;
                }
            } while (now != x && appeared[now]);   
            return 0;
        } else {
            return curLength;
        }
    }
    public static void main (String[] args) {
        int maxLength = 0, ans = 0;
        sieve();
        for (int i = 2; i <= MAX; ++i) {
            next[i] = getNext(i);
        }
        for (int i = 2, tmp; i <= MAX; ++i) {
            if ((tmp = getLength(i)) > maxLength) {
                maxLength = tmp;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
