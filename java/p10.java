import java.util.Arrays;
public class p10 {
    public static final int MAX = 2000001;
    public static boolean isprime[];
    public static void sieve() {
        isprime = new boolean[MAX + 1];
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i <= MAX; ++i) {
            if (isprime[i]) {
                for (int j = i + i; j <= MAX; j += i) {
                    isprime[j] = false;
                }
            }
        }
    }
    public static boolean isPrime (int num) {
        return isprime[num];
    }
    public static void main (String args[]) {
        sieve();
        long sum = 0;
        for (int i = 1; i <= MAX; ++i) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
