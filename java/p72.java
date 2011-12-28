public class p72 {
    public static final int MAX = 1000000;
    public static int[] phis = new int[MAX + 1];
    public static int phi (int num) {
        if (phis[num] > 0) {
            return phis[num];
        }
        if (num == 1) {
            return phis[num] = 1;
        }
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                int x = num, exp = 0;
                while (x % i == 0) {
                    x /= i;
                    ++exp;
                }
                return phis[num] = (int) Math.pow(i, exp - 1) * (i - 1) * phi(x);
            }
        }
        return phis[num] = num - 1;
    }
    public static void main (String[] args) {
        long ans = 0;
        for (int i = 2; i <= MAX; ++i) {
            ans += phi(i);
        }
        System.out.println(ans);
    }
}
