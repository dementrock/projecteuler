public class p86 {
    public static int getCntSolutions (int m) {
        int cnt = 0;
        for (int x = 1, y = m * m; x <= m; ++x, y = m * m / x) {
            if (m * m % x == 0 && 0 < y - x && y - x <= 4 * m && (y - x) % 2 == 0) {
                int s = (y - x) / 2; // s = a + b
                cnt += (Math.min(m, s - 1) - Math.max(1, s - m) + 1) / 2;
                if (s % 2 == 0 && s / 2 <= m) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    public static void main (String[] args) {
        int ans = 0;
        for (int i = 1; ; ++i) {
            ans += getCntSolutions(i);
            if (ans > 1000000) {
                System.out.println(i);
                break;
            }
        }
    }
}
