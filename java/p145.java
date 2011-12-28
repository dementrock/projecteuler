public class p145 {
    public static boolean isSatisfied (int num) {
        int tmp = num, reverse = 0, sum;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        sum = num + reverse;
        while (sum > 0) {
            if (sum % 2 == 0) {
                return false;
            }
            sum /= 10;
        }
        return true;
    }
    public static final int MAX = 1000000000;
    public static void main (String[] args) {
        int cnt = 0;
        for (int i = 1; i < MAX; ++i) {
            if (i % 10 != 0) {
                if (isSatisfied(i)) {
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }
}
