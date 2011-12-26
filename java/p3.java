public class p3 {
    public static final long NUM = 600851475143L;
    public static boolean isPrime (int num) {
        int uplimit = (int) Math.sqrt(num);
        for (int i = 2; i <= uplimit; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main (String args[]) {
        int uplimit = (int) Math.sqrt(NUM), ans = 0;
        for (int i = 2; i <= uplimit; ++i) {
            if (NUM % i == 0) {
                if (isPrime(i)) {
                    ans = i;
                }
            }
        }
        System.out.println(ans);
    }
}
