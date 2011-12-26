import java.util.Arrays;
public class p7 {
    public static final int MAX = 1000001;
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
        int cnt = 0;
        for (int i = 1; i <= MAX; ++i) {
            if (isPrime(i)) {
                ++cnt;
            }
            if (cnt == 10001) {
                System.out.println(i);
                break;
            }
        }
    }
}
